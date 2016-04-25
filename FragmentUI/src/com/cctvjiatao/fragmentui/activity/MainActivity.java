package com.cctvjiatao.fragmentui.activity;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cctvjiatao.fragmentui.R;
import com.cctvjiatao.fragmentui.adapter.MainListAdapter;

/**
 *
 */
public class MainActivity extends BaseActivtiy implements AdapterView.OnItemClickListener {

	String token = "G+c7H/nJEmoJXwYcWDnkyavMo82Ztxl0cNn30d9ahj8zFHjHTyxTU+qP7LBhxqUH5+tgIWh4rrkPQPK0EA6AtA==";
	private Context context;
	private ListView mListView;
	private MainListAdapter mMainListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.context = this;
		setContentView(R.layout.activity_main);
		getSupportActionBar().setTitle("MainActivity");
		mListView = (ListView) findViewById(R.id.list);
		initDate();
	}

	private void initDate() {

		String[] titleNameArray = this.getResources().getStringArray(R.array.main_list);
		mMainListAdapter = new MainListAdapter(this, titleNameArray);
		mListView.setAdapter(mMainListAdapter);
		mMainListAdapter.notifyDataSetChanged();

		mListView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		switch (position) {
		case 0:
			RongIM.connect(token, new RongIMClient.ConnectCallback() {
				@Override
				public void onTokenIncorrect() {
					Log.e(TAG, "-----onTokenIncorrect-----");
				}

				@Override
				public void onSuccess(String s) {
					Toast.makeText(context, "登录成功", Toast.LENGTH_SHORT).show();
					Log.e(TAG, "-----onSuccess-----" + s);
				}

				@Override
				public void onError(RongIMClient.ErrorCode errorCode) {
					Log.e(TAG, "-----onError-----" + errorCode);
				}
			});
			break;
		case 1:// 开启会话列表页面
			startActivity(new Intent(context, StartConversationListActivity.class));
			break;
		case 2:// 开启聚合会话页面
			startActivity(new Intent(context, StartSubConversationActivity.class));
			break;
		case 3:// 开启会话页面
			startActivity(new Intent(context, StartConversationActivity.class));

			break;
		}
	}
}
