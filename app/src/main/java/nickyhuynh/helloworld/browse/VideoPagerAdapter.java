package nickyhuynh.helloworld.browse;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class VideoPagerAdapter extends RecyclerView.Adapter<VideoPagerAdapter.ViewHolder> {
    private final String TAG = "VideoPagerAdapter";

    private ArrayList<CompaniesDTO.Ad> dataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public ImageView add;
        public ImageView thumbnail;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
            add = (ImageView) v.findViewById(R.id.add);
            thumbnail = (ImageView) v.findViewById(R.id.thumbnail);
        }

        public ViewHolder(View v) {
            super(v);
        }
    }

    public VideoPagerAdapter(ArrayList<CompaniesDTO.Ad> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public VideoPagerAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_video, parent, false);
        final ViewHolder vh = new ViewHolder(v);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "asdfsadfsdf");

                if(vh.getLayoutPosition() != 0) {
                    ((GenericActivity) parent.getContext()).navigateToStream(dataSet.get(vh.getLayoutPosition()-1));
                } else {
                    ((GenericActivity) parent.getContext()).navigateToRecord();
                }
            }
        });

        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        if(position == 0) {
            holder.thumbnail.setVisibility(View.GONE);
            holder.add.setVisibility(View.VISIBLE);
        } else {
            holder.thumbnail.setVisibility(View.VISIBLE);
            holder.add.setVisibility(View.GONE);

            CompaniesDTO.Ad ad = dataSet.get(position-1);
            Picasso.with(Application.getInstance()).load(ad.thumbnail).fit().centerCrop().into(holder.thumbnail);
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.cardview_video;
    }

    public void setDataSet(ArrayList<CompaniesDTO.Ad> videos) {
        this.dataSet = videos;
    }

    public CompaniesDTO.Ad getItem(int position) {
        return dataSet.get(position);
    }

}
