package nickyhuynh.helloworld.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import nickyhuynh.helloworld.message.SendMessageActivity;
import nickyhuynh.helloworld.message.ShowMessageActivity;

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
}
