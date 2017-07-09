package nickyhuynh.helloworld.profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nickyhuynh.helloworld.R;
import nickyhuynh.helloworld.main.MainActivity;

/**
 * Created by bummy on 7/8/17.
 */

public class ProfileFragment extends Fragment {

    private TextView revenue;
    private TextView settings;
    private TextView help;

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
        revenue = (TextView) rootView.findViewById(R.id.revenue);
        settings = (TextView) rootView.findViewById(R.id.settings);
        help = (TextView) rootView.findViewById(R.id.help);
    }

    private void assignVariables(Bundle savedInstanceState) {

    }

    private void assignHandlers() {
        revenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).navigateToRevenue();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).navigateToSettings();
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).navigateToHelp();
            }
        });
    }
}
