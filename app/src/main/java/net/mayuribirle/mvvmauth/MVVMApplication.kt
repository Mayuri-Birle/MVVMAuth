package net.mayuribirle.mvvmauth

import net.mayuribirle.mvvmauth.data.db.AppDatabase
import net.mayuribirle.mvvmauth.data.network.MyApi
import net.mayuribirle.mvvmauth.data.network.NetworkConnectionInterceptor
import net.mayuribirle.mvvmauth.data.repositories.UserRepository
import net.mayuribirle.mvvmauth.ui.auth.AuthViewModelFactory


import android.app.Application
import net.mayuribirle.mvvmauth.ui.home.profile.ProfileViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }


    }

}