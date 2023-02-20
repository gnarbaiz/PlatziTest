package platzi.gnarbaiz.testapp.ui.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import platzi.gnarbaiz.testapp.domain.model.CharacterEntity
import platzi.gnarbaiz.testapp.ui.databinding.ItemCharacterBinding
import platzi.gnarbaiz.testapp.ui.widgets.setOnSafeClickListener

/**
 * RecyclerView Adapter to display *Characters*.
 *
 * @property list the list of Characters in this Adapter.
 * @property onCharacterClick is the item click listener.
 */
class CharactersAdapter(
    private val list: ArrayList<CharacterEntity>,
    private val onCharacterClick: (details: CharacterEntity, view: View) -> Unit
) : RecyclerView.Adapter<CharactersAdapter.CharacterHolder>() {

    /**
     * RecyclerView ViewHolder to display a Character.
     *
     * @property binding the binding class item layout.
     */
    inner class CharacterHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Method to bind data to layout.
         */
        fun bind(item: CharacterEntity) {
            binding.item = item
            binding.position = adapterPosition
            binding.root.setOnSafeClickListener {
                onCharacterClick.invoke(item, binding.profPic)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(inflater, parent, false)
        return CharacterHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    /**
     * Method to update the data set of adapter.
     */
    fun update(newList: List<CharacterEntity>) {
        list.clear()
        list.addAll(newList)
        notifyItemRangeChanged(0, list.size)
    }
}