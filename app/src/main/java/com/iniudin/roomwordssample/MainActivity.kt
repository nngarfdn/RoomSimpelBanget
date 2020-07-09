package com.iniudin.roomwordssample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        noteViewModel.insert(Note(title = "note 1", description = "des 1"))
        noteViewModel.insert(Note(title = "note 2", description = "des 2"))
        noteViewModel.insert(Note(title = "note 3", description = "des 3"))


        RoomExplorer.show(this, NoteDatabase::class.java, "note_database")
    }
}