package elisejoffre.lpdream.iut.fr.my_api_project.ui.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import elisejoffre.lpdream.iut.fr.my_api_project.BR
import elisejoffre.lpdream.iut.fr.my_api_project.data.model.BaseObject
import elisejoffre.lpdream.iut.fr.my_api_project.utils.OnItemClickListener

abstract class BaseViewHolder<T: BaseObject, V: ViewDataBinding>(private val viewDataBinding: V): RecyclerView.ViewHolder(viewDataBinding.root) {

    protected lateinit var item: T

    open fun bind(lifecycleOwner: LifecycleOwner, item: T, listener: OnItemClickListener<T>) {
        this.item = item
        viewDataBinding.setLifecycleOwner(lifecycleOwner)
        viewDataBinding.setVariable(BR.item, item)
        viewDataBinding.setVariable(BR.listener, listener)
        viewDataBinding.executePendingBindings()
    }
}