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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        startStopButton.setOnClickListener { presenter.onStartStopClicked() }
        refetchButton.setOnClickListener { presenter.onRefetchMetricsClicked() }
        presenter.onAttach(this)
    }

    override fun showPaused() {
        startStopButton.text = getString(R.string.start_feeding)
    }

    override fun showWorkingState() {
        startStopButton.text = getString(R.string.stop_feeding)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetouch()
    }

    override fun showAuthorsAndSongsAmount(authorsAmount: Long, songsAmount: Long) {
        amountTextView.text = getString(R.string.amount_of_authors_and_songs_main_text, authorsAmount, songsAmount)
    }

}
