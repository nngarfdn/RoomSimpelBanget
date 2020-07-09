package com.iniudin.roomwordssample.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.iniudin.roomwordssample.model.Note

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("DELETE FROM note_table")
    fun deleteAllNotes()

    @Query("DELETE FROM note_table WHERE id=:noteId")
    fun deleteNote(noteId: String)

    @Query("SELECT * FROM note_table ")
    fun getAllNotes(): LiveData<List<Note>>
}