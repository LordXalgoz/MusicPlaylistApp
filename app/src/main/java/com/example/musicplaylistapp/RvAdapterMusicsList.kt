package com.example.musicplaylistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvAdapterMusicsList : RecyclerView.Adapter<RvAdapterMusicsList.MusicItemViewHolder>{

    class MusicItemViewHolder internal constructor(itemView: View) :
            RecyclerView.ViewHolder(itemView){
            var textViewMusicItemViewTitle: TextView =
                itemView.findViewById(R.id.textViewMusicItemViewTitle)
            var textViewMusicItemViewAuthor: TextView =
                itemView.findViewById(R.id.textViewMusicItemViewAuthor)
            var buttonDeleteMusic: Button =
                itemView.findViewById(R.id.buttonDeleteMusic)
            }
    private var musicsManager: MusicsManager

    constructor(musicsManager: MusicsManager) {
        this.musicsManager = musicsManager
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicItemViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.musicitem_view, parent, false)

        return MusicItemViewHolder(v)
    }

    override fun onBindViewHolder(holder: MusicItemViewHolder, position: Int) {
        var musicItem: MusicItem = musicsManager.getByIndex(position)

        holder.textViewMusicItemViewTitle.text = musicItem.title
        holder.textViewMusicItemViewAuthor.text = musicItem.author

        holder.buttonDeleteMusic.setOnClickListener{
            musicsManager.deleteMusic(position)

            notifyItemRemoved(position)
            notifyItemRangeChanged(position, musicsManager.getCount())
        }
    }

    override fun getItemCount(): Int = musicsManager.getCount()
}