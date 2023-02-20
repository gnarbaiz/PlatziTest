package platzi.gnarbaiz.testapp.ui.splash

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test
import platzi.gnarbaiz.testapp.domain.model.Output
import platzi.gnarbaiz.testapp.ui.BaseViewModelTest
import platzi.gnarbaiz.testapp.ui.observeForTesting
import platzi.gnarbaiz.testapp.ui.runBlockingMainTest

@ExperimentalCoroutinesApi
class SplashViewModelTest : BaseViewModelTest() {

    private lateinit var splashViewModel: SplashViewModel

    @Before
    fun setUp() {
        splashViewModel = SplashViewModel()
    }

    @Test
    fun `Given output When load returns Success`() = runBlockingMainTest {
        //WHEN
        splashViewModel.load()

        //THEN
        splashViewModel.isOk.observeForTesting {
            assert(splashViewModel.isOk.value?.status == Output.Status.LOADING)
        }
    }
}