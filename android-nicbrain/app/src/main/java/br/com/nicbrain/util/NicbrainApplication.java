package br.com.nicbrain.util;

import android.app.Application;
import android.content.Context;

import com.activeandroid.ActiveAndroid;


public class NicbrainApplication extends Application {

	private static Context mContext;

	@Override
	public void onCreate() {
		super.onCreate();
		ActiveAndroid.initialize(this);
		mContext = this;
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
		ActiveAndroid.dispose();
	}

	public static Context getContext(){
		return mContext;
	}



}
