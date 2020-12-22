package com.example.mymusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LocalMusicAdapter extends RecyclerView.Adapter<LocalMusicAdapter.LocalMusicViewHolder> {
    Context context;
    List<LocalMusicBean> mDatas;

    public LocalMusicAdapter(Context context, List<LocalMusicBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @NonNull
    @Override
    public LocalMusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_local_music,parent,false);
        LocalMusicViewHolder holder=new LocalMusicViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LocalMusicViewHolder holder, int position) {
                LocalMusicBean musicBean=mDatas.get(position);
                holder.idTv.setText(musicBean.getId());
                holder.songTv.setText(musicBean.getSong());
                holder.singerTv.setText(musicBean.getSinger());
                holder.albumTv.setText(musicBean.getAlbum());
                holder.timeTv.setText(musicBean.getDuration());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class LocalMusicViewHolder extends RecyclerView.ViewHolder{
        TextView idTv,songTv,singerTv,albumTv,timeTv;
        public LocalMusicViewHolder(View itemView)
        {
            super(itemView);
            idTv=itemView.findViewById(R.id.item_local_music_num);
            songTv=itemView.findViewById(R.id.item_local_music_song);
            singerTv=itemView.findViewById(R.id.item_local_music_singer);
            albumTv=itemView.findViewById(R.id.item_local_music_album);
            timeTv=itemView.findViewById(R.id.item_local_music_durtion);

        }


    }
}
