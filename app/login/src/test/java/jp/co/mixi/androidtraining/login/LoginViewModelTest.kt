package jp.co.mixi.androidtraining.login

import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class LoginViewModelTest {
    private val viewModel = LoginUiViewModel()

    @Test
    fun testLoginEnabled() {
        viewModel.setUserId("oid")
        viewModel.setPassword("passwor")
        assertFalse(viewModel.uiState.loginEnabled)
        viewModel.setUserId("oidy")
        viewModel.setPassword("password")
        assertTrue(viewModel.uiState.loginEnabled)
    }
}