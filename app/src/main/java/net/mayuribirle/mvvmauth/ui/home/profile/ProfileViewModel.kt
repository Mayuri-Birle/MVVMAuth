package net.mayuribirle.mvvmauth.ui.home.profile

import androidx.lifecycle.ViewModel
import net.mayuribirle.mvvmauth.data.repositories.UserRepository

class ProfileViewModel (
    repository: UserRepository
): ViewModel() {
    val user = repository.getUser()

}
