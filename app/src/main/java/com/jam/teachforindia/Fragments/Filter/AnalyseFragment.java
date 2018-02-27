package com.jam.teachforindia.Fragments.Filter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jam.teachforindia.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jam on 26-02-2018.
 */

public class AnalyseFragment extends Fragment {

    public AnalyseFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_analyse,container,false);

        return v;
    }
}
