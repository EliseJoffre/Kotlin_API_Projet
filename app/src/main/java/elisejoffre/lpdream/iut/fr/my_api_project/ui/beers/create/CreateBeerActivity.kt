package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.create

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProviders
import elisejoffre.lpdream.iut.fr.my_api_project.R
import elisejoffre.lpdream.iut.fr.my_api_project.data.Beer
import elisejoffre.lpdream.iut.fr.my_api_project.data.BeerRepository
import kotlinx.android.synthetic.main.activity_create_beer.*

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.sdk27.coroutines.textChangedListener
import org.jetbrains.anko.uiThread
import java.util.*

class CreateBeerActivity : AppCompatActivity() {

    private val viewModel: CreateBeerViewModel by lazy { ViewModelProviders.of(this).get(CreateBeerViewModel::class.java) }


    private var datePickerDialog: DatePickerDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_beer)

        setupToolbar()
        setupViews()
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_create_beer, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        android.R.id.home -> {
            ActivityCompat.finishAfterTransition(this)
            true
        }
        R.id.confirm -> {
            doAsync {
                viewModel.insert()
                uiThread { ActivityCompat.finishAfterTransition(this@CreateBeerActivity) }
            }
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    private fun setupViews() {
        nameEditText.apply {
            requestFocus()
            textChangedListener { onTextChanged { charSequence, _, _, _ -> viewModel.name = charSequence.toString().capitalize() } }
        }

        tagEditText.textChangedListener { onTextChanged { charSequence, _, _, _ -> viewModel.tagline = charSequence.toString().capitalize() } }

        descriptionEditText.textChangedListener { onTextChanged { charSequence, _, _, _ -> viewModel.description = charSequence.toString().capitalize() } }



    }


}
