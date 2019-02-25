package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import elisejoffre.lpdream.iut.fr.my_api_project.R
import elisejoffre.lpdream.iut.fr.my_api_project.data.Beer
import elisejoffre.lpdream.iut.fr.my_api_project.data.BeerRepository
import kotlinx.android.synthetic.main.activity_detail_beer.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailBeerActivity : AppCompatActivity() {

    private var beer: Beer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_beer)

        doAsync {
            beer = BeerRepository.getById(intent.getIntExtra("id", 0) )
            uiThread {
                setupToolbar()
                setupViews()
            }
        }
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
        setSupportActionBar(toolbar)
        title = beer?.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupViews() {
        beer?.let { beer1 ->
            name.text = beer1.name
            tag.text = beer1.tagline
            description.text = beer1.description

        }
    }
}
