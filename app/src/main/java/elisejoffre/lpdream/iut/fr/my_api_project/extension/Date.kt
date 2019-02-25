package elisejoffre.lpdream.iut.fr.my_api_project.extension

import java.text.SimpleDateFormat
import java.util.*

fun Date.dateToString(): String {
    val dateCalendar: Calendar = Calendar.getInstance()
    dateCalendar.time = this

    val formatter = SimpleDateFormat("EEEE d MMMM yyyy", Locale.getDefault())

    return "le ${formatter.format(this)}"
}