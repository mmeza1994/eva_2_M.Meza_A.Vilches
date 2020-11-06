package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class INFO_ACT extends AppCompatActivity {

    private VideoView videoView;

    public void Maps(View v)
    {
        Intent i = new Intent(this, MAPS_ACT.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_n_f_o__a_c_t);

        videoView = (VideoView) findViewById(R.id.vd);


        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        videoView.setVideoURI(uri);


        MediaController media = new MediaController(this);
        videoView.setMediaController(media);


    }
}
