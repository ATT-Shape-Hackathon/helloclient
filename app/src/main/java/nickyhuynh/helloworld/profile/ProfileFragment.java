package nickyhuynh.helloworld.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nickyhuynh.helloworld.R;
import nickyhuynh.helloworld.app.Application;
import nickyhuynh.helloworld.app.CircularImageView;
import nickyhuynh.helloworld.main.MainActivity;

/**
 * Created by bummy on 7/8/17.
 */

public class ProfileFragment extends Fragment {

    private ImageView profileImage;
    private TextView username;

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
        profileImage = (CircularImageView) rootView.findViewById(R.id.profile_image);
        username = (TextView) rootView.findViewById(R.id.profile_name);
        SharedPreferences prefs = Application.getInstance().getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE);
        username.setText(prefs.getString("USERNAME", "Nicky Huynh"));

        revenue = (TextView) rootView.findViewById(R.id.revenue);
        settings = (TextView) rootView.findViewById(R.id.settings);
        help = (TextView) rootView.findViewById(R.id.help);
    }

    private void assignVariables(Bundle savedInstanceState) {
        Picasso.with(Application.getInstance()).load(R.drawable.image).into(profileImage);
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
