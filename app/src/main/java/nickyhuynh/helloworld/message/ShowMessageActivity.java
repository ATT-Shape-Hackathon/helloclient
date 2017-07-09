package nickyhuynh.helloworld.message;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import nickyhuynh.helloworld.R;
import nickyhuynh.helloworld.app.GenericActivity;

/**
 * Created by bummy on 7/8/17.
 */

public class ShowMessageActivity extends GenericActivity {

    private TextView senderName;
    private RelativeLayout cancel;
    private RelativeLayout send;

    private TextView message;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message);

        assignViews();
        assignVariables(savedInstanceState);
        assignHandlers();
    }

    private void assignViews() {
        senderName = (TextView) findViewById(R.id.sender_name);

        cancel = (RelativeLayout) findViewById(R.id.cancel);
        send = (RelativeLayout) findViewById(R.id.send);

        message = (TextView) findViewById(R.id.message);
    }

    private void assignVariables(Bundle savedInstanceState) {
        Intent intent = this.getIntent();
        senderName.setText(intent.getStringExtra("SENDER"));
        message.setText(intent.getStringExtra("MESSAGE"));
    }

    private void assignHandlers() {
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                navigateToMessageSend(getIntent().getStringExtra("SENDER"));
            }
        });
    }
}
