package pet.dmitry.databaseperformancemetrics.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.viewbinder.bindView
import pet.dmitry.databaseperformancemetrics.R

class MainActivity : AppCompatActivity(), MainView {

    private val startStopButton by bindView<Button>(R.id.activity_main_start_stop_button)
    private val refetchButton by bindView<Button>(R.id.activity_main_refetch_metrics_button)
    private val amountTextView by bindView<TextView>(R.id.activity_main_text_amount)

    private val presenter = MainPresenter()

    init {
        startStopButton.setOnClickListener { presenter.onStartStopClicked() }
        refetchButton.setOnClickListener { presenter.onRefetchMetricsClicked() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetouch()
    }

    override fun showAuthorsAndSongsAmout(authorsAmount: Long, usersAmount: Long) {
        amountTextView.text = getString(R.string.amount_of_authors_and_songs_main_text, authorsAmount, usersAmount)
    }

}
