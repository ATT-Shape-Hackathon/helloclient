package nickyhuynh.helloworld.stream;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import nickyhuynh.helloworld.R;
import nickyhuynh.helloworld.app.GenericActivity;

/**
 * Created by bummy on 7/9/17.
 */

public class StreamActivity extends GenericActivity {

    private VideoView videoStreamer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);

        assignViews();
        assignVariables(savedInstanceState);
        assignHandlers();
    }

    private void assignViews() {
        videoStreamer = (VideoView) findViewById(R.id.video_streamer);
    }

    private void assignVariables(Bundle savedInstanceState) {
        Uri uri = Uri.parse("https://s3.amazonaws.com/nickyweb/images/calhack/4.mp4");
        videoStreamer.setVideoURI(uri);
        videoStreamer.start();
    }

    private void assignHandlers() {

    }
}

