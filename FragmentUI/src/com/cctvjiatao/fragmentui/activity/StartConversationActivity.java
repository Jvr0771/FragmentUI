package com.cctvjiatao.fragmentui.activity;

import io.rong.imkit.RongIM;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cctvjiatao.fragmentui.App;
import com.cctvjiatao.fragmentui.R;
import com.cctvjiatao.fragmentui.adapter.MainListAdapter;
import com.cctvjiatao.fragmentui.conversation.ConversationDynamicActivity;
import com.cctvjiatao.fragmentui.conversation.ConversationDynamicFragmentActivity;
import com.cctvjiatao.fragmentui.conversation.ConversationStaticActivity;
import com.cctvjiatao.fragmentui.conversation.ConversationStaticFragmentActivtiy;

/**
 * Created by Bob on 15/7/27. 开启会话页面
 */
public class StartConversationActivity extends BaseActivtiy implements AdapterView.OnItemClickListener {

	private ListView mListView;
	private MainListAdapter mMainListAdapter;
	AlertDialog.Builder dialog;
	String[] selects = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		getSupportActionBar().setTitle("开启会话页面");
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeAsUpIndicator(R.drawable.rong_actionbar_back);
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
		case 0:
			// 1.通过 Api 调用
//			showDialog1();
			RongIM.getInstance().startPrivateChat(StartConversationActivity.this, App.mTargetID, "title");
			break;
		case 1:
			// 2.通过 Uri 调用， targetUserId 要与之聊天的用户 Id。
//			showDialog2();
			Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon().appendPath("conversation")
					.appendPath(io.rong.imlib.model.Conversation.ConversationType.PRIVATE.getName().toLowerCase()).appendQueryParameter("targetId", App.mTargetID)
					.appendQueryParameter("title", "hello").build();
			startActivity(new Intent(Intent.ACTION_VIEW, uri));
			break;
		case 2:
			// 3.通过 startActivity 调用
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
					 * 启动单聊界面
					 * startPrivateChat(Context context, String targetUserId, String title)
					 * 		targetUserId	要与之聊天的用户 Id
					 * 		title			聊天的标题，如果传入空值，则默认显示与之聊天的用户名称
					 */
					RongIM.getInstance().startPrivateChat(StartConversationActivity.this, App.mTargetID, "title");
			}
		});
		dialog.show();
	}

	/**
	 * 通过 Uri 调用， targetUserId 要与之聊天的用户 Id
	 */
	private void showDialog2() {

		dialog.setItems(selects, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {

				Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon().appendPath("conversation")
						.appendPath(io.rong.imlib.model.Conversation.ConversationType.PRIVATE.getName().toLowerCase()).appendQueryParameter("targetId", App.mTargetID)
						.appendQueryParameter("title", "hello").build();

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
					startActivity(new Intent(StartConversationActivity.this, ConversationStaticActivity.class));
					break;
				case 1:// activity 动态集成
					startActivity(new Intent(StartConversationActivity.this, ConversationDynamicActivity.class));
					break;
				case 2:// fragmet 静态集成
					startActivity(new Intent(StartConversationActivity.this, ConversationStaticFragmentActivtiy.class));
					break;
				case 3:// fragmet 动态集成
					startActivity(new Intent(StartConversationActivity.this, ConversationDynamicFragmentActivity.class));
					break;
				}
			}
		});
		dialog.show();
	}
}
