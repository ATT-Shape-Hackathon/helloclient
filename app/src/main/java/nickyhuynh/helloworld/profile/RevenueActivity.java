package nickyhuynh.helloworld.profile;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import nickyhuynh.helloworld.R;
import nickyhuynh.helloworld.app.GenericActivity;

/**
 * Created by bummy on 7/9/17.
 */

public class RevenueActivity extends GenericActivity {

    private RelativeLayout cancel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenue);

        assignViews();
        assignVariables(savedInstanceState);
        assignHandlers();
    }

    private void assignViews() {
        cancel = (RelativeLayout) findViewById(R.id.cancel);
    }

    private void assignVariables(Bundle savedInstanceState) {

    }

    private void assignHandlers() {
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
