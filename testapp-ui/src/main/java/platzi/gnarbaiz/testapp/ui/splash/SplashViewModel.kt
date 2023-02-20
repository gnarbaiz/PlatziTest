package platzi.gnarbaiz.testapp.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import platzi.gnarbaiz.testapp.domain.model.Output
import platzi.gnarbaiz.testapp.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * ViewModel for Android Questions
 */

@HiltViewModel
class SplashViewModel @Inject constructor() : BaseViewModel() {

    private val _isOk = MutableLiveData<Output<Boolean>>()
    val isOk: LiveData<Output<Boolean>> = _isOk

    init {
        load()
    }

    /**
     * Method to show splash screen for few milli seconds to user.
     */
    fun load(timeMillis: Long = SPLASH_TIME) {
        _isOk.value = Output.loading()
        viewModelScope.launch {
            delay(timeMillis = timeMillis)
            _isOk.postValue(Output.success(true))
        }
    }

    companion object {
        const val SPLASH_TIME = 800L
    }
}