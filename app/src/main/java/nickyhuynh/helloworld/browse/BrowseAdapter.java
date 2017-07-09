package nickyhuynh.helloworld.browse;

import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import nickyhuynh.helloworld.R;
import nickyhuynh.helloworld.app.Application;
import nickyhuynh.helloworld.dtos.CompaniesDTO;
import nickyhuynh.helloworld.managers.FeedManager;

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

    protected LayoutManagerType currentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
    protected RecyclerView.LayoutManager layoutManager;

    private ArrayList<String> dataSet;
    private CompaniesDTO companiesDTO;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView companyName;
        public RecyclerView recyclerView;

        public VideoPagerAdapter videoPagerAdapter;

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

        holder.videoPagerAdapter = new VideoPagerAdapter(companiesDTO.companies.get(dataSet.get(position)));

        currentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        setRecyclerViewLayoutManager(currentLayoutManagerType, holder.recyclerView);
        holder.recyclerView.setAdapter(holder.videoPagerAdapter);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.cardview_company;
    }

    public void setDataSet(ArrayList<String> companies, CompaniesDTO companiesDTO) {
        this.dataSet = companies;
        this.companiesDTO = companiesDTO;
    }

    public String getItem(int position) {
        return dataSet.get(position);
    }

    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType, RecyclerView recyclerView) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (recyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                layoutManager = new GridLayoutManager(Application.getInstance(), SPAN_COUNT);
                currentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                layoutManager = new LinearLayoutManager(Application.getInstance(), LinearLayoutManager.HORIZONTAL, false);
                currentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                layoutManager = new LinearLayoutManager(Application.getInstance(), LinearLayoutManager.HORIZONTAL, false);
                currentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.scrollToPosition(scrollPosition);
    }
}
