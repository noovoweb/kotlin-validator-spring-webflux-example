package com.noovoweb.project.request.file

import com.noovoweb.validator.Max
import com.noovoweb.validator.Required
import com.noovoweb.validator.Validated

@Validated
data class MaxFileSizeRequest(
    @Required
    @Max(5242880.0)
    val fileSize: Long?
)
