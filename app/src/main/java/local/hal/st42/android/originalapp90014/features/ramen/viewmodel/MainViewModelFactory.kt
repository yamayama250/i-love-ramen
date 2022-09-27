package local.hal.st42.android.originalapp90014.features.ramen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import local.hal.st42.android.originalapp90014.features.ramen.repository.RamenRepository

class MainViewModelFactory(
    private val repository: RamenRepository
): ViewModelProvider.NewInstanceFactory() {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel> create(modelClass: Class<T>): T
        = MainViewModel(repository) as T
}