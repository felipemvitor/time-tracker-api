package com.felipe.timetracker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@SpringBootApplication
class TimeTrackerApplication

fun main(args: Array<String>) {
    runApplication<TimeTrackerApplication>(*args)
}
