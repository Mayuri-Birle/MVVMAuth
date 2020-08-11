package net.mayuribirle.mvvmauth.data.network.responses

import net.mayuribirle.mvvmauth.data.db.entities.Quote

data class QuotesResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)