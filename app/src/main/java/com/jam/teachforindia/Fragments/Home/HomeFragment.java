package com.jam.teachforindia.Fragments.Home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jam.teachforindia.Activities.MainActivity;
import com.jam.teachforindia.Fragments.ApplicationForms.VolunteerApplicationForm;
import com.jam.teachforindia.Generic.SessionManager;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.Banners;
import com.jam.teachforindia.RetroServices.ServiceResponses.GetBanner.BannerData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

/**
 * Created by Jam on 07-02-2018.
 */

public class HomeFragment extends Fragment{

    RecyclerView recyc_banner;
    BannerAdapter bannerAdapter;
    //ArrayList<BannerPojo> banners;


    List<Banner> banners;
    BannerSlider bannerSlider;

    Button btn_update;
    LinearLayout ll_update_holder;

    SessionManager session;

    LinearLayout ll_desc,ll_fullcontent;
    LinearLayout ll_desc1,ll_fullcontent1;
    LinearLayout ll_desc2,ll_fullcontent2;

    @Override
    public void onResume() {
        super.onResume();
    }

    public HomeFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);

        ll_desc = v.findViewById(R.id.ll_desc);
        ll_fullcontent = v.findViewById(R.id.ll_data);

        ll_desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_fullcontent.setVisibility(View.VISIBLE);
                ll_desc.setVisibility(View.GONE);
            }
        });
        ll_fullcontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_fullcontent.setVisibility(View.GONE);
                ll_desc.setVisibility(View.VISIBLE);
            }
        });

        ll_desc1 = v.findViewById(R.id.ll_desc1);
        ll_fullcontent1 = v.findViewById(R.id.ll_data1);

        ll_desc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_fullcontent1.setVisibility(View.VISIBLE);
                ll_desc1.setVisibility(View.GONE);
            }
        });
        ll_fullcontent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_fullcontent1.setVisibility(View.GONE);
                ll_desc1.setVisibility(View.VISIBLE);
            }
        });

        ll_desc2 = v.findViewById(R.id.ll_desc2);
        ll_fullcontent2 = v.findViewById(R.id.ll_data2);

        ll_desc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_fullcontent2.setVisibility(View.VISIBLE);
                ll_desc2.setVisibility(View.GONE);
            }
        });
        ll_fullcontent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_fullcontent2.setVisibility(View.GONE);
                ll_desc2.setVisibility(View.VISIBLE);
            }
        });

//        recyc_banner = v.findViewById(R.id.recyc_banner);
//        banners = new ArrayList<>();
//
//        bannerAdapter = new BannerAdapter(banners,getActivity());
//        recyc_banner.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayout.HORIZONTAL,false));
//        recyc_banner.setItemAnimator(new DefaultItemAnimator());
//        recyc_banner.setAdapter(bannerAdapter);
//
//        banners.add(new BannerPojo("0","http://jamian.herokuapp.com/public/images/mainimg_wide.jpg","This is taken by jamainfor the love of trees."));
//        bannerAdapter.notifyDataSetChanged();
//

        session = new SessionManager(getActivity());


       getBannerData();

        bannerSlider = v.findViewById(R.id.banner_slider1);
        banners=new ArrayList<>();
        //add banner using image url
        //add banner using resource drawable
        //banners.add(new DrawableBanner(R.drawable.yourDrawable));
        //banners.add(new DrawableBanner(R.drawable.bannerimageplaceholder));
        bannerSlider.setBanners(banners);


        ll_update_holder = v.findViewById(R.id.ll_update_holder);

        if(session.getUserRole().equals("N")){
            ll_update_holder.setVisibility(View.VISIBLE);
        }else{
            ll_update_holder.setVisibility(View.GONE);
        }

        btn_update = v.findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new VolunteerApplicationForm()).addToBackStack(null).commit();
            }
        });

        FragmentManager fm = getActivity().getSupportFragmentManager();
        for(int i = 0; i < fm.getBackStackEntryCount() - 1; ++i) {
            fm.popBackStack();
        }


        return v;
    }

    private void getBannerData() {

        final Banners banner = RetroClient.getClient().create(Banners.class);
        Call<ArrayList<BannerData>> call = banner.getBanners();
        call.enqueue(new Callback<ArrayList<BannerData>>() {
            @Override
            public void onResponse(Call<ArrayList<BannerData>> call, Response<ArrayList<BannerData>> response) {
                banners.clear();

                for(BannerData b : response.body()){
                    //BannerPojo bpo = new BannerPojo(b.getBannerid(),b.getBannerimagepath(),b.getBannerdescription());
                    //banners.add(bpo);
                    banners.add(new RemoteBanner(b.getBannerimagepath()));
                }
                bannerSlider.setBanners(banners);
                //bannerAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ArrayList<BannerData>> call, Throwable t) {
                Toast.makeText(getActivity(), MainActivity.CONNECTION_ERROR, Toast.LENGTH_SHORT).show();
                banners.add(new DrawableBanner(R.drawable.bannerimageplaceholder));
                bannerSlider.setBanners(banners);
            }
        });
    }
}
