package com.jam.teachforindia.Fragments.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jam.teachforindia.Activities.MainActivity;
import com.jam.teachforindia.Generic.SessionManager;
import com.jam.teachforindia.R;
import com.jam.teachforindia.RetroServices.RetroClient;
import com.jam.teachforindia.RetroServices.ServiceInterfaces.Login;
import com.jam.teachforindia.RetroServices.ServiceResponses.Login.LoginData;
import com.jam.teachforindia.RetroServices.ServiceResponses.Login.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jam on 07-02-2018.
 */

public class LoginFragment extends Fragment {

    private static final String TAG = "LoginFragment";
    Button btn_login;
    EditText et_username,et_pass;
    TextView tv_signup;

    SessionManager session;

    public LoginFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login,container,false);

        et_pass = v.findViewById(R.id.et_pass);
        et_username = v.findViewById(R.id.et_username);

        et_username.setText("vinay@test.com");
        et_pass.setText("vinay");

        tv_signup = v.findViewById(R.id.tv_signup);
        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left)
                        .replace(R.id.login_container,new RegisterFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        btn_login = v.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                checkLogin();

            }
        });

        session = new SessionManager(getActivity());

        return  v;
    }

    private void checkLogin() {

        String usernname = et_username.getText().toString();
        String password = et_pass.getText().toString();

        Login login = RetroClient.getClient().create(Login.class);
        Call<LoginResponse> call = login.loginuser(usernname,password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {


                if(response.body().getCode().equals("0")){
                    LoginData ld = response.body().getData().get(0);
                    session.setUserLoggedIn(ld.getEmail(),ld.getPassword(),ld.getRole(),ld.getFirstname());
                    Intent i = new Intent(getActivity(),MainActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getActivity(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}













