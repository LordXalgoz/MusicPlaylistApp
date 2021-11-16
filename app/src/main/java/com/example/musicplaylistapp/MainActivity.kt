package com.example.musicplaylistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var buttonAddMusic:Button
    private lateinit var editTextMusicTitle:EditText
    private lateinit var editTextMusicAuthor:EditText
    private lateinit var recyclerViewMusicsList:RecyclerView

    private lateinit var musicsManager: MusicsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        musicsManager = MusicsManager()

        recyclerViewMusicsList = findViewById(R.id.recyclerViewMusicsList)
        var llm = LinearLayoutManager(applicationContext)
        recyclerViewMusicsList.layoutManager = llm

        editTextMusicTitle = findViewById(R.id.editTextMusicTitle)
        editTextMusicAuthor = findViewById(R.id.editTextMusicAuthor)

        buttonAddMusic = findViewById(R.id.buttonAddMusic)
        buttonAddMusic.setOnClickListener(buttonAddMusicClickListener)
    }

    private val buttonAddMusicClickListener : View.OnClickListener = View.OnClickListener {
        var title: String = editTextMusicTitle.text.toString()
        var author: String = editTextMusicAuthor.text.toString()

        editTextMusicTitle.text.clear()
        editTextMusicAuthor.text.clear()

        var musicItem = MusicItem(title, author)
        musicsManager.addMusic(musicItem)

        Toast.makeText(applicationContext,"Музыка успешно добавлена", Toast.LENGTH_LONG).show()

        var rvAdapterMusicsList = RvAdapterMusicsList(musicsManager)
        recyclerViewMusicsList.adapter = rvAdapterMusicsList
    }
}