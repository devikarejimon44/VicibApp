package com.Vicib.vicibapp.Gene;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.Vicib.vicibapp.ApiClient;
import com.Vicib.vicibapp.ApiInterface;
import com.Vicib.vicibapp.R;
import com.Vicib.vicibapp.Registration;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StandardPlanGenealogy extends AppCompatActivity {
    PopupWindow popupWindow;
    LinearLayout layout_standard;


    ImageView imgone,imgtwo,imgthree,imgfour,imgfive,imgsix,imgseven;
    LinearLayout llone,lltwo,llthree,llfour,llfive,llsix,llseven;
    LinearLayout llmain;
    TextView txtone,txttwo,txtthree,txtfour,txtfive,txtsix,txtseven;
    private ArrayList<ListStandardPlanGenealogy> listStandardPlanGenealogy;
    TextView username_one,sponsor_userid_one,name_one,sponsor_username_one,leftGBV_one,rightGBV_one,leftcount_one,rightcount_one,leftactive_one,rightactive_one;
    TextView username_two,sponsor_userid_two,name_two,sponsor_username_two,leftGBV_two,rightGBV_two,leftcount_two,rightcount_two,leftactive_two,rightactive_two;
    TextView username_three,sponsor_userid_three,name_three,sponsor_username_three,leftGBV_three,rightGBV_three,leftcount_three,rightcount_three,leftactive_three,rightactive_three;
    TextView username_four,sponsor_userid_four,name_four,sponsor_username_four,leftGBV_four,rightGBV_four,leftcount_four,rightcount_four,leftactive_four,rightactive_four;
    TextView username_five,sponsor_userid_five,name_five,sponsor_username_five,leftGBV_five,rightGBV_five,leftcount_five,rightcount_five,leftactive_five,rightactive_five;
    TextView username_six,sponsor_userid_six,name_six,sponsor_username_six,leftGBV_six,rightGBV_six,leftcount_six,rightcount_six,leftactive_six,rightactive_six;
    TextView username_seven,sponsor_userid_seven,name_seven,sponsor_username_seven,leftGBV_seven,rightGBV_seven,leftcount_seven,rightcount_seven,leftactive_seven,rightactive_seven;
    String uid0,uid1,uid2,uid3,uid4,uid5,uid6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_plan_genealogy);
        ImageView standard_info=findViewById(R.id.standard_info);
        standard_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = (LayoutInflater) StandardPlanGenealogy.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View premium_popup = layoutInflater.inflate(R.layout.standard_genepopup, null);

                popupWindow = new PopupWindow(premium_popup, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(layout_standard, Gravity.CENTER, 0, 0);
                popupWindow.setFocusable(true);
                popupWindow.update();
            }
        });

        username_one=findViewById(R.id.username_one);
        sponsor_userid_one=findViewById(R.id.sponsor_userid_one);
        name_one=findViewById(R.id.name_one);
        sponsor_username_one=findViewById(R.id.sponsor_username_one);
        leftGBV_one=findViewById(R.id.leftGBV_one);
        rightGBV_one=findViewById(R.id.rightGBV_one);
        leftcount_one=findViewById(R.id.leftcount_one);
        rightcount_one=findViewById(R.id.rightcount_one);
        leftactive_one=findViewById(R.id.leftactive_members_one);
        rightactive_one=findViewById(R.id.rightactive_members_one);

        username_two=findViewById(R.id.username_two);
        sponsor_userid_two=findViewById(R.id.sponsor_userid_two);
        name_two=findViewById(R.id.name_two);
        sponsor_username_two=findViewById(R.id.sponsor_username_two);
        leftGBV_two=findViewById(R.id.leftGBV_two);
        rightGBV_two=findViewById(R.id.rightGBV_two);
        leftcount_two=findViewById(R.id.leftcount_two);
        rightcount_two=findViewById(R.id.rightcount_two);
        leftactive_two=findViewById(R.id.leftactive_members_two);
        rightactive_two=findViewById(R.id.rightactive_members_two);

        username_three=findViewById(R.id.username_three);
        sponsor_userid_three=findViewById(R.id.sponsor_userid_three);
        name_three=findViewById(R.id.name_three);
        sponsor_username_three=findViewById(R.id.sponsor_username_three);
        leftGBV_three=findViewById(R.id.leftGBV_three);
        rightGBV_three=findViewById(R.id.rightGBV_three);
        leftcount_three=findViewById(R.id.leftcount_three);
        rightcount_three=findViewById(R.id.rightcount_three);
        leftactive_three=findViewById(R.id.leftactive_members_three);
        rightactive_three=findViewById(R.id.rightactive_members_three);

        username_four=findViewById(R.id.username_four);
        sponsor_userid_four=findViewById(R.id.sponsor_userid_four);
        name_four=findViewById(R.id.name_four);
        sponsor_username_four=findViewById(R.id.sponsor_username_four);
        leftGBV_four=findViewById(R.id.leftGBV_four);
        rightGBV_four=findViewById(R.id.rightGBV_four);
        leftcount_four=findViewById(R.id.leftcount_four);
        rightcount_four=findViewById(R.id.rightcount_four);
        leftactive_four=findViewById(R.id.leftactive_members_four);
        rightactive_four=findViewById(R.id.rightactive_members_four);

        username_five=findViewById(R.id.username_five);
        sponsor_userid_five=findViewById(R.id.sponsor_userid_five);
        name_five=findViewById(R.id.name_five);
        sponsor_username_five=findViewById(R.id.sponsor_username_five);
        leftGBV_five=findViewById(R.id.leftGBV_five);
        rightGBV_five=findViewById(R.id.rightGBV_five);
        leftcount_five=findViewById(R.id.leftcount_five);
        rightcount_five=findViewById(R.id.rightcount_five);
        leftactive_five=findViewById(R.id.leftactive_members_five);
        rightactive_five=findViewById(R.id.rightactive_members_five);

        username_six=findViewById(R.id.username_six);
        sponsor_userid_six=findViewById(R.id.sponsor_userid_six);
        name_six=findViewById(R.id.name_six);
        sponsor_username_six=findViewById(R.id.sponsor_username_six);
        leftGBV_six=findViewById(R.id.leftGBV_six);
        rightGBV_six=findViewById(R.id.rightGBV_six);
        leftcount_six=findViewById(R.id.leftcount_six);
        rightcount_six=findViewById(R.id.rightcount_six);
        leftactive_six=findViewById(R.id.leftactive_members_six);
        rightactive_six=findViewById(R.id.rightactive_members_six);

        username_seven=findViewById(R.id.username_seven);
        sponsor_userid_seven=findViewById(R.id.sponsor_userid_seven);
        name_seven=findViewById(R.id.name_seven);
        sponsor_username_seven=findViewById(R.id.sponsor_username_seven);
        leftGBV_seven=findViewById(R.id.leftGBV_seven);
        rightGBV_seven=findViewById(R.id.rightGBV_seven);
        leftcount_seven=findViewById(R.id.leftcount_seven);
        rightcount_seven=findViewById(R.id.rightcount_seven);
        leftactive_seven=findViewById(R.id.leftactive_members_seven);
        rightactive_seven=findViewById(R.id.rightactive_members_seven);


        llmain=findViewById(R.id.llmain);
        txtone=findViewById(R.id.txtone);
        txttwo=findViewById(R.id.txttwo);
        txtthree=findViewById(R.id.txtthree);
        txtfour=findViewById(R.id.txtfour);
        txtfive=findViewById(R.id.txtfive);
        txtsix=findViewById(R.id.txtsix);
        txtseven=findViewById(R.id.txtseven);

        imgone=findViewById(R.id.imgone);
        imgtwo=findViewById(R.id.imgtwo);
        imgthree=findViewById(R.id.imgthree);
        imgfour=findViewById(R.id.imgfour);
        imgfive=findViewById(R.id.imgfive);
        imgsix=findViewById(R.id.imgsix);
        imgseven=findViewById(R.id.imgseven);
        llone=findViewById(R.id.llimgone);
        lltwo=findViewById(R.id.llimgtwo);
        llthree=findViewById(R.id.llimgthree);
        llfour=findViewById(R.id.llimgfour);
        llfive=findViewById(R.id.llimgfive);
        llsix=findViewById(R.id.llimgsix);
        llseven=findViewById(R.id.llimgseven);
        imgone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llone.setVisibility(View.VISIBLE );
                lltwo.setVisibility(View.GONE);
                llthree.setVisibility(View.GONE);
                llfour.setVisibility(View.GONE);
                llfive.setVisibility(View.GONE);
                llsix.setVisibility(View.GONE);
                llseven.setVisibility(View.GONE);
            }
        });
        imgtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lltwo.setVisibility(View.VISIBLE);
                llone.setVisibility(View.GONE);
                llthree.setVisibility(View.GONE);
                llfour.setVisibility(View.GONE);
                llfive.setVisibility(View.GONE);
                llsix.setVisibility(View.GONE);
                llseven.setVisibility(View.GONE);
            }
        });
        imgthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llthree.setVisibility(View.VISIBLE);
                llone.setVisibility(View.GONE);
                lltwo.setVisibility(View.GONE);
                llfour.setVisibility(View.GONE);
                llfive.setVisibility(View.GONE);
                llsix.setVisibility(View.GONE);
                llseven.setVisibility(View.GONE);
            }
        });
        imgfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llfour.setVisibility(View.VISIBLE);
                llone.setVisibility(View.GONE);
                lltwo.setVisibility(View.GONE);
                llthree.setVisibility(View.GONE);
                llfive.setVisibility(View.GONE);
                llsix.setVisibility(View.GONE);
                llseven.setVisibility(View.GONE);
            }
        });
        imgfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llfive.setVisibility(View.VISIBLE);
                llone.setVisibility(View.GONE);
                lltwo.setVisibility(View.GONE);
                llthree.setVisibility(View.GONE);
                llfour.setVisibility(View.GONE);
                llsix.setVisibility(View.GONE);
                llseven.setVisibility(View.GONE);
            }
        });
        imgsix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llsix.setVisibility(View.VISIBLE);
                llone.setVisibility(View.GONE);
                lltwo.setVisibility(View.GONE);
                llthree.setVisibility(View.GONE);
                llfour.setVisibility(View.GONE);
                llfive.setVisibility(View.GONE);
                llseven.setVisibility(View.GONE);
            }
        });
        imgseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llseven.setVisibility(View.VISIBLE);
                llone.setVisibility(View.GONE);
                lltwo.setVisibility(View.GONE);
                llthree.setVisibility(View.GONE);
                llfour.setVisibility(View.GONE);
                llfive.setVisibility(View.GONE);
                llsix.setVisibility(View.GONE);

            }
        });
        llmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llone.setVisibility(View.GONE);
                lltwo.setVisibility(View.GONE);
                llthree.setVisibility(View.GONE);
                llfour.setVisibility(View.GONE);
                llfive.setVisibility(View.GONE);
                llsix.setVisibility(View.GONE);
                llseven.setVisibility(View.GONE);
            }
        });
        SharedPreferences shpref;
        shpref=getApplicationContext().getSharedPreferences("MYPREF", Context.MODE_PRIVATE);
        String u=shpref.getString("ID","");
        gene(u);
        txttwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (uid1==null){

                    // Toast.makeText(getActivity(), "nulllllllllllll", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getApplicationContext(), Registration.class);
                    startActivity(i);

//                    getActivity().getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.nav_host_fragment, new RegistrationFragment())
//                            .addToBackStack("")
//                            .commit();


                }
                else{
                    gene(uid1);
                }


            }
        });
        txtthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (uid2==null){
                    Intent i=new Intent(getApplicationContext(), Registration.class);
                    startActivity(i);
//                    getActivity().getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.nav_host_fragment, new RegistrationFragment())
//                            .addToBackStack("")
//                            .commit();
                }else {
                    gene(uid2);
                }


            }
        });
        txtfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (uid3==null){
                    Intent i=new Intent(getApplicationContext(), Registration.class);
                    startActivity(i);
//                    getActivity().getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.nav_host_fragment, new RegistrationFragment())
//                            .addToBackStack("")
//                            .commit();
                }
                else {
                    gene(uid3);
                }

            }
        });
        txtfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (uid4==null){
                    Intent i=new Intent(getApplicationContext(), Registration.class);
                    startActivity(i);
//                    getActivity().getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.nav_host_fragment, new RegistrationFragment())
//                            .addToBackStack("")
//                            .commit();
                }else
                {
                    gene(uid4);
                }

            }
        });
        txtsix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (uid5==null){
                    Intent i=new Intent(getApplicationContext(), Registration.class);
                    startActivity(i);
//                    getActivity().getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.nav_host_fragment, new RegistrationFragment())
//                            .addToBackStack("")
//                            .commit();
                }else {
                    gene(uid5);
                }

            }
        });
        txtseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (uid6==null){
                    Intent i=new Intent(getApplicationContext(), Registration.class);
                    startActivity(i);
//                    getActivity().getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.nav_host_fragment, new RegistrationFragment())
//                            .addToBackStack("")
//                            .commit();
                }else {
                    gene(uid6);
                }

            }
        });

    }
    private  void gene(String id){
        ApiInterface api= ApiClient.getClient().create(ApiInterface.class);
        final Call<ResponseStandardGenealogy> usercall=api.StandardGene(Integer.parseInt(id));
        usercall.enqueue(new Callback<ResponseStandardGenealogy>() {
            @Override
            public void onResponse(Call<ResponseStandardGenealogy> call, final Response<ResponseStandardGenealogy> response) {
                Log.i("onResponse", new Gson().toJson(response.body()));

                final ResponseStandardGenealogy responseStandardGenealogy = response.body();
                listStandardPlanGenealogy = (ArrayList<ListStandardPlanGenealogy>)responseStandardGenealogy.getData();

                //position 0
                String mem_active0= String.valueOf(listStandardPlanGenealogy.get(0).getMemberActive());
                String basic_active0=listStandardPlanGenealogy.get(0).getBasicActive();
                String starter_active0=listStandardPlanGenealogy.get(0).getMemberbronzeActive();
                String username0=listStandardPlanGenealogy.get(0).getName();
                uid0=listStandardPlanGenealogy.get(0).getUserid();
                txtone.setText(username0);
                if (uid0==null){
                    Glide.with(getApplicationContext())
                            .load(R.drawable.vacant)
                            .into(imgone);
                }

                if (mem_active0.equals("Y")) {
                    Glide.with(getApplicationContext())
                            .load(R.drawable.active)
                            .into(imgone);

                }else if(basic_active0.equals("Y")){
                    Glide.with(getApplicationContext())
                            .load(R.drawable.basicplan)
                            .into(imgone);
                }else if (starter_active0.equals("Y")){

                    Glide.with(getApplicationContext())
                            .load(R.drawable.bronzeactive)
                            .into(imgone);
                }else {
                    Glide.with(getApplicationContext())
                            .load(R.drawable.notactive)
                            .into(imgone);

                }

                //position 1
                String mem_active1= String.valueOf(listStandardPlanGenealogy.get(1).getMemberActive());
                String basic_active1=listStandardPlanGenealogy.get(1).getBasicActive();
                String starter_active1=listStandardPlanGenealogy.get(1).getMemberbronzeActive();
                String username1=listStandardPlanGenealogy.get(1).getName();
                uid1=listStandardPlanGenealogy.get(1).getUserid();
                txttwo.setText(username1);
                if (uid1==null){
                    Glide.with(getApplicationContext())
                            .load(R.drawable.vacant)
                            .into(imgtwo);
                }
                if (mem_active1.equals("Y")) {
                    Glide.with(getApplicationContext())
                            .load(R.drawable.active)
                            .into(imgtwo);

                }else if(basic_active1.equals("Y")){
                    Glide.with(getApplicationContext())
                            .load(R.drawable.basicplan)
                            .into(imgtwo);
                }else if (starter_active1.equals("Y")){

                    Glide.with(getApplicationContext())
                            .load(R.drawable.bronzeactive)
                            .into(imgtwo);
                }else {
                    Glide.with(getApplicationContext())
                            .load(R.drawable.notactive)
                            .into(imgtwo);

                }
                //position 2
                String mem_active2= String.valueOf(listStandardPlanGenealogy.get(2).getMemberActive());
                String basic_active2=listStandardPlanGenealogy.get(2).getBasicActive();
                String starter_active2=listStandardPlanGenealogy.get(2).getMemberbronzeActive();
                String username2=listStandardPlanGenealogy.get(2).getName();
                String sponsorid2=listStandardPlanGenealogy.get(2).getSponsorId();
                uid2=listStandardPlanGenealogy.get(2).getUserid();
                txtthree.setText(username2);
                if (uid2==null){
                    Glide.with(getApplicationContext())
                            .load(R.drawable.vacant)
                            .into(imgthree);
                }

                if (mem_active2.equals("Y")) {
                    Glide.with(getApplicationContext())
                            .load(R.drawable.active)
                            .into(imgthree);

                }else if(basic_active2.equals("Y")){
                    Glide.with(getApplicationContext())
                            .load(R.drawable.basicplan)
                            .into(imgthree);
                }else if (starter_active2.equals("Y")){

                    Glide.with(getApplicationContext())
                            .load(R.drawable.bronzeactive)
                            .into(imgthree);
                }else {
                    Glide.with(getApplicationContext())
                            .load(R.drawable.notactive)
                            .into(imgthree);

                }
                //position 3
                String mem_active3= String.valueOf(listStandardPlanGenealogy.get(3).getMemberActive());
                String basic_active3=listStandardPlanGenealogy.get(3).getBasicActive();
                String starter_active3=listStandardPlanGenealogy.get(3).getMemberbronzeActive();
                String username3=listStandardPlanGenealogy.get(3).getName();
                uid3=listStandardPlanGenealogy.get(3).getUserid();
                txtfour.setText(username3);
                if (uid3==null){
                    Glide.with(getApplicationContext())
                            .load(R.drawable.vacant)
                            .into(imgfour);
                }
                if (mem_active3.equals("Y")) {
                    Glide.with(getApplicationContext())
                            .load(R.drawable.active)
                            .into(imgfour);

                }else if(basic_active3.equals("Y")){
                    Glide.with(getApplicationContext())
                            .load(R.drawable.basicplan)
                            .into(imgfour);
                }else if (starter_active3.equals("Y")){

                    Glide.with(getApplicationContext())
                            .load(R.drawable.bronzeactive)
                            .into(imgfour);
                }else {
                    Glide.with(getApplicationContext())
                            .load(R.drawable.notactive)
                            .into(imgfour);

                }
                //position 4
                String mem_active4= String.valueOf(listStandardPlanGenealogy.get(4).getMemberActive());
                String basic_active4=listStandardPlanGenealogy.get(4).getBasicActive();
                String starter_active4=listStandardPlanGenealogy.get(4).getMemberbronzeActive();
                String username4=listStandardPlanGenealogy.get(4).getName();
                uid4=listStandardPlanGenealogy.get(4).getUserid();
                txtfive.setText(username4);
                if (uid4==null){
                    Glide.with(getApplicationContext())
                            .load(R.drawable.vacant)
                            .into(imgfive);
                }

                if (mem_active4.equals("Y")) {
                    Glide.with(getApplicationContext())
                            .load(R.drawable.active)
                            .into(imgfive);

                }else if(basic_active4.equals("Y")){
                    Glide.with(getApplicationContext())
                            .load(R.drawable.basicplan)
                            .into(imgfive);
                }else if (starter_active4.equals("Y")){

                    Glide.with(getApplicationContext())
                            .load(R.drawable.bronzeactive)
                            .into(imgfive);
                }else {
                    Glide.with(getApplicationContext())
                            .load(R.drawable.notactive)
                            .into(imgfive);

                }
                //position 5
                String mem_active5= String.valueOf(listStandardPlanGenealogy.get(5).getMemberActive());
                String basic_active5=listStandardPlanGenealogy.get(5).getBasicActive();
                String starter_active5=listStandardPlanGenealogy.get(5).getMemberbronzeActive();
                String username5=listStandardPlanGenealogy.get(5).getName();
                uid5=listStandardPlanGenealogy.get(5).getUserid();
                txtsix.setText(username5);
                if (uid5==null){
                    Glide.with(getApplicationContext())
                            .load(R.drawable.vacant)
                            .into(imgsix);
                }

                if (mem_active5.equals("Y")) {
                    Glide.with(getApplicationContext())
                            .load(R.drawable.active)
                            .into(imgsix);

                }else if(basic_active5.equals("Y")){
                    Glide.with(getApplicationContext())
                            .load(R.drawable.basicplan)
                            .into(imgsix);
                }else if (starter_active5.equals("Y")){

                    Glide.with(getApplicationContext())
                            .load(R.drawable.bronzeactive)
                            .into(imgsix);
                }else {
                    Glide.with(getApplicationContext())
                            .load(R.drawable.notactive)
                            .into(imgsix);

                }
                //position 6
                String mem_active6= String.valueOf(listStandardPlanGenealogy.get(6).getMemberActive());
                String basic_active6=listStandardPlanGenealogy.get(6).getBasicActive();
                String starter_active6=listStandardPlanGenealogy.get(6).getMemberbronzeActive();
                String username6=listStandardPlanGenealogy.get(6).getName();
                uid6=listStandardPlanGenealogy.get(6).getUserid();
                txtseven.setText(username6);
                if (uid6==null){
                    Glide.with(getApplicationContext())
                            .load(R.drawable.vacant)
                            .into(imgseven);
                }
                if (mem_active6.equals("Y")) {
                    Glide.with(getApplicationContext())
                            .load(R.drawable.active)
                            .into(imgseven);

                }else if(basic_active6.equals("Y")){
                    Glide.with(getApplicationContext())
                            .load(R.drawable.basicplan)
                            .into(imgseven);
                }else if (starter_active6.equals("Y")){

                    Glide.with(getApplicationContext())
                            .load(R.drawable.bronzeactive)
                            .into(imgseven);
                }else {
                    Glide.with(getApplicationContext())
                            .load(R.drawable.notactive)
                            .into(imgseven);

                }

            }








            //if($MemberActive0=='Y' )
            //		{
            //		    $image0 = 'active.jpg';
            //		}
            //			else if($c_basic_active0=='Y')
            //		{
            //			$image0 = 'df.png';
            //		}
            //		else if( $MemberbronzeActive0=='Y')
            //		{
            //			$image0 = 'bronzeactive.jpg';
            //		}
            //		else
            //		{
            //			$image0 = 'notactive.jpg';
            //		}




            @Override
            public void onFailure(Call<ResponseStandardGenealogy> call, Throwable t) {

            }
        });
    }

}