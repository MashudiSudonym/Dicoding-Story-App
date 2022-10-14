package c.m.storyapp.login.presentation.screen

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import c.m.storyapp.authentication_check.presentation.view_model.AuthenticationCheckViewModel
import c.m.storyapp.databinding.ActivityLoginBinding
import c.m.storyapp.list_story.presentation.screen.ListStoryActivity
import c.m.storyapp.login.presentation.view_model.LoginViewModel
import c.m.storyapp.register.presentation.screen.RegisterActivity
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val loginViewModel: LoginViewModel by viewModels()
    private val authenticationCheckViewModel: AuthenticationCheckViewModel by viewModels()
    private lateinit var activityLoginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding = ActivityLoginBinding.inflate(layoutInflater)
        val view = activityLoginBinding.root
        setContentView(view)

        authenticationCheck()

        activityLoginBinding.btnRegisterNow.setOnClickListener {
            openRegisterActivity()
        }

        activityLoginBinding.btnSubmitLogin.setOnClickListener {
            loginViewModel.submitLoginData(
                activityLoginBinding.edtEmailField.text.toString(),
                activityLoginBinding.edtPasswordField.text.toString(),
            )

            lifecycleScope.launch {
                loginViewModel.loginUIState.collect { loginUIState ->
                    if (loginUIState.isLoading) {
                        activityLoginBinding.loadingIndicator.visibility = View.VISIBLE
                    } else {
                        activityLoginBinding.loadingIndicator.visibility = View.GONE
                    }

                    when {
                        loginUIState.isSuccess -> {
                            openListStoryActivity()
                        }
                        loginUIState.isError -> {
                            Snackbar.make(view,
                                loginUIState.errorMessage?.asString(this@LoginActivity).toString(),
                                Snackbar.LENGTH_SHORT).show()
                        }
                    }

                    when {
                        loginUIState.emailFieldError != null -> {
                            activityLoginBinding.tilEmailField.apply {
                                isErrorEnabled = true
                                error = loginUIState.emailFieldError.asString(this@LoginActivity)
                            }
                        }
                        else -> {
                            activityLoginBinding.tilEmailField.isErrorEnabled = false
                        }
                    }

                    when {
                        loginUIState.passwordFieldError != null -> {
                            activityLoginBinding.tilPasswordField.apply {
                                isErrorEnabled = true
                                error = loginUIState.passwordFieldError.asString(this@LoginActivity)
                            }
                        }
                        else -> {
                            activityLoginBinding.tilPasswordField.isErrorEnabled = false
                        }
                    }
                }
            }
        }
    }

    private fun openRegisterActivity() {
        startActivity(Intent(this, RegisterActivity::class.java),
            ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }

    private fun authenticationCheck() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    authenticationCheckViewModel.authenticationCheckUIState.collect { authUIState ->
                        if (authUIState.isLoading) {
                            activityLoginBinding.loadingIndicator.visibility = View.VISIBLE
                        } else {
                            activityLoginBinding.loadingIndicator.visibility = View.GONE
                        }

                        when {
                            authUIState.isError -> {
                                activityLoginBinding.loadingIndicator.visibility = View.GONE
                            }
                            authUIState.isAuthenticated -> {
                                activityLoginBinding.loadingIndicator.visibility = View.GONE
                                openListStoryActivity()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun openListStoryActivity() {
        finish()
        startActivity(Intent(this@LoginActivity, ListStoryActivity::class.java),
            ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }
}