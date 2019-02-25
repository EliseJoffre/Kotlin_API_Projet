package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import elisejoffre.lpdream.iut.fr.my_api_project.R
import elisejoffre.lpdream.iut.fr.my_api_project.data.Beer
import kotlinx.android.synthetic.main.item_beer.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.sdk27.coroutines.onLongClick

class BeersAdapter: RecyclerView.Adapter<BeersAdapter.BeerViewHolder>() {

    var onClick: ((item: Beer) -> Unit)? = null
    var onLongClick: ((item: Beer) -> Unit)? = null

    private var data = listOf<Beer>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder =
            BeerViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                            R.layout.item_beer,
                            parent,
                            false
                    )
            )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        holder.bind(data[position], object:
                OnBeerClickListener {
            override fun onItemClick(beer: Beer) {
                onClick?.invoke(beer)
            }

            override fun onItemLongClick(beer: Beer) {
                onLongClick?.invoke(beer)
            }
        })
    }

    fun replaceData(newData: List<Beer>) {
        this.data = newData
        notifyDataSetChanged()
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