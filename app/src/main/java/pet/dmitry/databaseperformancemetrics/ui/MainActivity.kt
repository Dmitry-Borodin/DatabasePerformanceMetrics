package pet.dmitry.databaseperformancemetrics.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pet.dmitry.databaseperformancemetrics.R

class MainActivity : AppCompatActivity() {

    val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetouch()
    }
}
