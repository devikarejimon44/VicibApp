package com.Vicib.vicibapp.Reports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.Vicib.vicibapp.ApiClient;
import com.Vicib.vicibapp.ApiInterface;
import com.Vicib.vicibapp.MainActivity;
import com.Vicib.vicibapp.R;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SponsorsList extends AppCompatActivity {
    RecyclerView recycler_sponsorlist;

    DatePickerDialog from,to;
    SimpleDateFormat dateFormatter;
    private List<ListSponsorsList> listSponsorsList;
    private SponsorListAdapter sponsorListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors_list);
        ImageView back_sponsorslist=findViewById(R.id.back_sponsorslist);
        back_sponsorslist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        recycler_sponsorlist=findViewById(R.id.recycler_sponsorlist);
        SearchSponsorList();



    }
    private void SearchSponsorList() {
        SharedPreferences shpref;
        shpref=getSharedPreferences("MYPREF", Context.MODE_PRIVATE);
        String id=shpref.getString("ID","");
        Log.e("id",id);

        ApiInterface api= ApiClient.getClient().create(ApiInterface.class);
       // Call<ResponseSponsorsList> usercall=api.searchsponsorlist(Integer.parseInt(id));
        Call<ResponseSponsorsList> usercall=api.searchsponsorlist(1);
        usercall.enqueue(new Callback<ResponseSponsorsList>() {
            @Override
            public void onResponse(Call<ResponseSponsorsList> call, Response<ResponseSponsorsList> response) {
                Log.i("onResponse", new Gson().toJson(response.body()));
                if (response.body().getStatus().equals("1")){
                    Log.i("onResponse", new Gson().toJson(response.body()));
                    ResponseSponsorsList responseSponsorsList=response.body();
                    final LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recycler_sponsorlist.setLayoutManager(layoutManager);
                    recycler_sponsorlist.setHasFixedSize(true);
                    listSponsorsList=responseSponsorsList.getData();
                    sponsorListAdapter=new SponsorListAdapter(listSponsorsList,getApplicationContext());
                    recycler_sponsorlist.setAdapter(sponsorListAdapter);
                }
                else {
                    Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseSponsorsList> call, Throwable t) {

            }
        });

    }


    }
