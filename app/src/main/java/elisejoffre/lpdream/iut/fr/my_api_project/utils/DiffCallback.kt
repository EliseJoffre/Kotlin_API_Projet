package elisejoffre.lpdream.iut.fr.my_api_project.utils

import androidx.recyclerview.widget.DiffUtil
import elisejoffre.lpdream.iut.fr.my_api_project.data.model.BaseObject

class DiffCallback<T: BaseObject>(private val updateWhen: ((T, T) -> Boolean)?): DiffUtil.ItemCallback<T>() {

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem && !(updateWhen?.invoke(oldItem, newItem) ?: false)
    }

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.id == newItem.id
    }
}