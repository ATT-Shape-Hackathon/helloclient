package nickyhuynh.helloworld.message;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import nickyhuynh.helloworld.R;
import nickyhuynh.helloworld.app.GenericActivity;

/**
 * Created by bummy on 7/8/17.
 */

public class SendMessageActivity extends GenericActivity {

    private RelativeLayout cancel;
    private RelativeLayout confirm;

    private EditText destination;
    private EditText message;

    private View safety;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        assignViews();
        assignVariables(savedInstanceState);
        assignHandlers();
    }

    private void assignViews() {
        cancel = (RelativeLayout) findViewById(R.id.cancel);
        confirm = (RelativeLayout) findViewById(R.id.confirm);

        destination = (EditText) findViewById(R.id.destination);
        message = (EditText) findViewById(R.id.message);

        safety = findViewById(R.id.safety);
    }

    private void assignVariables(Bundle savedInstanceState) {
        Intent intent = this.getIntent();
        destination.setText(intent.getStringExtra("DESTINATION"));
    }

    private void assignHandlers() {
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //give focus to the message
                message.requestFocus();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this should take message and destination and send that person an email
                finish();
            }
        });
    }
}
