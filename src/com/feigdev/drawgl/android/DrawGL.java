package com.feigdev.drawgl.android;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import android.content.Context;
import android.graphics.Color;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class DrawGL extends GLSurfaceView {
	private DrawGlRenderer renderer;
	private int red;
	private int blue;
	private int green;
	
	public DrawGL(Context context) {
		super(context);
        setEGLContextClientVersion(2);
		renderer = new DrawGlRenderer();
		setRenderer(renderer);
		setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}

	@Override 
	public boolean onTouchEvent(MotionEvent e) {
		updateColor();
		setBackgroundColor(Color.rgb(red, green, blue));
		requestRender();
		return true;
	}
	
	private void updateColor(){
		try{
			SecureRandom rnd = SecureRandom.getInstance("SHA1PRNG");
			red = rnd.nextInt(255); 
			blue = rnd.nextInt(255);
			green = rnd.nextInt(255);
		}
		catch (NoSuchAlgorithmException ex){
			System.err.println(ex);
		}

	}
}
