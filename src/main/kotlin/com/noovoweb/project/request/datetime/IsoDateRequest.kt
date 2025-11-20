package com.noovoweb.project.request.datetime

import com.noovoweb.validator.IsoDate
import com.noovoweb.validator.Validated

@Validated
data class IsoDateRequest(
    @IsoDate
    val date: String?
)
