package pet.dmitry.databaseperformancemetrics.ui

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.viewbinder.bindView
import pet.dmitry.databaseperformancemetrics.R

class MainActivity : AppCompatActivity(), MainView {

    val startStopButton by bindView<Button>(R.id.activity_main_start_stop_button)

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

    override fun showAuthorsAndSongsAmout(authorsAmount: Long, usersAmount: Long) {
    }

}
