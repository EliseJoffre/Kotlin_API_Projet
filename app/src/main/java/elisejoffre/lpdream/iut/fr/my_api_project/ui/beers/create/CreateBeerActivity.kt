package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.create

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProviders
import elisejoffre.lpdream.iut.fr.my_api_project.R

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CreateBeerActivity : AppCompatActivity() {

    private lateinit var binding: elisejoffre.lpdream.iut.fr.my_api_project.databinding.ActivityCreateBeerBinding

    private val viewModel: CreateBeerViewModel by lazy { ViewModelProviders.of(this).get(CreateBeerViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_beer)
        binding.setVariable(BR.viewModel, viewModel)
        binding.setLifecycleOwner(this)

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
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupViews() {
        binding.nameEditText.requestFocus()
        binding.tagEditText.requestFocus()
        binding.descriptionEditText.requestFocus()

    }



}
