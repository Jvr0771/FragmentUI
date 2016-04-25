package com.cctvjiatao.fragmentui.conversation;

import io.rong.imkit.fragment.ConversationFragment;
import android.net.Uri;
import android.os.Bundle;

import com.cctvjiatao.fragmentui.App;
import com.cctvjiatao.fragmentui.R;
import com.cctvjiatao.fragmentui.activity.BaseActivtiy;

/**
 * Created by Bob on 15/7/14.
 * activity 静态集成
 */
public class ConversationStaticActivity extends BaseActivtiy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.conversation);

        ConversationFragment fragment =  (ConversationFragment)getSupportFragmentManager().findFragmentById(R.id.conversation);

        Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
                .appendPath("conversation").appendPath(io.rong.imlib.model.Conversation.ConversationType.PRIVATE.getName().toLowerCase())
                .appendQueryParameter("targetId", App.mTargetID).appendQueryParameter("title", "hello").build();

        fragment.setUri(uri);
    }


}
