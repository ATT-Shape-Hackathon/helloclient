package nickyhuynh.helloworld.message;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import nickyhuynh.helloworld.R;
import nickyhuynh.helloworld.app.GenericActivity;

/**
 * Created by bummy on 7/8/17.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private final String TAG = "DiscoverAdapter";

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

    public MessageAdapter(ArrayList<String> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_message, parent, false);
        final ViewHolder vh = new ViewHolder(v);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Message message = dataSet.g[et(vh.getLayoutPosition());
                ((GenericActivity) parent.getContext()).navigateToMessageShow("bummies", "Hello world!");
            }
        });

        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return dataSet.size()+12;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.cardview_message;
    }

    public void setDataSet(ArrayList<String> videos) {
        this.dataSet = videos;
    }

    public String getItem(int position) {
        return dataSet.get(position);
    }

}
