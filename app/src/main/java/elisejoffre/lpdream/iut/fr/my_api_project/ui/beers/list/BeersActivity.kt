package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.beers.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import elisejoffre.lpdream.iut.fr.my_api_project.R
import elisejoffre.lpdream.iut.fr.my_api_project.data.locale.locale.Beer
import elisejoffre.lpdream.iut.fr.my_api_project.data.remote.BeersResponseCallback
import elisejoffre.lpdream.iut.fr.my_api_project.databinding.ActivityBeersBinding
import elisejoffre.lpdream.iut.fr.my_api_project.extension.showAction
import elisejoffre.lpdream.iut.fr.my_api_project.extension.showError
import elisejoffre.lpdream.iut.fr.my_api_project.extension.startAnimatedActivity
import elisejoffre.lpdream.iut.fr.my_api_project.ui.base.BaseActivity
import elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.beers.create.CreateBeerActivity
import elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.beers.detail.DetailBeerActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class BeersActivity : BaseActivity<BeersViewModel, ActivityBeersBinding>() {

    override val layout: Int = R.layout.activity_beers

    override fun setViewModel(): Class<BeersViewModel> = BeersViewModel::class.java

    private var beersAdapter = BeersAdapter(this)

    override fun initView(savedInstanceState: Bundle?) {
        setupAdapter()
        setupFab()
        setupRecyclerView()
        setupSwipeRefreshLayout()
    }


    private fun setupAdapter() {
        viewModel.beers.observe(this, Observer {
            beersAdapter.submitList(it)
        })

        beersAdapter.apply {
            onClick = { startAnimatedActivity(intentFor<DetailBeerActivity>("id" to it.id)) }
            onLongClick = { showDeletePopup(it) }
        }
    }

    private fun setupFab() {
        binding.fab.onClick { startAnimatedActivity(intentFor<CreateBeerActivity>()) }
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            addItemDecoration(DividerItemDecoration(this@BeersActivity, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(this@BeersActivity)
            adapter = beersAdapter
        }
    }

    private fun setupSwipeRefreshLayout() {
        binding.swipeRefreshLayout.apply {

            fun refresh() {
                isRefreshing = true
                viewModel.refresh(object: BeersResponseCallback {
                    override fun onSuccess() {
                        binding.root.showAction(getString(R.string.beers_loaded))
                        isRefreshing = false
                    }

                    override fun onError(throwable: Throwable) {
                        binding.root.showError(getString(R.string.beers_loading_error))
                        isRefreshing = false
                    }
                })
            }

            setOnRefreshListener { refresh() }
            post { refresh() }
        }
    }



    private fun showDeletePopup(beer: Beer) {
        alert(getString(R.string.delete_beer_warning, beer.name)) {
            yesButton { viewModel.delete(beer) }
            noButton { }
        }.show()
    }
}
