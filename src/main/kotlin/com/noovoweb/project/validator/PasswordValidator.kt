package com.noovoweb.project.validator

import com.noovoweb.validator.CustomValidator
import com.noovoweb.validator.ValidationContext
import com.noovoweb.validator.ValidationException


@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
@CustomValidator(
    validator = "com.noovoweb.project.validator.PasswordValidator::validateStrongPassword",
    message = "password.strong_password"
)
annotation class StrongPassword

/**
 * Custom Password validator.
 */
object PasswordValidator {
    private const val MIN_LENGTH = 8
    private const val MAX_LENGTH = 128

    /**
     * Validates that a password meets strong password requirements:
     * - Between 8-128 characters
     * - At least one uppercase letter (A-Z)
     * - At least one lowercase letter (a-z)
     * - At least one digit (0-9)
     */
    suspend fun validateStrongPassword(value: String?, context: ValidationContext): Boolean {
        if (value == null) return true

        val hasMinLength = value.length >= MIN_LENGTH
        val hasMaxLength = value.length <= MAX_LENGTH
        val hasUppercase = value.any { it.isUpperCase() }
        val hasLowercase = value.any { it.isLowerCase() }
        val hasDigit = value.any { it.isDigit() }

        return hasMinLength && hasMaxLength && hasUppercase && hasLowercase && hasDigit
    }
}