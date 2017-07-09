package nickyhuynh.helloworld.browse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.ArrayList;

import nickyhuynh.helloworld.R;
import nickyhuynh.helloworld.managers.FeedManager;

/**
 * Created by bummy on 7/8/17.
 */

public class BrowseFragment extends Fragment {
    private static final String TAG = "BrowseFragment";
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

    private RelativeLayout cancel;

    private AutoCompleteTextView search;
    private ArrayAdapter<String> searchAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_browse, container, false);

        assignViews(rootView);
        assignVariables(savedInstanceState);
        assignHandlers();

        return rootView;
    }

    private void assignViews(View rootView) {
        cancel = (RelativeLayout) rootView.findViewById(R.id.cancel);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        search = (AutoCompleteTextView) rootView.findViewById(R.id.search);

        //to remove focus from edittext
        rootView.findViewById(R.id.main_layout).requestFocus();
    }

    private void assignVariables(Bundle savedInstanceState) {
        searchAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, new ArrayList<String>());
        search.setAdapter(searchAdapter);
        FeedManager.INSTANCE.getFeed(new FeedManager.ContentListener() {
            @Override
            public void success(JSONObject response) {
                browseAdapter.setDataSet(new ArrayList<String>(FeedManager.INSTANCE.getCompaniesDTO().companies.keySet()), FeedManager.INSTANCE.getCompaniesDTO());
                browseAdapter.notifyDataSetChanged();

                searchAdapter.addAll(FeedManager.INSTANCE.getCompaniesDTO().names);
            }

            @Override
            public void failed(VolleyError error) {

            }
        });

        browseAdapter = new BrowseAdapter(new ArrayList<String>());

        layoutManager = new LinearLayoutManager(getActivity());
        currentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            currentLayoutManagerType = (LayoutManagerType) savedInstanceState.getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(currentLayoutManagerType);
        recyclerView.setAdapter(browseAdapter);
    }

    private void assignHandlers() {
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search.setText("");
                browseAdapter.setDataSet(new ArrayList<String>(FeedManager.INSTANCE.getCompaniesDTO().companies.keySet()), FeedManager.INSTANCE.getCompaniesDTO());
                browseAdapter.notifyDataSetChanged();
            }
        });

        search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<String> results = new ArrayList<String>();
                results.add(searchAdapter.getItem(position));
                browseAdapter.setDataSet(results, FeedManager.INSTANCE.getCompaniesDTO());
                browseAdapter.notifyDataSetChanged();
            }
        });

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(search.getText().length() > 0) {
                    cancel.setVisibility(View.VISIBLE);
                } else {
                    cancel.setVisibility(View.GONE);
                }

                searchAdapter.getFilter().filter(search.getText(), null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (recyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                layoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                currentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                layoutManager = new LinearLayoutManager(getActivity());
                currentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                layoutManager = new LinearLayoutManager(getActivity());
                currentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.scrollToPosition(scrollPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, currentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }
}
