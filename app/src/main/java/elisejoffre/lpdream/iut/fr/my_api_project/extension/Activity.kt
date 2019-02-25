package elisejoffre.lpdream.iut.fr.my_api_project.extension

import android.app.ActivityOptions
import android.content.Intent
import androidx.fragment.app.FragmentActivity
import elisejoffre.lpdream.iut.fr.my_api_project.R

fun FragmentActivity.startAnimatedActivity(intent: Intent) {
    startActivity(intent, ActivityOptions.makeCustomAnimation(this, R.anim.slide_in_left, R.anim.slide_out_left).toBundle())
}