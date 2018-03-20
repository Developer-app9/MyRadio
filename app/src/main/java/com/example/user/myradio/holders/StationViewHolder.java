package com.example.user.myradio.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.myradio.R;
import com.example.user.myradio.model.Station;

/**
 * Created by User on 23/06/2017.
 */

public class StationViewHolder extends RecyclerView.ViewHolder{

    private ImageView mainImage;
    private TextView titleText;
    public StationViewHolder(View itemView) {
        super(itemView);
        this.mainImage=(ImageView)itemView.findViewById(R.id.main_image);
        this.titleText=(TextView)itemView.findViewById(R.id.main_text);
    }

    public void updateUI(Station station)
    {
        String uri = station.getImgUri();
        int resource = mainImage.getResources().getIdentifier(uri, null, mainImage.getContext().getPackageName());
        mainImage.setImageResource(resource);
        titleText.setText(station.getStationTitle());
    }
}
