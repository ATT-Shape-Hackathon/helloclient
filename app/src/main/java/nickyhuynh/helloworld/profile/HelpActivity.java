package nickyhuynh.helloworld.profile;

import android.os.Bundle;

import nickyhuynh.helloworld.R;
import nickyhuynh.helloworld.app.GenericActivity;

/**
 * Created by bummy on 7/9/17.
 */

public class HelpActivity extends GenericActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        assignViews();
        assignVariables(savedInstanceState);
        assignHandlers();
    }

    private void assignViews() {

    }

    private void assignVariables(Bundle savedInstanceState) {

    }

    private void assignHandlers() {

    }
}
