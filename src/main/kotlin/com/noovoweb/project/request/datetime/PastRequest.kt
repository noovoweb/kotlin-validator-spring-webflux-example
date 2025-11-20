package com.noovoweb.project.request.datetime

import com.noovoweb.validator.Past
import com.noovoweb.validator.Validated
import java.time.LocalDate

@Validated
data class PastRequest(
    @Past
    val date: LocalDate?
)
