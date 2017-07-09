package nickyhuynh.helloworld.profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nickyhuynh.helloworld.R;

/**
 * Created by bummy on 7/8/17.
 */

public class ProfileFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        assignViews(rootView);
        assignVariables(savedInstanceState);
        assignHandlers();

        return rootView;
    }

    private void assignViews(View rootView) {

    }

    private void assignVariables(Bundle savedInstanceState) {

    }

    private void assignHandlers() {

    }
}
