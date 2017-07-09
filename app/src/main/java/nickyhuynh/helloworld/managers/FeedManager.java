package nickyhuynh.helloworld.managers;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.json.JSONObject;

import nickyhuynh.helloworld.app.Application;
import nickyhuynh.helloworld.dtos.CompaniesDTO;
import nickyhuynh.helloworld.dtos.DiscoverDTO;

/**
 * Created by bummy on 7/9/17.
 */

public enum FeedManager {
    INSTANCE;
    private Context context;
    private APIManager apiManager;

    private CompaniesDTO companiesDTO;
    private DiscoverDTO discoverDTO;

    FeedManager() {
        context = Application.getInstance();
        apiManager = new APIManager();
    }

    public interface ContentListener {
        void success(JSONObject response);
        void failed(VolleyError error);
    }

    public CompaniesDTO getCompaniesDTO() {
        return companiesDTO;
    }

    public DiscoverDTO getDiscoverDTO() {return discoverDTO;}

    public void getFeed(final ContentListener listener) {
        String url = "https://helloworld-7425e.firebaseio.com/.json";
        apiManager.makeAPICall(url, null, Request.Method.GET, context, new APIManager.APIListener() {
            @Override
            public void success(JSONObject response) {
                companiesDTO = new Gson().fromJson(response.toString(), CompaniesDTO.class);

                if (listener != null) {
                    listener.success(response);
                }
            }

            @Override
            public void failed(VolleyError error) {
                if (listener != null) {
                    listener.failed(error);
                }
            }
        });
    }

    public void getDiscoveries(final ContentListener listener) {
        String url = "https://helloworld-7425e.firebaseio.com/.json";
        apiManager.makeAPICall(url, null, Request.Method.GET, context, new APIManager.APIListener() {
            @Override
            public void success(JSONObject response) {
                 discoverDTO = new Gson().fromJson(response.toString(), DiscoverDTO.class);
                Log.d("asdfsadf", "" + discoverDTO.discoveries.size());

                if (listener != null) {
                    listener.success(response);
                }
            }

            @Override
            public void failed(VolleyError error) {
                if (listener != null) {
                    listener.failed(error);
                }
            }
        });
    }
}
