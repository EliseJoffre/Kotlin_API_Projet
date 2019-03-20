package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.detail

import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
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