package nickyhuynh.helloworld.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import nickyhuynh.helloworld.message.SendMessageActivity;
import nickyhuynh.helloworld.message.ShowMessageActivity;
import nickyhuynh.helloworld.profile.HelpActivity;
import nickyhuynh.helloworld.profile.RevenueActivity;
import nickyhuynh.helloworld.profile.SettingsActivity;
import nickyhuynh.helloworld.record.CameraActivity;
import nickyhuynh.helloworld.stream.StreamActivity;

/**
 * Created by bummy on 7/8/17.
 */

public class GenericActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void navigateToMessageShow(String sender, String message) {
        Intent intent = new Intent();
        intent.putExtra("SENDER", sender);
        intent.putExtra("MESSAGE", message);
        intent.setClass(this, ShowMessageActivity.class);
        startActivity(intent);
    }

    public void navigateToMessageSend(String destination) {
        Intent intent = new Intent();
        intent.putExtra("DESTINATION", destination);
        intent.setClass(this, SendMessageActivity.class);
        startActivity(intent);
    }

    public void navigateToRevenue() {
        Intent intent = new Intent();
        intent.setClass(this, RevenueActivity.class);
        startActivity(intent);
    }

    public void navigateToSettings() {
        Intent intent = new Intent();
        intent.setClass(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void navigateToHelp() {
        Intent intent = new Intent();
        intent.setClass(this, HelpActivity.class);
        startActivity(intent);
    }

    public void navigateToStream() {
        Intent intent = new Intent();
        intent.setClass(this, StreamActivity.class);
        startActivity(intent);
    }

    public void navigateToRecord() {
        Intent intent = new Intent();
        intent.setClass(this, CameraActivity.class);
        startActivity(intent);
    }
}
