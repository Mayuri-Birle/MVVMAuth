package net.mayuribirle.mvvmauth.ui.auth

import androidx.lifecycle.LiveData
import net.mayuribirle.mvvmauth.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}