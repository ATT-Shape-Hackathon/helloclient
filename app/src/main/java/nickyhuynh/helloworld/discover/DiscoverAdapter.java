package nickyhuynh.helloworld.discover;

import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import nickyhuynh.helloworld.R;
import nickyhuynh.helloworld.app.Application;
import nickyhuynh.helloworld.app.GenericActivity;

/**
 * Created by bummy on 7/8/17.
 */

public class DiscoverAdapter extends RecyclerView.Adapter<DiscoverAdapter.ViewHolder> {
    private final String TAG = "DiscoverAdapter";

    private ArrayList<String> dataSet;

    private DisplayMetrics displayMetrics = new DisplayMetrics();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }

        public ViewHolder(View v) {
            super(v);
        }
    }

    public DiscoverAdapter(ArrayList<String> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_discover, parent, false);
        final ViewHolder vh = new ViewHolder(v);

        ((GenericActivity) parent.getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);

        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) v.getLayoutParams();
        layoutParams.height = (displayMetrics.widthPixels-5*10)/4;

        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return dataSet.size()+12;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.cardview_discover;
    }

    public void setDataSet(ArrayList<String> videos) {
        this.dataSet = videos;
    }

    public String getItem(int position) {
        return dataSet.get(position);
    }

}

