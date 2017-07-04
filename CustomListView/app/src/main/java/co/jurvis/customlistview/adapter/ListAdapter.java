package co.jurvis.customlistview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

import co.jurvis.customlistview.R;
import co.jurvis.customlistview.model.Song;

/**
 * Created by jurvistan on 9/5/17.
 */

public class ListAdapter extends BaseAdapter {
    private List<Song> dataList = new LinkedList<>();

    public ListAdapter(List<Song> dataList) {
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView != null && convertView.getTag() != null) {
            viewHolder = (ViewHolder)convertView.getTag();
        } else {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }


        Song song = dataList.get(position);
        String durationInString = String.format("%02d:%02d", song.getDuration() / 60,  song.getDuration() % 60 );

        viewHolder.title.setText(song.getTitle());
        viewHolder.artist.setText(song.getArtist());
        viewHolder.duration.setText(durationInString);

        Picasso.with(parent.getContext())
                .load(song.getAlbumArtURL())
                .resize(100, 100)
                .centerCrop()
                .into(viewHolder.albumArt);

        return convertView;
    }

    private class ViewHolder {
        public TextView title, artist, duration;
        public ImageView albumArt;

        public ViewHolder(View itemView) {
            title = (TextView) itemView.findViewById(R.id.songArtist);
            artist = (TextView) itemView.findViewById(R.id.songTitle);
            duration = (TextView) itemView.findViewById(R.id.songDuration);
            albumArt = (ImageView) itemView.findViewById(R.id.albumArt);
        }
    }
}
