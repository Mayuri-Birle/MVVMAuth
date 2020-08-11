package net.mayuribirle.mvvmauth.ui.home.quotes

import androidx.lifecycle.ViewModel
import net.mayuribirle.mvvmauth.data.repositories.QuotesRepository
import net.mayuribirle.mvvmauth.utils.lazyDeferred

class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {


    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}
