package com.cctvjiatao.fragmentui;

import io.rong.imkit.RongIM;
import android.app.Application;
import android.content.Context;

/**
 * Created by Bob on 15/7/14.
 */
public class App extends Application {
	// userid
	public static String mTargetID = "47582";
	private Context context;

	@Override
	public void onCreate() {
		super.onCreate();
		RongIM.init(this);
	}
}
