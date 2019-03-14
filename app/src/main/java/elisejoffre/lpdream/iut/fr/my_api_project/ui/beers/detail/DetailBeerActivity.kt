package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.detail

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProviders
import elisejoffre.lpdream.iut.fr.my_api_project.R
import elisejoffre.lpdream.iut.fr.my_api_project.databinding.ActivityDetailBeerBinding
import kotlinx.android.synthetic.main.activity_detail_beer.*
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import elisejoffre.lpdream.iut.fr.my_api_project.data.locale.locale.BeerDatabase
import java.net.URL




class DetailBeerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBeerBinding

    private val viewModel: DetailBeerViewModel by lazy { ViewModelProviders.of(this).get(DetailBeerViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_beer)
        binding.setVariable(BR.viewModel, viewModel)
        binding.setLifecycleOwner(this)

        viewModel.beerId.value = intent.getIntExtra("id", 0)
        setupToolbar()

    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        android.R.id.home -> {
            ActivityCompat.finishAfterTransition(this)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
