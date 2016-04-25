package com.cctvjiatao.fragmentui.activity;

import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cctvjiatao.fragmentui.R;
import com.cctvjiatao.fragmentui.adapter.MainListAdapter;

/**
 * Created by Bob on 15/7/28. 开启聚合会话列表
 */
public class StartSubConversationActivity extends BaseActivtiy implements AdapterView.OnItemClickListener {

	private ListView mListView;
	private MainListAdapter mMainListAdapter;
	AlertDialog.Builder dialog;
	String[] selects = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		getSupportActionBar().setTitle("开启聚合会话列表");
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeAsUpIndicator(R.drawable.rong_actionbar_back);
		mListView = (ListView) findViewById(R.id.list);
		initDate();
	}

	private void initDate() {

		String[] titleNameArray = this.getResources().getStringArray(R.array.subconversationlist_list);
		mMainListAdapter = new MainListAdapter(this, titleNameArray);
		mListView.setAdapter(mMainListAdapter);
		mMainListAdapter.notifyDataSetChanged();

		mListView.setOnItemClickListener(this);

		dialog = new AlertDialog.Builder(this);
		dialog.setTitle("选择打开哪个");
		selects = new String[] { "activity 静态集成", "activity 动态集成" };
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

		switch (position) {
		case 0:
			// 1.通过 Api 调用
//			showDialog1();
			RongIM.getInstance().startSubConversationList(StartSubConversationActivity.this, Conversation.ConversationType.PRIVATE);
			break;
		case 1:
			// 2.通过 Uri 调用
//			showDialog2();
			Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon().appendPath("subconversationlist")
					.appendQueryParameter("type", String.valueOf(Conversation.ConversationType.PRIVATE).toLowerCase()).build();
			startActivity(new Intent(Intent.ACTION_VIEW, uri));
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
					 * 启动聚合后的某类型的会话列表
					 * startSubConversationList(android.content.Context context,
					 * io.rong.imlib.model.Conversation.ConversationType
					 * conversationType)
					 */
					RongIM.getInstance().startSubConversationList(StartSubConversationActivity.this, Conversation.ConversationType.PRIVATE);

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

				//String 转为 Uri
				Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon().appendPath("subconversationlist")
						.appendQueryParameter("type", String.valueOf(Conversation.ConversationType.PRIVATE).toLowerCase()).build();

				startActivity(new Intent(Intent.ACTION_VIEW, uri));
			}
		});
		dialog.show();
	}
}
