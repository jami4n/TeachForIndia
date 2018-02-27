package com.jam.teachforindia.Fragments.Navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jam.teachforindia.Activities.MainActivity;
import com.jam.teachforindia.Generic.SessionManager;
import com.jam.teachforindia.R;

import java.util.ArrayList;

/**
 * Created by Jam on 18-02-2018.
 */

public class NavigationFragment extends Fragment implements LinkClicked{

    private FragmentDrawerListener drawerListener;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private View containerView;

    SessionManager session;

    RecyclerView recyc_navigation;
    NavigationAdapter navigationAdapter;
    ArrayList<String> links;

    TextView tv_name,tv_title;

    public void setDrawerListener(FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }

    public NavigationFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_navigation,container,false);

        TextView home = v.findViewById(R.id.tv_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerListener.onDrawerItemSelected(v,0,"home");
            }
        });

        session = new SessionManager(getActivity());

        recyc_navigation = v.findViewById(R.id.recyc_navigation);
        links = new ArrayList<>();
        navigationAdapter = new NavigationAdapter(links,this);

        recyc_navigation.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyc_navigation.setItemAnimator(new DefaultItemAnimator());
        recyc_navigation.setAdapter(navigationAdapter);

        tv_title = v.findViewById(R.id.tv_title);
        tv_name = v.findViewById(R.id.tv_name);
        tv_name.setText(session.getUserDetails().get(SessionManager.NAME));

        if(session.getUsertitle() == null){
            tv_title.setText("the Good Student");
        }else{
            tv_title.setText(session.getUsertitle());
        }

        setNaviagtionLinks();

        return v;
    }

    private void setNaviagtionLinks() {
        String role = session.getUserRole();

        if(role.equals("N") || role.equals("V")){
            links.add("Home");
            links.add("Profile");
            links.add("Top Volunteers");
            links.add("Events");
            links.add("Update Profile");
            links.add("Staff Feedback");
            links.add("Notifications");
            links.add("Logout");
        }else{
            links.add("Home");
            links.add("Profile");
            links.add("Top Volunteers");
            links.add("Events");
            links.add("Create Events");
            links.add("Update Profile");
            links.add("Feedback");
            links.add("Invite");
            links.add("Notifications");
            links.add("Logout");
        }

        navigationAdapter.notifyDataSetChanged();
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

    @Override
    public void linkClicked(String link, int position, View view) {
        drawerListener.onDrawerItemSelected(view,position,link);
        mDrawerLayout.closeDrawer(containerView);
    }


    public interface FragmentDrawerListener {
        void onDrawerItemSelected(View view, int position, String link);
    }
}
