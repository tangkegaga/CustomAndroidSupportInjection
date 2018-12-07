package au.com.kaiwu.nestfragmentdagger

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MyApplication : /*Dagger*/Application() {


    /*override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }*/

}