package local.hal.st42.android.originalapp90014.features.ramen.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import local.hal.st42.android.originalapp90014.database.AppDatabase
import local.hal.st42.android.originalapp90014.features.ramen.model.Ramen
import local.hal.st42.android.originalapp90014.features.ramen.repository.RamenRepository
import local.hal.st42.android.originalapp90014.features.ramen.repository.RamenRepositoryImpl
import java.sql.Date

class MainViewModel(
    private val repository: RamenRepository
): ViewModel() {
    val ramenList = repository.ramenList

    fun findById(id: Int): Flow<Ramen> {
        return repository.findById(id)
    }

    fun insertRamen(ramen: Ramen) {
        Completable.fromAction {
            repository.insertRamen(ramen)
        }.subscribeOn(Schedulers.io()).subscribe()
    }

    fun updateRamen(ramen: Ramen) {
        Completable.fromAction {
            repository.updateRamen(ramen)
        }.subscribeOn(Schedulers.io()).subscribe()
    }

    fun deleteRamen(ramen: Ramen) {
        Completable.fromAction {
            repository.deleteRamen(ramen)
        }.subscribeOn(Schedulers.io()).subscribe()
    }
}