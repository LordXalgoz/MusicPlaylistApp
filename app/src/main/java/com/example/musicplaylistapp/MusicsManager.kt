package com.example.musicplaylistapp

class MusicsManager {
    private var musics: ArrayList<MusicItem> = arrayListOf()
    private var id: Int = 0

    fun addMusic(musicItem: MusicItem){
        id++
        musicItem.id = id
        musics.add(musicItem)
    }

    fun deleteMusic(index: Int){
        musics.removeAt(index)
    }

    fun getByIndex(index: Int):MusicItem {
        return musics[index]
    }

    fun getCount():Int{
        return musics.size
    }
}