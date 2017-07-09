package nickyhuynh.helloworld.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import nickyhuynh.helloworld.R;
import nickyhuynh.helloworld.app.GenericActivity;
import nickyhuynh.helloworld.app.SlidingTabLayout;
import nickyhuynh.helloworld.browse.BrowseFragment;
import nickyhuynh.helloworld.discover.DiscoverFragment;
import nickyhuynh.helloworld.dummy.Camera2BasicFragment;
import nickyhuynh.helloworld.message.MessageFragment;
import nickyhuynh.helloworld.profile.ProfileFragment;
import nickyhuynh.helloworld.record.RecordFragment;

/**
 * Created by bummy on 7/8/17.
 */

public class MainActivity extends GenericActivity {
    private final String TAG = "MainActivity";

    private Fragment fragments[];
    private int[] icons = {R.drawable.browse, R.drawable.discover, R.drawable.record, R.drawable.message, R.drawable.profile};

    private SlidingTabLayout tabs;
    private ViewPager pager;
    private MainPagerAdapter mainPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignViews();
        assignVariables(savedInstanceState);
        assignHandlers();
    }

    private void assignViews() {
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);
    }

    private void assignVariables(Bundle savedInstanceState) {
        fragments = new Fragment[5];
        fragments[0] = new BrowseFragment();
        fragments[1] = new DiscoverFragment();
        fragments[2] = new MessageFragment();
        fragments[3] = new MessageFragment();
        fragments[4] = new ProfileFragment();

        tabs.setTabs(5);
        tabs.setTabSetting(true);
        tabs.setSelectedIndicatorColors(0xFFFF0000);
        pager.setOffscreenPageLimit(4);

        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), fragments, icons);
        pager.setAdapter(mainPagerAdapter);
        tabs.setViewPager(pager);
    }

    private void assignHandlers() {

    }
}
