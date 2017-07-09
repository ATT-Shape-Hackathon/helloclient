package nickyhuynh.helloworld.record;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nickyhuynh.helloworld.R;
import nickyhuynh.helloworld.app.Application;
import nickyhuynh.helloworld.app.GenericActivity;

import static android.content.ContentValues.TAG;

/**
 * Created by bummy on 7/8/17.
 */

public class RecordFragment extends Fragment {

    private AutoCompleteTextView company;
    private EditText username;
    private TextView record;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_record, container, false);

        assignViews(rootView);
        assignVariables(savedInstanceState);
        assignHandlers();

        return rootView;
    }

    private void assignViews(View rootView) {
        company = (AutoCompleteTextView) rootView.findViewById(R.id.company_name);
        username = (EditText) rootView.findViewById(R.id.username);
        record = (TextView) rootView.findViewById(R.id.record);

        rootView.findViewById(R.id.main_layout).requestFocus();
    }

    private void assignVariables(Bundle savedInstanceState) {
        SharedPreferences prefs = Application.getInstance().getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE);
        username.setHint(String.format("Post as? (Default: %s)", prefs.getString("USERNAME", "Nicky Huynh")));
    }

    private void assignHandlers() {
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(company.getText().toString().compareTo("") == 0) {
                    Toast.makeText(getActivity(), "Company cannot be blank!", Toast.LENGTH_SHORT).show();
                } else {
                    ((GenericActivity) getActivity()).navigateToRecord();
                }
            }
        });
    }
}
