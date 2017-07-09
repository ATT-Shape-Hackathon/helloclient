package nickyhuynh.helloworld.discover;

import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import nickyhuynh.helloworld.R;
import nickyhuynh.helloworld.app.Application;
import nickyhuynh.helloworld.app.GenericActivity;
import nickyhuynh.helloworld.dtos.CompaniesDTO;

/**
 * Created by bummy on 7/8/17.
 */

public class DiscoverAdapter extends RecyclerView.Adapter<DiscoverAdapter.ViewHolder> {
    private final String TAG = "DiscoverAdapter";

    private ArrayList<CompaniesDTO.Ad> dataSet;

    private DisplayMetrics displayMetrics = new DisplayMetrics();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public ImageView thumbnail;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
            thumbnail = (ImageView) v.findViewById(R.id.thumbnail);
        }

        public ViewHolder(View v) {
            super(v);
        }
    }

    public DiscoverAdapter(ArrayList<CompaniesDTO.Ad> dataSet) {
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

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GenericActivity) parent.getContext()).navigateToStream(dataSet.get(vh.getLayoutPosition()));
            }
        });

        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        CompaniesDTO.Ad ad = dataSet.get(position);
        Picasso.with(Application.getInstance()).load(ad.thumbnail).fit().centerCrop().into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.cardview_discover;
    }

    public void setDataSet(ArrayList<CompaniesDTO.Ad> videos) {
        this.dataSet = videos;
    }

    public CompaniesDTO.Ad getItem(int position) {
        return dataSet.get(position);
    }

}

