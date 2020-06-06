package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new_note.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekat2.marko_gajin_RM8517.R
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Note
import rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts.NoteContract
import rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels.NoteViewModel

class NewNoteActivity : AppCompatActivity(R.layout.activity_new_note) {

    private val noteViewModel: NoteContract.ViewModel by viewModel<NoteViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
    }

    private fun initListeners() {
        cancelBtn.setOnClickListener {
            finish()
        }
        saveBtn.setOnClickListener {
            val note = Note(0, titleEt.text.toString(), bodyEt.text.toString())
            noteViewModel.addNote(note)
            finish()
        }
    }
}