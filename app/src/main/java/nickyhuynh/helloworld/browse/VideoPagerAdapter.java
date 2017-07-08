package nickyhuynh.helloworld.browse;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import nickyhuynh.helloworld.R;

/**
 * Created by bummy on 7/8/17.
 */

public class VideoPagerAdapter extends RecyclerView.Adapter<VideoPagerAdapter.ViewHolder> {
    private final String TAG = "BrowseAdapter";

    private ArrayList<String> dataSet;

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

    public VideoPagerAdapter(ArrayList<String> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public VideoPagerAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_company, parent, false);
        final ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataSet.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.cardview_company;
    }

    public void setDataSet(ArrayList<String> videos) {
        this.dataSet = videos;
    }

    public String getItem(int position) {
        return dataSet.get(position);
    }

}
