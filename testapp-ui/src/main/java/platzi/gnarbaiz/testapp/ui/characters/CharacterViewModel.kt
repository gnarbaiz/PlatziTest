package platzi.gnarbaiz.testapp.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import platzi.gnarbaiz.testapp.domain.model.CharacterEntity
import platzi.gnarbaiz.testapp.domain.model.Output
import platzi.gnarbaiz.testapp.domain.usecase.CharactersUseCase
import platzi.gnarbaiz.testapp.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val charactersUseCase: CharactersUseCase) :
    BaseViewModel() {

    private val _charactersList = MutableLiveData<Output<List<CharacterEntity>>>()
    val charactersList: LiveData<Output<List<CharacterEntity>>> = _charactersList

    init {
        fetchCharacters()
    }

    /**
     * Method to fetch the characters data.
     */
    fun fetchCharacters() {
        viewModelScope.launch {
            charactersUseCase.execute().collect {
                _charactersList.value = it
            }
        }
    }
}