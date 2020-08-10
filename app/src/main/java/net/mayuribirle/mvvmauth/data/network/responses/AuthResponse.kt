package net.mayuribirle.mvvmauth.data.network.responses

import net.mayuribirle.mvvmauth.data.db.entities.User

data class AuthResponse(
    val isSuccessful : Boolean?,
    val message: String?,
    val user: User?
)