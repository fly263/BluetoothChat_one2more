package com.example.bluetoothchatcore;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.bluetoothcore.R;

import java.util.ArrayList;

/**
 * Created by fly263 on 2017/7/25.
 */

public class ConversationArrayAdapter extends ArrayAdapter<MessageBean> {
    private ArrayList<MessageBean> messageList;

    public ConversationArrayAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<MessageBean> messageList) {
        super(context, resource, messageList);
        this.messageList = messageList;
    }

    @Override
    public
    @NonNull
    View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(this.getContext()).inflate(R.layout.message, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.deviceName = (TextView) view.findViewById(R.id.device_name);
            viewHolder.deviceAddress = (TextView) view.findViewById(R.id.device_address);
            viewHolder.content = (TextView) view.findViewById(R.id.content);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        MessageBean messageBean = messageList.get(position);
        viewHolder.deviceName.setText(messageBean.getDeviceName());
        viewHolder.deviceAddress.setText(String.format("(%s):", messageBean.getDeviceAddress()));
        viewHolder.content.setText(messageBean.getContent());

        return view;
    }

    public void add(MessageBean messageBean) {
        messageList.add(messageBean);
        this.notifyDataSetChanged();
    }

    private static class ViewHolder {
        TextView deviceName;
        TextView deviceAddress;
        TextView content;
    }
}
