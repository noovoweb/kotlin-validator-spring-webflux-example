package com.noovoweb.project.request.datetime

import com.noovoweb.validator.DateFormat
import com.noovoweb.validator.Validated

@Validated
data class DateFormatRequest(
    @DateFormat(format = "yyyy-MM-dd")
    val date: String?
)
