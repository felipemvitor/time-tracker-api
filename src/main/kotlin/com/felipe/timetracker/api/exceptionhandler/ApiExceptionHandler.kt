package com.felipe.timetracker.api.exceptionhandler

import com.felipe.timetracker.domain.exeption.BusinessException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.OffsetDateTime

@ControllerAdvice
class ApiExceptionHandler : ResponseEntityExceptionHandler() {

    companion object {
        const val GENERIC_ERROR_MESSAGE = "An internal error occurred. " +
                "Try again later and if the problem persists, contact the system admin."
    }

    @Autowired
    private lateinit var messageSource: MessageSource

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val errorType = ApiErrorType.INVALID_DATA
        val detail = "One or more fields are invalid. Correct it and try again."

        val bindingResult = ex.bindingResult

        val errorObjects = bindingResult.allErrors.map {
            Object(
                name = if (it is FieldError) it.field else it.objectName,
                userMessage = messageSource.getMessage(it, LocaleContextHolder.getLocale())
            )
        }

        val apiError = createApiError(status, errorType, detail)
            .apply {
                userMessage = detail
                objects = errorObjects
            }

        return handleExceptionInternal(ex, apiError, headers, status, request)
    }

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(ex: BusinessException, request: WebRequest): ResponseEntity<Any> {
        val status = HttpStatus.BAD_REQUEST
        val detail = ex.message!!

        val apiError = createApiError(status, ApiErrorType.BUSINESS_ERROR, detail)
            .apply {
                userMessage = detail
            }

        return handleExceptionInternal(ex, apiError, HttpHeaders(), status, request)
    }

    private fun createApiError(httpStatus: HttpStatus, errorType: ApiErrorType, detailMessage: String): ApiError {
        return ApiError()
            .apply {
                timestamp = OffsetDateTime.now()
                status = httpStatus.value()
                type = errorType.path
                title = errorType.title
                detail = detailMessage
            }
    }

    data class Object(
        var name: String,
        var userMessage: String
    )

    class ApiError {
        var status: Int? = null
        var timestamp: OffsetDateTime? = null
        var type: String? = null
        var title: String? = null
        var detail: String? = null
        var userMessage: String? = null
        var objects: List<Object>? = null

    }

    enum class ApiErrorType(var path: String, var title: String) {
        INVALID_DATA("/invalid-data", "Invalid data"),
        SYSTEM_ERROR("/system-error", "System error"),
        INVALID_PARAMETER("/invalid-parameter", "Invalid parameter"),
        UNREADABLE_MESSAGE("/unreadable-message", "Unreadable message"),
        RESOURCE_NOT_FOUND("resource-not-found", "Resource not found"),
        ENTITY_BEING_USED("entity-being-used", "Entity being used"),
        BUSINESS_ERROR("business-error", "Business rule violation");
    }
}