package nickyhuynh.helloworld.stream;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.gson.Gson;

import nickyhuynh.helloworld.R;
import nickyhuynh.helloworld.app.GenericActivity;
import nickyhuynh.helloworld.dtos.CompaniesDTO;

/**
 * Created by bummy on 7/9/17.
 */

public class StreamActivity extends GenericActivity {

    private VideoView videoStreamer;

    private RelativeLayout overlay;

    private TextView creator;
    private TextView likes;
    private TextView dislikes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_stream);

        assignViews();
        assignVariables(savedInstanceState);
        assignHandlers();
    }

    private void assignViews() {
        videoStreamer = (VideoView) findViewById(R.id.video_streamer);
        overlay = (RelativeLayout) findViewById(R.id.overlay);
        creator = (TextView) findViewById(R.id.creator);
        likes = (TextView) findViewById(R.id.likes_number);
        dislikes = (TextView) findViewById(R.id.dislikes_number);
    }

    private void assignVariables(Bundle savedInstanceState) {
        CompaniesDTO.Ad ad = new Gson().fromJson(getIntent().getStringExtra("AD"), CompaniesDTO.Ad.class);
        videoStreamer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        Uri uri = Uri.parse(ad.url);
        creator.setText(ad.creator);
        likes.setText(ad.likes+"");
        dislikes.setText(ad.dislikes+"");
        videoStreamer.setVideoURI(uri);
        videoStreamer.start();
    }

    private void assignHandlers() {
        videoStreamer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(overlay.getVisibility() == View.GONE) {
                    overlay.setVisibility(View.VISIBLE);
                } else {
                    overlay.setVisibility(View.GONE);
                }
                return false;
            }
        });
    }
}

