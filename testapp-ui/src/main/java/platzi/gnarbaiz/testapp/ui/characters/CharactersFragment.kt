package platzi.gnarbaiz.testapp.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import platzi.gnarbaiz.testapp.domain.model.CharacterEntity
import platzi.gnarbaiz.testapp.domain.model.Output
import platzi.gnarbaiz.testapp.ui.R
import platzi.gnarbaiz.testapp.ui.base.BaseFragment
import platzi.gnarbaiz.testapp.ui.databinding.FragmentListCharactersBinding
import platzi.gnarbaiz.testapp.ui.widgets.applyTheme

class CharactersFragment : BaseFragment() {
    private val charactersViewModel: CharacterViewModel by viewModels()
    private var binding: FragmentListCharactersBinding? = null
    private lateinit var charactersAdapter: CharactersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentListCharactersBinding.inflate(inflater, container, false).let {
        binding = it
        with(it) {
            headerTitle = getString(R.string.label_characters)
            root
        }
    }


    override fun subscribeUi() {
        binding?.let {
            it.swipeRefresh.applyTheme()
            charactersAdapter = CharactersAdapter(arrayListOf(), onCharacterClick)
            it.rvQuestions.adapter = charactersAdapter
            it.swipeRefresh.setOnRefreshListener {
                charactersViewModel.fetchCharacters()
            }
        }
        charactersViewModel.charactersList.observe(viewLifecycleOwner) { result ->

            binding?.swipeRefresh?.isRefreshing = when (result.status) {
                Output.Status.SUCCESS -> {
                    result.data?.let { list ->
                        charactersAdapter.update(list)
                    }
                    false
                }
                Output.Status.ERROR -> {
                    result.message?.let {
                        showError(it) {
                            charactersViewModel.fetchCharacters()
                        }
                    }
                    false
                }
                Output.Status.LOADING -> true

            }
        }
    }

    /**
     * @property onCharacterClick to handle the characters item click.
     */
    private val onCharacterClick: (character: CharacterEntity, view: View) -> Unit =
        { character, view ->
            val extras = FragmentNavigatorExtras(
                view to character.image
            )
            findNavController().navigate(
                R.id.list_to_details,
                CharacterDetailsFragment.Args(character).toBundle(),
                null,
                extras
            )
        }
}