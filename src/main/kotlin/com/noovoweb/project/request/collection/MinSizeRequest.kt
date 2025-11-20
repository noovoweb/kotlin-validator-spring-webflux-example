package com.noovoweb.project.request.collection

import com.noovoweb.validator.MinSize
import com.noovoweb.validator.Validated

@Validated
data class MinSizeRequest(
    @MinSize(3)
    val items: List<String>?
)
