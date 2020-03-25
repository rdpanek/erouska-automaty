package cz.covid19cz.app.ui.main

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import arch.livedata.SafeMutableLiveData
import cz.covid19cz.app.AppConfig
import cz.covid19cz.app.db.DatabaseRepository
import cz.covid19cz.app.db.ScanDataEntity
import cz.covid19cz.app.ext.daysToMilis
import cz.covid19cz.app.ext.execute
import cz.covid19cz.app.ext.minutesToMilis
import cz.covid19cz.app.ui.base.BaseVM
import cz.covid19cz.app.utils.L
import io.reactivex.Single
import org.koin.core.inject
import kotlin.random.Random

class MainVM(val database : DatabaseRepository): BaseVM() {

    val serviceRunning = SafeMutableLiveData(false)

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        //generateDummyData()
        deleteOldData()
    }

    private fun deleteOldData(){
        Single.just(true).map {
            L.d("Deleting data older than $it days")
            database.deleteOldData()
        }.execute({
            L.d("$it records deleted")
        },{
            L.e(it)
        })
    }
}