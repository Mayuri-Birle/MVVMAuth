package net.mayuribirle.mvvmauth.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_login.*
import net.mayuribirle.mvvmauth.R
import net.mayuribirle.mvvmauth.data.db.entities.User
import net.mayuribirle.mvvmauth.databinding.ActivityLoginBinding
import net.mayuribirle.mvvmauth.ui.home.HomeActivity
import net.mayuribirle.mvvmauth.utils.hide
import net.mayuribirle.mvvmauth.utils.show
import net.mayuribirle.mvvmauth.utils.snackbar
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()
    private val factory: AuthViewModelFactory by instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)

        val viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)

        binding.viewmodel = viewModel
        viewModel.authListener = this
        viewModel.getLoggedInUser().observe(this, Observer { user ->
            {
                if (user != null) {
                    Intent(this, HomeActivity::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                }
            }
        })
    }

    override fun onStarted() {

        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()

    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)
    }
}
