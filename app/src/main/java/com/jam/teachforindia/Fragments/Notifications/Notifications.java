package com.jam.teachforindia.Fragments.Notifications;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jam.teachforindia.Activities.MainActivity;
import com.jam.teachforindia.Generic.SessionManager;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceResponses.getNotifications.NotificationsData;
import com.jam.teachforindia.RetroServices.ServiceResponses.getNotifications.NotificationsResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jam on 25-02-2018.
 */

public class Notifications extends Fragment {

    RecyclerView recyc_notif;
    ArrayList<NotificationPojo> notifications;
    NotificationAdapter notificationAdapter;

    SessionManager sessionManager;
    TextView tv_nonotif;

    public Notifications() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notification,container,false);

        recyc_notif = v.findViewById(R.id.recyc_notifications);
        notifications = new ArrayList<>();
        notificationAdapter = new NotificationAdapter(notifications);

        tv_nonotif = v.findViewById(R.id.tv_nonotif);

        sessionManager = new SessionManager(getActivity());

        recyc_notif.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyc_notif.setItemAnimator(new DefaultItemAnimator());
        recyc_notif.setAdapter(notificationAdapter);

        getNotifications();

        return v;
    }

    private void getNotifications() {



        com.jam.teachforindia.RetroServices.ServiceInterfaces.Notifications notif = RetroClient.getClient().create(com.jam.teachforindia.RetroServices.ServiceInterfaces.Notifications.class);
        Call<NotificationsResponse> call = notif.getNotifications(sessionManager.getUserId());

        call.enqueue(new Callback<NotificationsResponse>() {
            @Override
            public void onResponse(Call<NotificationsResponse> call, Response<NotificationsResponse> response) {

                if(response.body().getCode().equals("0")){

                    for(NotificationsData nd : response.body().getData()){

                        notifications.add(new NotificationPojo(
                                nd.getNotifbody(),
                                nd.getNotiftitle(),
                                nd.getNotificationid(),
                                nd.getNotifread()
                        ));

                    }

                    notificationAdapter.notifyDataSetChanged();

                }else{
                    tv_nonotif.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<NotificationsResponse> call, Throwable t) {
                Toast.makeText(getActivity(), MainActivity.CONNECTION_ERROR, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
