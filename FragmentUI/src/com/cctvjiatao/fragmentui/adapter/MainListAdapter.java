package com.cctvjiatao.fragmentui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cctvjiatao.fragmentui.R;

/**
 * Created by Bob on 15/7/22.
 */
public class MainListAdapter extends BaseAdapter {
	
	private String[] mNameArray;
	private LayoutInflater mLayoutInflater;

	public MainListAdapter(Context context, String[] names) {
		mNameArray = names;
		mLayoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		if (mNameArray == null)
			return 0;
		return mNameArray.length;
	}

	@Override
	public Object getItem(int position) {
		if (mNameArray == null || mNameArray.length >= position)
			return null;
		return mNameArray[position];
	}

	@Override
	public long getItemId(int i) {
		return 0;
	}

	@Override
	public View getView(int i, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;

		if (convertView == null || convertView.getTag() == null) {

			convertView = mLayoutInflater.inflate(R.layout.item_main, parent, false);
			viewHolder = new ViewHolder();
			viewHolder.titleTextView = (TextView) convertView.findViewById(R.id.text);

			convertView.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.titleTextView.setText(mNameArray[i]);

		return convertView;
	}

	static class ViewHolder {
		TextView titleTextView;
	}
}
