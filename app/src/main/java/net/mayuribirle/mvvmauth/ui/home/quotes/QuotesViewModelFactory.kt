package net.mayuribirle.mvvmauth.ui.home.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.mayuribirle.mvvmauth.data.repositories.QuotesRepository
import net.mayuribirle.mvvmauth.data.repositories.UserRepository

@Suppress("UNCHECKED_CAST")
class QuotesViewModelFactory (
    private val repository: QuotesRepository
): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModelFactory(repository) as T
    }
}