package com.noovoweb.project.request.numeric

import com.noovoweb.validator.Even
import com.noovoweb.validator.Validated

@Validated
data class EvenRequest(
    @Even
    val value: Int?
)
