package com.cctvjiatao.fragmentui.conversationlist;

import android.os.Bundle;

import com.cctvjiatao.fragmentui.R;
import com.cctvjiatao.fragmentui.activity.BaseActivtiy;

/**
 * Created by Bob on 15/7/28.
 * 会话列表动态集成 fragment
 */
public class ConversationListDynamicFragmentActivity extends BaseActivtiy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.conversationlist_dynamic_fr);
    }
}
