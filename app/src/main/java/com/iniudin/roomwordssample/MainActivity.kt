package com.iniudin.roomwordssample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.iniudin.roomwordssample.database.NoteDatabase
import com.iniudin.roomwordssample.model.Note
import com.iniudin.roomwordssample.viewmodel.NoteVModel
import com.wajahatkarim3.roomexplorer.RoomExplorer

class MainActivity : AppCompatActivity() {

    private lateinit var noteViewModel: NoteVModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        noteViewModel = ViewModelProviders.of(this).get(NoteVModel::class.java)

//        noteViewModel.insert(Note(title = "note 1", description = "des 1"))
//        noteViewModel.insert(Note(title = "note 2", description = "des 2"))
//        noteViewModel.insert(Note(title = "note 3", description = "des 3"))
//        noteViewModel.update(Note(title = "note 3 update", description = "des 3"))
//        noteViewModel.delete(Note(title = "note 2", description = "des 2"))

        noteViewModel.getAllNotes().observe(this, Observer { notes ->

            for(note in notes){
                Log.d("cek", "onCreate: ${note.id}")
                if (note.id == 1) {
                    noteViewModel.update(Note(note.id, title = "update note 1", description = "update"))
                }
                if (note.id == 2){
                    noteViewModel.delete(Note(note.id, note.title, note.description))
                }
            }
        })

        RoomExplorer.show(this, NoteDatabase::class.java, "note_database")
    }
}