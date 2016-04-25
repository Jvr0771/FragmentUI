package com.cctvjiatao.fragmentui.conversation;

import android.os.Bundle;

import com.cctvjiatao.fragmentui.R;
import com.cctvjiatao.fragmentui.activity.BaseActivtiy;

/**
 * Created by Bob on 15/7/28.
 * fragmet 静态集成
 */
public class ConversationStaticFragmentActivtiy extends BaseActivtiy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.conversation_static_fr);
    }
}
