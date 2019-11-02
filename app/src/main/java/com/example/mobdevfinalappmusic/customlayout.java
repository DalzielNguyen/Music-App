package com.example.mobdevfinalappmusic;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class customlayout  extends BaseAdapter {

    private List<Song> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public customlayout(Context aContext,  List<Song> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
            holder = new ViewHolder();
            holder.imgSong = (ImageView) convertView.findViewById(R.id.imgSong);
            holder.songName = (TextView) convertView.findViewById(R.id.songName);
            holder.singerName = (TextView) convertView.findViewById(R.id.singerName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Song country = this.listData.get(position);
        holder.songName.setText(country.getSongName());
        holder.singerName.setText("Singer: " + country.getSingerName());

        holder.imgSong.setImageResource(country.getSongImg());

        return convertView;
    }

    static class ViewHolder {
        ImageView imgSong;
        TextView singerName;
        TextView songName;
    }

}