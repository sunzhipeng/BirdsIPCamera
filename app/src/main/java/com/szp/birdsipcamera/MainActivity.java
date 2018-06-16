package com.szp.birdsipcamera;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.SurfaceView;

        import org.easydarwin.easyipcamera.camera.BirdsIPCamera;
        import org.easydarwin.easyipcamera.camera.MediaStream;
        import org.easydarwin.easyipcamera.util.Util;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    //默认分辨率
    int width = 640, height = 480;
    MediaStream mMediaStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mMediaStream = new MediaStream(getApplicationContext());
        //mMediaStream.updateResolution(width, height);

        //Log.d(TAG, "onCreate: RTSP IP = " + getRTSPAddr());

        Log.d(TAG, "onCreate: IP = " + Util.getLocalIpAddress());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        mMediaStream.destroyCamera();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    /**
     * 获取RTSP的URL的地址
     * @return
     */
    private String getRTSPAddr() {
        String ip = Util.getLocalIpAddress();
        String port = BirdsApplication.getBirdsApplication().getPort();
        String id = BirdsApplication.getBirdsApplication().getId();
        return String.format("rtsp://%s:%s/%s", ip, port, id);
    }


    private void startPlaying() {
        if (!mMediaStream.isOpen()) {


            mMediaStream.createCamera();
            mMediaStream.startPreview();
        } else {
            mMediaStream.stopChannel();
            mMediaStream.stopPreview();;
            mMediaStream.destroyCamera();
            if (mMediaStream.isOpen()) {
                mMediaStream.stopChannel();
            }
        }
    }


}
