package com.cctvjiatao.fragmentui.activity;

import io.rong.imkit.RongIM;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cctvjiatao.fragmentui.R;
import com.cctvjiatao.fragmentui.adapter.MainListAdapter;
import com.cctvjiatao.fragmentui.conversationlist.ConversationListDynamicActivtiy;
import com.cctvjiatao.fragmentui.conversationlist.ConversationListDynamicFragmentActivity;
import com.cctvjiatao.fragmentui.conversationlist.ConversationListStaticActivity;
import com.cctvjiatao.fragmentui.conversationlist.ConversationListStaticFragmentActivity;

/**
 * Created by Bob on 15/7/23. 开启会话列表
 */
public class StartConversationListActivity extends BaseActivtiy implements AdapterView.OnItemClickListener {

	private Context context;
	private ListView mListView;
	private MainListAdapter mMainListAdapter;
	AlertDialog.Builder dialog;
	String[] selects = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.context = this;
		getSupportActionBar().setTitle("开启会话列表");
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeAsUpIndicator(R.drawable.rong_actionbar_back);
		setContentView(R.layout.activity_main);
		mListView = (ListView) findViewById(R.id.list);
		initDate();
	}

	private void initDate() {

		String[] titleNameArray = this.getResources().getStringArray(R.array.conversationlist_list);
		mMainListAdapter = new MainListAdapter(this, titleNameArray);
		mListView.setAdapter(mMainListAdapter);
		mMainListAdapter.notifyDataSetChanged();

		mListView.setOnItemClickListener(this);

		dialog = new AlertDialog.Builder(this);
		dialog.setTitle("选择打开哪个");
		selects = new String[] { "activity 静态集成", "activity 动态集成", "fragmet 静态集成", "fragmet 动态集成" };
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

		switch (position) {
		case 0:// 通过 Api 调用
//			showDialog1();
			RongIM.getInstance().startConversationList(context);
			break;
		case 1:// 通过 Uri 调用
//			showDialog2();
			Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon().appendPath("conversationlist").build();
			startActivity(new Intent(Intent.ACTION_VIEW, uri));
			break;
		case 2:// 通过 startActivity 调用
			showDialog3();
			break;
		}
	}

	/**
	 * 通过 Api 调用
	 */
	private void showDialog1() {

		dialog.setItems(selects, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				if (RongIM.getInstance() != null)
					/*
					 * startConversationList(android.content.Context context) 启动会话列表界面
					 */
					RongIM.getInstance().startConversationList(context);
			}
		});
		dialog.show();
	}

	/**
	 * 通过 Uri 调用
	 */
	private void showDialog2() {

		dialog.setItems(selects, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon().appendPath("conversationlist").build();
				startActivity(new Intent(Intent.ACTION_VIEW, uri));
			}
		});
		dialog.show();
	}

	/**
	 * 通过 startActivity 调用
	 */
	private void showDialog3() {

		dialog.setItems(selects, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				switch (i) {
				case 0:// activity 静态集成
					startActivity(new Intent(context, ConversationListStaticActivity.class));
					break;
				case 1:// activity 动态集成
					startActivity(new Intent(context, ConversationListDynamicActivtiy.class));
					break;
				case 2:// fragmet 静态集成
					startActivity(new Intent(context, ConversationListStaticFragmentActivity.class));
					break;
				case 3:// fragmet 动态集成
					startActivity(new Intent(context, ConversationListDynamicFragmentActivity.class));
					break;
				}

			}
		});
		dialog.show();
	}
}
