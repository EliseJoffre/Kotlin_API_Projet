package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import elisejoffre.lpdream.iut.fr.my_api_project.R
import elisejoffre.lpdream.iut.fr.my_api_project.data.Beer
import elisejoffre.lpdream.iut.fr.my_api_project.data.BeerRepository
import elisejoffre.lpdream.iut.fr.my_api_project.extension.startAnimatedActivity
import elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.create.CreateBeerActivity
import elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.detail.DetailBeerActivity
import kotlinx.android.synthetic.main.activity_beers.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class BeersActivity : AppCompatActivity() {

    private val viewModel: BeersViewModel by lazy { ViewModelProviders.of(this).get(BeersViewModel::class.java) }
    private var beersAdapter = BeersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beers)

        setupAdapter()
        setupFab()
        setupRecyclerView()
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
        fab.onClick { startAnimatedActivity(intentFor<CreateBeerActivity>()) }
    }

    private fun setupRecyclerView() {
        recyclerView.apply {
            addItemDecoration(DividerItemDecoration(this@BeersActivity, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(this@BeersActivity) as RecyclerView.LayoutManager?
            adapter = beersAdapter
        }
    }

    private fun showDeletePopup(beer: Beer) {
        alert(getString(R.string.delete_beer_warning, beer.name)) {
            yesButton { viewModel.delete(beer) }
            noButton { }
        }.show()
    }
}
