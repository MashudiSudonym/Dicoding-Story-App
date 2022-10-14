package c.m.storyapp.register.presentation.screen

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import c.m.storyapp.databinding.ActivityRegisterBinding
import c.m.storyapp.login.presentation.screen.LoginActivity
import c.m.storyapp.register.presentation.view_model.RegisterViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private val registerViewModel: RegisterViewModel by viewModels()
    private lateinit var activityRegisterBinding: ActivityRegisterBinding
    private val onBackPressedCallback: OnBackPressedCallback =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                openLoginActivity()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRegisterBinding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = activityRegisterBinding.root
        setContentView(view)

        onBackPressedDispatcher.addCallback(onBackPressedCallback)

        activityRegisterBinding.btnSubmitRegister.setOnClickListener {
            registerViewModel.submitRegisterData(
                activityRegisterBinding.edtNameField.text.toString(),
                activityRegisterBinding.edtEmailField.text.toString(),
                activityRegisterBinding.edtPasswordField.text.toString()
            )

            lifecycleScope.launch {
                registerViewModel.registerUIState.collect { registerUIState ->
                    if (registerUIState.isLoading) {
                        activityRegisterBinding.loadingIndicator.visibility = View.VISIBLE
                    } else {
                        activityRegisterBinding.loadingIndicator.visibility = View.GONE
                    }

                    when {
                        registerUIState.isSuccess -> {
                            openLoginActivity()
                        }
                        registerUIState.isError -> {
                            Snackbar.make(view,
                                registerUIState.errorMessage?.asString(this@RegisterActivity)
                                    .toString(),
                                Snackbar.LENGTH_SHORT).show()
                        }
                    }

                    when {
                        registerUIState.nameFieldError != null -> {
                            activityRegisterBinding.tilNameField.apply {
                                isErrorEnabled = true
                                error =
                                    registerUIState.nameFieldError.asString(this@RegisterActivity)
                            }
                        }
                        else -> {
                            activityRegisterBinding.tilNameField.isErrorEnabled = false
                        }
                    }

                    when {
                        registerUIState.emailFieldError != null -> {
                            activityRegisterBinding.tilEmailField.apply {
                                isErrorEnabled = true
                                error =
                                    registerUIState.emailFieldError.asString(this@RegisterActivity)
                            }
                        }
                        else -> {
                            activityRegisterBinding.tilEmailField.isErrorEnabled = false
                        }
                    }

                    when {
                        registerUIState.passwordFieldError != null -> {
                            activityRegisterBinding.tilPasswordField.apply {
                                isErrorEnabled = true
                                error =
                                    registerUIState.passwordFieldError.asString(this@RegisterActivity)
                            }
                        }
                        else -> {
                            activityRegisterBinding.tilPasswordField.isErrorEnabled = false
                        }
                    }
                }
            }
        }
    }

    private fun openLoginActivity() {
        finish()
        startActivity(Intent(this, LoginActivity::class.java),
            ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }
}