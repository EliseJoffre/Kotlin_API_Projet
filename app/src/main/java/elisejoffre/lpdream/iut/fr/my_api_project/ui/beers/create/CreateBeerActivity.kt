package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.beers.create

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProviders
import elisejoffre.lpdream.iut.fr.my_api_project.R
import elisejoffre.lpdream.iut.fr.my_api_project.databinding.ActivityCreateBeerBinding
import elisejoffre.lpdream.iut.fr.my_api_project.ui.base.BaseActivity

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CreateBeerActivity : BaseActivity<CreateBeerViewModel, ActivityCreateBeerBinding>() {

    override val layout: Int = R.layout.activity_create_beer

    override val viewModel: CreateBeerViewModel by viewModel()

    override fun initView(savedInstanceState: Bundle?) {
        setupToolbar()
        setupViews()
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


    }



}
