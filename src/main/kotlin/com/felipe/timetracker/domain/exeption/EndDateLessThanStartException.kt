package com.felipe.timetracker.domain.exeption

class EndDateLessThanStartException
    : BusinessException("End date must be greater than the start date.")