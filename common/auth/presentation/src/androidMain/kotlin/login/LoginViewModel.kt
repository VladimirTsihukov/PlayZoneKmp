package login

import AuthRepository
import GamesRepository
import android.util.Log
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.launch
import login.models.LoginAction
import login.models.LoginEvent
import login.models.LoginViewState
import navigation.LogUtils

class LoginViewModel : BaseSharedViewModel<LoginViewState, LoginAction, LoginEvent>(
    initialState = LoginViewState("", "")
) {

    private val authRepository: AuthRepository = Inject.instance()

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.EmailChanged -> obtainEmailChanged(viewEvent.email)
            is LoginEvent.PasswordChanged -> obtainPasswordChanged(viewEvent.password)
            is LoginEvent.LoginClicked -> sendLogin()
            LoginEvent.ForgotClicked -> openForgot()
            LoginEvent.RegisterClicked -> openRegister()
            LoginEvent.PasswordShowClick -> changePasswordVisibility()
        }
    }

    private fun changePasswordVisibility() {
        viewState = viewState.copy(passwordHidden = !viewState.passwordHidden)
    }

    private fun sendLogin() {
        viewState = viewState.copy(isSending = true)

        viewModelScope.launch {
            viewState = try {
                val response = authRepository.login(viewState.email, viewState.password)

                if(response.token.isNotBlank()) {
                    viewState.copy(email = "", password = "", isSending = true)
                } else {
                    viewState.copy(isSending = false)
                }

            } catch (e: Exception) {
                Log.d(LogUtils.TAG, "error: $e")
                viewState.copy(isSending = false)
            }
        }
    }

    private fun obtainEmailChanged(email: String) {
        viewState = viewState.copy(email = email)
    }

    private fun obtainPasswordChanged(password: String) {
        viewState = viewState.copy(password = password)
    }

    private fun openForgot() {
        viewAction = LoginAction.OpenForgotPasswordScreen
    }

    private fun openRegister() {
        viewAction = LoginAction.OpenRegistrationScreen
    }
}