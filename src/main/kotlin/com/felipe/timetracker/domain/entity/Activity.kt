package com.felipe.timetracker.domain.entity

import com.felipe.timetracker.constants.DatabaseConstants.ACTIVITY_TABLE
import com.felipe.timetracker.constants.DatabaseConstants.CATEGORY_ID
import com.felipe.timetracker.constants.DatabaseConstants.DATE_END
import com.felipe.timetracker.constants.DatabaseConstants.DATE_START
import com.felipe.timetracker.constants.DatabaseConstants.NAME
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable
import javax.persistence.*

@Entity(name = ACTIVITY_TABLE)
data class Activity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @NotBlank
    @Column(name = NAME)
    var name: String,

    @NotNull
    @Column(name = DATE_START)
    var dateStart: Long,

    @NotNull
    @Column(name = DATE_END)
    var dateEnd: Long,

    @NotNull
    @ManyToOne
    @JoinColumn(name = CATEGORY_ID, nullable = false)
    var category: Category

) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Activity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}