package jp.co.mixi.androidtraining.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginUiViewModel = viewModel()
) {

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val uiState = viewModel.uiState
        TextField(
            value = uiState.userId, // TODO 入力した文字列が表示されるようにする
            onValueChange = viewModel::setUserId,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = stringResource(R.string.user_id)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii)
        )

        TextField(
            value = uiState.password, // TODO 入力した文字列が表示されるようにする
            onValueChange = viewModel::setPassword,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = stringResource(R.string.password)) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            enabled = uiState.loginEnabled // TODO ユーザーIDが4文字以上、かつパスワードが8文字以上入力されたら押せるようにする
        ) {
            Text(text = stringResource(R.string.login))
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    MaterialTheme {
        LoginScreen()
    }
}
