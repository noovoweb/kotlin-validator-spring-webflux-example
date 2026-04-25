package com.noovoweb.project.request.datetime

import com.noovoweb.validator.Future
import com.noovoweb.validator.Validated
import java.time.LocalDate

@Validated
data class FutureRequest(
    @Future
    val date: LocalDate?
)
