package com.cctvjiatao.fragmentui.conversationlist;

import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;
import android.net.Uri;
import android.os.Bundle;

import com.cctvjiatao.fragmentui.R;
import com.cctvjiatao.fragmentui.activity.BaseActivtiy;

/**
 * Created by Bob on 15/7/28.
 * 会话列表静态集成 fragment
 */
public class ConversationListStaticFragmentActivity extends BaseActivtiy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversationlist_static_fr);
    }
}
