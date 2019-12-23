package com.videoplay;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.SurfaceHolder;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by yeliang on 2019/12/23.
 */

public class PlayView  extends GLSurfaceView implements Runnable, SurfaceHolder.Callback, GLSurfaceView.Renderer {

    public PlayView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void run() {
        String videoPath = Environment.getExternalStorageDirectory() + "/video.mp4";
        open(videoPath, getHolder().getSurface());
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            setRenderer(this);
        }
    }

    public void start(){
        new Thread(this).start();
    }

    public native void open(String url, Object surface);

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {

    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int i, int i1) {

    }

    @Override
    public void onDrawFrame(GL10 gl10) {

    }
}