package com.cctvjiatao.fragmentui.activity;

import com.cctvjiatao.fragmentui.R;
import com.cctvjiatao.fragmentui.utils.SystemBarTintManager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;

/**
 * Created by Bob_ge on 15/7/26.
 */
public class BaseActivtiy extends ActionBarActivity {
	
	protected final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSystemBar();
        getSupportActionBar().setLogo(R.drawable.de_bar_logo);//actionbar 添加logo
    }

    private void initSystemBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            // Holo light action bar color is #DDDDDD
            int actionBarColor = Color.parseColor("#0195ff");
            tintManager.setStatusBarTintColor(actionBarColor);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    
    /******************************************************************************************************************/
	/***********************************************生命周期************************************************************/

    @Override
	protected void onStart() {
		super.onStart();
		Log.e(TAG, "onStart");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.e(TAG, "onRestart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.e(TAG, "onResume");
//      MobclickAgent.onResume(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.e(TAG, "onPause");
//      MobclickAgent.onPause(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.e(TAG, "onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.e(TAG, "onDestroy");
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Log.e(TAG, "onBackPressed");
	}
	/***********************************************生命周期************************************************************/
	/******************************************************************************************************************/

}
