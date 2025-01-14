package com.example.myapplication

import org.junit.Assert.*
import org.junit.Test

class CredentialsManagerTest {

    @Test
    fun testEmptyEmail() {
        val email = ""
        assertFalse(CredentialsManager.isValidEmail(email)) // Should return false for empty email
    }

    @Test
    fun testWrongFormatEmail() {
        val email = "invalid_email.com"
        assertFalse(CredentialsManager.isValidEmail(email)) // Invalid email format
    }

    @Test
    fun testWellFormattedEmail() {
        val email = "example@test.com"
        assertTrue(CredentialsManager.isValidEmail(email)) // Valid email format
    }

    @Test
    fun testEmptyPassword() {
        val password = ""
        assertFalse(CredentialsManager.isValidPassword(password)) // Empty password should be invalid
    }

    @Test
    fun testFilledPassword() {
        val password = "securePass123"
        assertTrue(CredentialsManager.isValidPassword(password)) // Filled password with valid length
    }

//    // Additional test cases for registration and login scenarios
//    @Test
//    fun testEmailAlreadyRegistered() {
//        val email = "already@registered.com"
//        // Simulating a case where the email is already registered (for registration)
//        assertFalse(CredentialsManager.isEmailAvailable(email)) // Assume we have this method to check availability
//    }
//
//    @Test
//    fun testEmailAvailableForRegistration() {
//        val email = "newuser@test.com"
//        // Simulate a new email that's available for registration
//        assertTrue(CredentialsManager.isEmailAvailable(email)) // Email should be available
//    }
//
//    @Test
//    fun testCorrectPasswordForLogin() {
//        val email = "example@test.com"
//        val password = "securePass123"
//        // Simulating a login with correct credentials
//        assertTrue(CredentialsManager.areCredentialsValid(email, password)) // Credentials should be valid for login
//    }
//
//    @Test
//    fun testIncorrectPasswordForLogin() {
//        val email = "example@test.com"
//        val password = "wrongPassword"
//        // Simulating a login with incorrect password
//        assertFalse(CredentialsManager.areCredentialsValid(email, password)) // Should fail if password doesn't match
//    }
}
