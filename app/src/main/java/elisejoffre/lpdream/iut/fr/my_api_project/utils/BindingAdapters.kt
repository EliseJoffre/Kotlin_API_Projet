package elisejoffre.lpdream.iut.fr.my_api_project.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import elisejoffre.lpdream.iut.fr.my_api_project.R

@BindingAdapter("cover")
fun cover(view: ImageView, coverUrl: String?) {
    Picasso.get()
            .load("$coverUrl")
            .error(R.drawable.ic_error_black_24dp)
            .into(view)
}