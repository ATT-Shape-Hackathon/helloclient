package nickyhuynh.helloworld.browse;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import nickyhuynh.helloworld.R;

/**
 * Created by bummy on 7/8/17.
 */

public class BrowseAdapter extends RecyclerView.Adapter<BrowseAdapter.ViewHolder> {
    private final String TAG = "BrowseAdapter";

    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    protected LayoutManagerType currentLayoutManagerType;
    protected RecyclerView recyclerView;
    protected BrowseAdapter browseAdapter;
    protected RecyclerView.LayoutManager layoutManager;

    private ArrayList<String> dataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView companyName;
        public RecyclerView recyclerView;

        public CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
            companyName = (TextView) v.findViewById(R.id.company_name);
            recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        }

        public ViewHolder(View v) {
            super(v);
        }
    }

    public BrowseAdapter(ArrayList<String> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public BrowseAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_company, parent, false);
        final ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.companyName.setText(dataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.cardview_company;
    }

    public void setDataSet(ArrayList<String> companies) {
        this.dataSet = companies;
    }

    public String getItem(int position) {
        return dataSet.get(position);
    }

}
