package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.beers.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import elisejoffre.lpdream.iut.fr.my_api_project.BR
import elisejoffre.lpdream.iut.fr.my_api_project.R
import elisejoffre.lpdream.iut.fr.my_api_project.data.model.Beer
import elisejoffre.lpdream.iut.fr.my_api_project.databinding.ItemBeerBinding
import elisejoffre.lpdream.iut.fr.my_api_project.ui.base.BaseAdapter
import elisejoffre.lpdream.iut.fr.my_api_project.ui.base.BaseViewHolder
import elisejoffre.lpdream.iut.fr.my_api_project.utils.OnItemClickListener


class BeersAdapter(lifecycleOwner: LifecycleOwner): BaseAdapter<Beer>(lifecycleOwner) {

    override fun layoutFor(position: Int): Int = R.layout.item_beer


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Beer, *> {
        val binding: ItemBeerBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false)
        return BeerViewHolder(binding)
    }

    class BeerViewHolder(private val binding: ItemBeerBinding) : BaseViewHolder<Beer, ItemBeerBinding>(binding) {

        override fun bind(lifecycleOwner: LifecycleOwner, item: Beer, listener: OnItemClickListener<Beer>) {
            super.bind(lifecycleOwner, item, listener)
            binding.name.text = item.name
        }
    }
}