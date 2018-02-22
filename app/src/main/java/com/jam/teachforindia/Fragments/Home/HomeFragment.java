package com.jam.teachforindia.Fragments.Home;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.Banners;
import com.jam.teachforindia.RetroServices.ServiceResponses.GetBanner.BannerData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jam on 07-02-2018.
 */

public class HomeFragment extends Fragment{

    RecyclerView recyc_banner;
    BannerAdapter bannerAdapter;
    ArrayList<BannerPojo> banners;


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

        recyc_banner = v.findViewById(R.id.recyc_banner);
        banners = new ArrayList<>();

        bannerAdapter = new BannerAdapter(banners,getActivity());
        recyc_banner.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayout.HORIZONTAL,false));
        recyc_banner.setItemAnimator(new DefaultItemAnimator());
        recyc_banner.setAdapter(bannerAdapter);

        banners.add(new BannerPojo("0","http://jamian.herokuapp.com/public/images/mainimg_wide.jpg","This is taken by jamainfor the love of trees."));
        bannerAdapter.notifyDataSetChanged();

        getBannerData();

        return v;
    }

    private void getBannerData() {

        final Banners banner = RetroClient.getClient().create(Banners.class);
        Call<ArrayList<BannerData>> call = banner.getBanners();
        call.enqueue(new Callback<ArrayList<BannerData>>() {
            @Override
            public void onResponse(Call<ArrayList<BannerData>> call, Response<ArrayList<BannerData>> response) {
                Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();

                banners.clear();

                for(BannerData b : response.body()){
                    BannerPojo bpo = new BannerPojo(b.getBannerid(),b.getBannerimagepath(),b.getBannerdescription());
                    banners.add(bpo);
                }

                bannerAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ArrayList<BannerData>> call, Throwable t) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
