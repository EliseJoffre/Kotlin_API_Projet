package elisejoffre.lpdream.iut.fr.my_api_project.ui.base

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel
import elisejoffre.lpdream.iut.fr.my_api_project.BR
import elisejoffre.lpdream.iut.fr.my_api_project.R
import elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.list.BeersActivity

abstract class BaseActivity<V: AndroidViewModel, B: ViewDataBinding>: AppCompatActivity() {

    protected abstract val layout: Int

    protected abstract val viewModel: V

    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layout)
        binding.setVariable(BR.viewModel, viewModel)
        binding.setLifecycleOwner(this)

        initView(savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        android.R.id.home -> {
            ActivityCompat.finishAfterTransition(this)
            true
        }
        else -> { super.onOptionsItemSelected(item) }
    }

    override fun finish() {
        super.finish()
        if (this !is BeersActivity) overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)

    }

    protected abstract fun initView(savedInstanceState: Bundle?)


}