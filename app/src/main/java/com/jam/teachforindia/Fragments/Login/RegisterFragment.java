package com.jam.teachforindia.Fragments.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jam.teachforindia.Activities.MainActivity;
import com.jam.teachforindia.Generic.SessionManager;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.Login;
import com.jam.teachforindia.RetroServices.ServiceResponses.Register.RegisterData;
import com.jam.teachforindia.RetroServices.ServiceResponses.Register.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Jam on 21-02-2018.
 */

public class RegisterFragment extends Fragment {

    Button btn_register;
    EditText et_name,et_username,et_pass;

    SessionManager session;

    public RegisterFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register,container,false);

        et_name = v.findViewById(R.id.et_name);
        et_username = v.findViewById(R.id.et_username);
        et_pass = v.findViewById(R.id.et_pass);

        btn_register = v.findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        session = new SessionManager(getActivity());
        return v;
    }

    private void registerUser() {

        String name = et_name.getText().toString();
        String username = et_username.getText().toString();
        String password = et_pass.getText().toString();

        Login login = RetroClient.getClient().create(Login.class);
        Call<RegisterResponse> call = login.registeruser(username,password,name);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                Log.d(TAG, "onResponse: " + response.body().getMessage());

                if(response.body().getCode().equals("0")){
                    RegisterData rd = response.body().getData();
                    session.setUserLoggedIn(rd.getEmail(),rd.getPassword(),rd.getRole());
                    Intent i = new Intent(getActivity(),MainActivity.class);
                    getActivity().startActivity(i);

                }else{
                    Toast.makeText(getActivity(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }
}
