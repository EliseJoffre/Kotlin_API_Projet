package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.beers.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProviders
import elisejoffre.lpdream.iut.fr.my_api_project.R
import elisejoffre.lpdream.iut.fr.my_api_project.databinding.ActivityDetailBeerBinding
import elisejoffre.lpdream.iut.fr.my_api_project.ui.base.BaseActivity


class DetailBeerActivity : BaseActivity<DetailBeerViewModel, ActivityDetailBeerBinding>() {

    override val layout: Int = R.layout.activity_detail_beer

    override val viewModel: DetailBeerViewModel by viewModel()
    override fun initView(savedInstanceState: Bundle?) {
        viewModel.beerId.value = intent.getIntExtra("id", 0)
        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}