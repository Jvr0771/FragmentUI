package com.cctvjiatao.fragmentui.subconversationlist;

import io.rong.imkit.fragment.SubConversationListFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.cctvjiatao.fragmentui.R;
import com.cctvjiatao.fragmentui.activity.BaseActivtiy;

/**
 * Created by Bob on 15/7/28.
 * 聚合会话列表动态集成
 */
public class SubConversationListDynamicActivtiy extends BaseActivtiy{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rong_activity);

        SubConversationListFragment fragment = new SubConversationListFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            //xxx 为你要加载的 id
        transaction.add(R.id.rong_content, fragment);
        transaction.commit();
    }
}
