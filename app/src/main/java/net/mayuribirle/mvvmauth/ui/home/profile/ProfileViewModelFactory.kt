package net.mayuribirle.mvvmauth.ui.home.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.mayuribirle.mvvmauth.data.repositories.UserRepository

@Suppress("UNCHECKED_CAST")
class ProfileViewModelFactory (
    private val repository: UserRepository
): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModelFactory(repository) as T
    }
}