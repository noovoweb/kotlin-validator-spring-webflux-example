package com.noovoweb.project.request.datetime

import com.noovoweb.validator.Today
import com.noovoweb.validator.Validated
import java.time.LocalDate

@Validated
data class TodayRequest(
    @Today
    val date: LocalDate?
)
