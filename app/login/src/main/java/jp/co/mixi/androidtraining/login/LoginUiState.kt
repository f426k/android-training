package jp.co.mixi.androidtraining.login

data class LoginUiState(
    val userId: String = "",
    val password: String = ""
) {
    val loginEnabled: Boolean
        get() = userId.length >= 4 && password.length >= 8
}
