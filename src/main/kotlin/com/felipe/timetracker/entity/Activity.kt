package com.felipe.timetracker.entity

import com.felipe.timetracker.constants.DatabaseConstants.ACTIVITY_TABLE
import com.felipe.timetracker.constants.DatabaseConstants.DATE_END
import com.felipe.timetracker.constants.DatabaseConstants.DATE_START
import com.felipe.timetracker.constants.DatabaseConstants.NAME
import java.io.Serializable
import javax.persistence.*

@Entity(name = ACTIVITY_TABLE)
data class Activity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = NAME)
    var name: String,

    @Column(name = DATE_START)
    var dateStart: Long,

    @Column(name = DATE_END)
    var dateEnd: Long

): Serializable