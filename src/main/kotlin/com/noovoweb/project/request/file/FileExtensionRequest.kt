package com.noovoweb.project.request.file

import com.noovoweb.validator.FileExtension
import com.noovoweb.validator.Required
import com.noovoweb.validator.Validated
import com.fasterxml.jackson.annotation.JsonAlias

@Validated
data class FileExtensionRequest(
    @JsonAlias("fileName")
    @Required
    @FileExtension(values = ["pdf", "doc", "docx", "txt"])
    val filename: String?
)
