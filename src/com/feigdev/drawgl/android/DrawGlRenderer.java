package com.feigdev.drawgl.android;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

public class DrawGlRenderer implements GLSurfaceView.Renderer {

	public DrawGlRenderer(){
		
	}
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config){
		GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height){
		GLES20.glViewport(0, 0, width, height);
	}

	@Override
	public void onDrawFrame(GL10 gl){
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
	}

}
