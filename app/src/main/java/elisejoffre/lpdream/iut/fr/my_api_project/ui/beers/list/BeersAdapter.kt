package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import elisejoffre.lpdream.iut.fr.my_api_project.BR
import elisejoffre.lpdream.iut.fr.my_api_project.R
import elisejoffre.lpdream.iut.fr.my_api_project.data.locale.locale.Beer


class BeersAdapter: ListAdapter<Beer, BeersAdapter.BeerViewHolder>(BeerDiffCallback()) {

    var onClick: ((item: Beer) -> Unit)? = null
    var onLongClick: ((item: Beer) -> Unit)? = null

    override fun getItemViewType(position: Int): Int = R.layout.item_beer

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        val viewDataBinding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false)
        return BeerViewHolder(viewDataBinding)
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        holder.bind(getItem(position), object: OnBeerClickListener {
            override fun onItemClick(beer: Beer) {
                onClick?.invoke(beer)
            }

            override fun onItemLongClick(beer: Beer): Boolean {
                onLongClick?.invoke(beer)
                return true
            }
        })
    }

    class BeerDiffCallback: DiffUtil.ItemCallback<Beer>() {

        override fun areContentsTheSame(oldItem: Beer, newItem: Beer): Boolean = oldItem == newItem

        override fun areItemsTheSame(oldItem: Beer, newItem: Beer): Boolean = oldItem.id == newItem.id
    }

    class BeerViewHolder(private val viewDataBinding: ViewDataBinding): RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(beer: Beer, onBeerClickListener: OnBeerClickListener) {
            viewDataBinding.setVariable(BR.beer, beer)
            viewDataBinding.setVariable(BR.listener, onBeerClickListener)
            viewDataBinding.executePendingBindings()
        }
    }

    interface OnBeerClickListener {

        fun onItemClick(beer: Beer)

        fun onItemLongClick(beer: Beer): Boolean

    }
}