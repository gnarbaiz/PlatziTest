package platzi.gnarbaiz.testapp.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import platzi.gnarbaiz.testapp.domain.model.CharacterEntity
import platzi.gnarbaiz.testapp.ui.base.BaseFragment
import platzi.gnarbaiz.testapp.ui.databinding.FragmentCharacterDetailsBinding

class CharacterDetailsFragment : BaseFragment() {
    private var binding: FragmentCharacterDetailsBinding? = null
    private val characterItem by lazy { Args.fromBundle(arguments) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCharacterDetailsBinding.inflate(inflater, container, false).let {
        binding = it
        with(it) {
            lifecycleOwner = this@CharacterDetailsFragment
            item = characterItem.detail
            sharedElementEnterTransition =
                context?.let { context -> TransitionInflater.from(context).inflateTransition(android.R.transition.move) }
            root
        }
    }

    override fun subscribeUi() {
        binding?.btnBack?.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    class Args(val detail: CharacterEntity) {
        companion object {
            const val ARG_ITEM = "CharacterItem"
            fun fromBundle(bundle: Bundle?): Args {
                if (bundle == null)
                    throw IllegalStateException("Arguments must be passed to fragment")
                val details = bundle.getParcelable<CharacterEntity>(ARG_ITEM)
                    ?: throw IllegalStateException("CharacterEntity must be passed as an argument to fragment")
                return Args(details)
            }
        }

        fun toBundle() = bundleOf(ARG_ITEM to detail)
    }

}