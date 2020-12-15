package com.Vicib.vicibapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences shpref;
                shpref=getSharedPreferences("MYPREF", Context.MODE_PRIVATE);
                String uname=shpref.getString("USERNAME","0");
                Log.e("id",uname);
                ApiInterface api=ApiClient.getClient().create(ApiInterface.class);
                assert uname != null;
                Call<ResponseLoginCheck> call=api.LoginCheck(uname);
                call.enqueue(new Callback<ResponseLoginCheck>() {
                    @Override
                    public void onResponse(Call<ResponseLoginCheck> call, Response<ResponseLoginCheck> response) {
                        Log.d("onResponse", "" + response.body().getMessage());
                        if (response.body().getStatus().equals("1")){
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else {
                            startActivity(new Intent(getApplicationContext(),Login.class));

                        }
                        finish();
                    }
                    @Override
                    public void onFailure(Call<ResponseLoginCheck> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Network not connected", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        }, 3000);
    }
}
