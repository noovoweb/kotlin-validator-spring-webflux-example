package com.noovoweb.project.request.datetime

import com.noovoweb.validator.IsoDateTime
import com.noovoweb.validator.Validated

@Validated
data class IsoDateTimeRequest(
    @IsoDateTime
    val dateTime: String?
)
