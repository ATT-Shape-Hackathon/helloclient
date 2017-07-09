package nickyhuynh.helloworld.managers;

import android.content.Context;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import nickyhuynh.helloworld.app.Application;

/**
 * Created by bummy on 7/9/17.
 */

public enum SDKManager {
    INSTANCE;
    private Context context;
    private APIManager apiManager;

    SDKManager() {
        context = Application.getInstance();
        apiManager = new APIManager();
    }

    public interface ContentListener {
        void success(JSONObject response);
        void failed(VolleyError error);
    }
}
