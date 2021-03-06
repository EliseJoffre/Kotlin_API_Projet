package elisejoffre.lpdream.iut.fr.my_api_project.utils

import elisejoffre.lpdream.iut.fr.my_api_project.data.model.BaseObject

interface OnItemClickListener<T: BaseObject> {

    fun onItemClick(item: T)

    fun onItemLongClick(item: T): Boolean

}