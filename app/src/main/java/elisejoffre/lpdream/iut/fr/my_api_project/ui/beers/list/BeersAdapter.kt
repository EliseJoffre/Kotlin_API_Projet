package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import elisejoffre.lpdream.iut.fr.my_api_project.R
import elisejoffre.lpdream.iut.fr.my_api_project.data.Beer
import kotlinx.android.synthetic.main.item_beer.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.sdk27.coroutines.onLongClick

class BeersAdapter: ListAdapter<Beer, BeersAdapter.BeerViewHolder>(BeerDiffCallback()) {

    var onClick: ((item: Beer) -> Unit)? = null
    var onLongClick: ((item: Beer) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder =
            BeerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_beer, parent, false))


    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        holder.bind(getItem(position), object:
                OnBeerClickListener {
            override fun onItemClick(beer: Beer) {
                onClick?.invoke(beer)
            }

            override fun onItemLongClick(beer: Beer) {
                onLongClick?.invoke(beer)
            }
        })
    }


    class BeerDiffCallback: DiffUtil.ItemCallback<Beer>() {

        override fun areContentsTheSame(oldItem: Beer, newItem: Beer): Boolean = oldItem == newItem

        override fun areItemsTheSame(oldItem: Beer, newItem: Beer): Boolean = oldItem.id == newItem.id
    }

    class BeerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(beer: Beer, onBeerClickListener: OnBeerClickListener) {
            itemView.name.text = beer.name
            itemView.tagline.text = beer.tagline
            itemView.root.apply {
                onClick { onBeerClickListener.onItemClick(beer) }
                onLongClick { onBeerClickListener.onItemLongClick(beer) }
            }
        }
    }

    interface OnBeerClickListener {

        fun onItemClick(beer: Beer)

        fun onItemLongClick(beer: Beer)

    }
}