package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.create

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import org.koin.androidx.viewmodel.ext.android.viewModel
import elisejoffre.lpdream.iut.fr.my_api_project.R
import elisejoffre.lpdream.iut.fr.my_api_project.databinding.ActivityCreateBeerBinding
import elisejoffre.lpdream.iut.fr.my_api_project.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_create_beer.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.*

class CreateBeerActivity : BaseActivity<CreateBeerViewModel, ActivityCreateBeerBinding>() {

    override val layout: Int = R.layout.activity_create_beer

    override val viewModel: CreateBeerViewModel by viewModel()

    override fun initView(savedInstanceState: Bundle?) {
        setupDatePicker()
        setupToolbar()
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

    private fun setupDatePicker() {


        first_brewedEditText.setOnClickListener{

            val cal = Calendar.getInstance()
            val y = cal.get(Calendar.YEAR)
            val m = cal.get(Calendar.MONTH)
            val d = cal.get(Calendar.DAY_OF_MONTH)

            val datepickerdialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                first_brewedEditText.setText("" + monthOfYear + "/" + year)
                viewModel.first_brewed.value= "" + monthOfYear + "/" + year
            }, y, m, d)

            datepickerdialog.show()
        }
    }
}
