package com.noovoweb.project.request.file

import com.noovoweb.validator.MimeType
import com.noovoweb.validator.Required
import com.noovoweb.validator.Validated

@Validated
data class MimeTypeRequest(
    @Required
    @MimeType(values = ["image/jpeg", "image/png", "application/pdf"])
    val fileType: String?
)
