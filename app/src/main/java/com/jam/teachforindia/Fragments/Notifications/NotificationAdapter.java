package com.jam.teachforindia.Fragments.Notifications;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jam.teachforindia.Fragments.Events.EventsAdapter;
import com.jam.teachforindia.R;

import java.util.ArrayList;

/**
 * Created by Jam on 25-02-2018.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyVH>{

    ArrayList<NotificationPojo> notifications;

    public NotificationAdapter(ArrayList<NotificationPojo> notifications) {
        this.notifications = notifications;
    }

    @Override
    public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.each_notification,parent,false);

        return new MyVH(v);
    }

    @Override
    public void onBindViewHolder(MyVH holder, int position) {
        NotificationPojo n = notifications.get(position);
        holder.tv_notificationtitle.setText(n.getNotificationtitle());
        holder.tv_notificationbody.setText(n.getNotificationbody());
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        TextView tv_notificationtitle, tv_notificationbody;

        public MyVH(View itemView) {
            super(itemView);

            tv_notificationtitle = itemView.findViewById(R.id.tv_notificationtitle);
            tv_notificationbody = itemView.findViewById(R.id.tv_notificationbody);

        }
    }
}
