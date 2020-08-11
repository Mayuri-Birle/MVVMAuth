package net.mayuribirle.mvvmauth.data.repositories


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.mayuribirle.mvvmauth.data.db.AppDatabase
import net.mayuribirle.mvvmauth.data.db.entities.Quote
import net.mayuribirle.mvvmauth.data.network.MyApi
import net.mayuribirle.mvvmauth.data.network.SafeApiRequest
import net.mayuribirle.mvvmauth.utils.Coroutines

private val MINIMUM_INTERVAL = 6

class QuotesRepository(

    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {

    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.observeForever {
            saveQuotes(it)
        }
    }

    suspend fun getQuotes(): LiveData<List<Quote>> {
        return withContext(Dispatchers.IO) {
            fetchQuotes()
            db.getQuoteDao().getQuotes()
        }
    }

    private suspend fun fetchQuotes() {
        val response = apiRequest { api.getQuotes() }
        quotes.postValue(response.quotes)

    }

    private fun isFetchNeeded(): Boolean {
        return true
//        return ChronoUnit.HOURS.between(savedAt, LocalDateTime.now()) > MINIMUM_INTERVAL
    }


    private fun saveQuotes(quotes: List<Quote>) {
        Coroutines.io {
//            prefs.savelastSavedAt(LocalDateTime.now().toString())
            db.getQuoteDao().saveAllQuotes(quotes)
        }
    }

}