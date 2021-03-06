package com.Vicib.vicibapp.MyProfile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.loader.content.CursorLoader;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.Vicib.vicibapp.Complaints.ComplaintsRegistration;
import com.Vicib.vicibapp.ProductStore;
import com.bumptech.glide.Glide;
import com.Vicib.vicibapp.ApiClient;
import com.Vicib.vicibapp.ApiInterface;
import com.Vicib.vicibapp.District.DistAdapter;
import com.Vicib.vicibapp.District.DistrictList;
import com.Vicib.vicibapp.District.ResponseDistrict;
import com.Vicib.vicibapp.MainActivity;
import com.Vicib.vicibapp.R;
import com.Vicib.vicibapp.State.ResponseState;

import com.Vicib.vicibapp.State.StateList;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.wang.avi.AVLoadingIndicatorView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyProfile extends AppCompatActivity {

 CardView cardview_personalinfo,cardview_bankinfo;
 LinearLayout layout_personalinfo,layout_bankinfo;
 TextView myprofile_name,prof_userid,prof_sponsorid,prof_name,prof_dob,prof_mobile,prof_activateddate;
 LinearLayout prof_dash,prof_productstore,prof_compliants,prof_idcard;
 EditText edit_name,edit_dob,edit_mobile,edit_email,edit_address,edit_panchayath,edit_zipcode,edit_pannumber,edit_nomineename,edit_nomineerelation;
 EditText edit_bankname,edit_branch,edit_accountnum,edit_ifsc;
 Spinner edit_country,edit_state,edit_district;
 Button edit_update;
 RadioGroup edit_gender;
 RadioButton radioButton;


    ImageView picphoto;
    CircleImageView changephoto;
    AVLoadingIndicatorView photo_loader;
    private static final int SELECT_PIC = 100;
    private static final String TAG = "MyProfile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        photo_loader=findViewById(R.id.photo_loader);

        myprofile_name=findViewById(R.id.myprofile_name);
        prof_userid=findViewById(R.id.prof_userid);
        prof_sponsorid=findViewById(R.id.prof_sponsorid);
        prof_name=findViewById(R.id.prof_name);
        prof_dob=findViewById(R.id.prof_dob);
        prof_mobile=findViewById(R.id.prof_mobile);
        prof_activateddate=findViewById(R.id.prof_activateddate);

        edit_name=findViewById(R.id.edit_name);
        edit_gender=findViewById(R.id.edit_gender);
        edit_mobile=findViewById(R.id.edit_mobile);
        edit_dob=findViewById(R.id.edit_dob);
        edit_email=findViewById(R.id.edit_email);
        edit_address=findViewById(R.id.edit_address);
        edit_country=findViewById(R.id.edit_country);
        edit_state=findViewById(R.id.edit_state);
        edit_district=findViewById(R.id.edit_district);
        edit_panchayath=findViewById(R.id.edit_panchayath);
        edit_zipcode=findViewById(R.id.edit_zipcode);
        edit_pannumber=findViewById(R.id.edit_pannumber);
        edit_nomineename=findViewById(R.id.edit_nomineename);
        edit_nomineerelation=findViewById(R.id.edit_nomineerelation);

        edit_bankname=findViewById(R.id.edit_bankname);
        edit_branch=findViewById(R.id.edit_branch);
        edit_accountnum=findViewById(R.id.edit_accountnum);
        edit_ifsc=findViewById(R.id.edit_ifsc);
        edit_gender=findViewById(R.id.edit_gender);
        int selectedid=edit_gender.getCheckedRadioButtonId();
        radioButton=findViewById(selectedid);


        edit_update=findViewById(R.id.edit_update);
        edit_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Upadte();
            }
        });
        SharedPreferences shpref;
        shpref=getSharedPreferences("MYPREF", Context.MODE_PRIVATE);
        String id=shpref.getString("ID","");
        String uname=shpref.getString("USERNAME","");
        String name=shpref.getString("NAME","");
        Log.i(TAG, "name : " + name);
        String mob=shpref.getString("MOBILE","");
        String email=shpref.getString("EMAIL","");


        myprofile_name.setText(name);
        prof_userid.setText(id);
        prof_sponsorid.setText(uname);
        prof_mobile.setText(mob);

        cardview_personalinfo=findViewById(R.id.cardview_personalinfo);
        layout_bankinfo=findViewById(R.id.layout_bankinfo);
        layout_personalinfo=findViewById(R.id.layout_personalinfo);
        cardview_personalinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout_personalinfo.setVisibility(View.VISIBLE);
                layout_bankinfo.setVisibility(View.GONE);
                cardview_bankinfo.setBackgroundColor(Color.parseColor("#AFABAB"));
                cardview_personalinfo.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
        });
        cardview_bankinfo=findViewById(R.id.cardview_bankinfo);
        cardview_bankinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout_bankinfo.setVisibility(View.VISIBLE);
                layout_personalinfo.setVisibility(View.GONE);
                cardview_bankinfo.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                cardview_personalinfo.setCardBackgroundColor(Color.parseColor("#AFABAB"));


            }
        });

     prof_dash=findViewById(R.id.prof_dash);
     prof_dash.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             startActivity(new Intent(getApplicationContext(),MainActivity.class));
         }
     });

     prof_productstore=findViewById(R.id.prof_productstore);
     prof_productstore.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             startActivity(new Intent(getApplicationContext(), ProductStore.class));
         }
     });
     prof_compliants=findViewById(R.id.prof_compliants);
     prof_compliants.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             startActivity(new Intent(getApplicationContext(), ComplaintsRegistration.class));
         }
     });

     prof_idcard=findViewById(R.id.prof_idcard);
     prof_idcard.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             startActivity(new Intent(getApplicationContext(), ComplaintsRegistration.class));
         }
     });
     ViewPhoto();
     changephoto=findViewById(R.id.changephoto);
     picphoto=findViewById(R.id.picphoto);
     picphoto.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

//             handlePermission();
//             Intent i=new Intent();
//             i.setType("image/*");
//
//             i.setAction(Intent.ACTION_PICK);
//             startActivityForResult(Intent.createChooser(i, "Select Image"), 100);

             handlePermission();
             Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
             startActivityForResult(i, 100);

         }
     });
    }
    private void Upadte() {
        SharedPreferences shpref;
        shpref=getSharedPreferences("MYPREF", Context.MODE_PRIVATE);
        String id=shpref.getString("ID","");
        String name=edit_name.getText().toString();

        String mobile=edit_mobile.getText().toString();
        String email=edit_email.getText().toString();
        String dob=edit_dob.getText().toString();
        String address=edit_address.getText().toString();
        String panchayth=edit_panchayath.getText().toString();
        String zipcode=edit_zipcode.getText().toString();
        String pannumber=edit_pannumber.getText().toString();
        String noiminenname=edit_nomineename.getText().toString();
        String nomineerelation=edit_nomineerelation.getText().toString();
        String bankname=edit_bankname.getText().toString();
        String branch=edit_branch.getText().toString();
        String accountnum=edit_accountnum.getText().toString();
        String ifsc=edit_ifsc.getText().toString();
        String gen=radioButton.getText().toString();
        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseEditProfile> call = api.UpdateProf(Integer.parseInt(id),name,gen,dob,mobile,email,address,"99","KL","Kottayam",panchayth,zipcode,pannumber,bankname,branch,accountnum,ifsc,noiminenname,nomineerelation);
        call.enqueue(new Callback<ResponseEditProfile>() {
            @Override
            public void onResponse(Call<ResponseEditProfile> call, Response<ResponseEditProfile> response) {
                if (response.body().getStatus().equals("1")){
                    Toast.makeText(MyProfile.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MyProfile.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseEditProfile> call, Throwable t) {

            }
        });


    }
    private  void ViewPhoto(){
     SharedPreferences shpref;
     shpref=getSharedPreferences("MYPREF", Context.MODE_PRIVATE);
     String u=shpref.getString("ID","");
     ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
     Call<ResponseImageView> call = api.ViewPhoto(Integer.parseInt(u));
     call.enqueue(new Callback<ResponseImageView>() {
         @Override
         public void onResponse(Call<ResponseImageView> call, Response<ResponseImageView> response) {
             String img=response.body().getPath();
             if (response.body().getStatus().equals("1")) {
                 Log.e("pathh",img);
                 Glide.with(getApplicationContext())
                         .load(img)
                         .into(changephoto);
             }
         }
         @Override
         public void onFailure(Call<ResponseImageView> call, Throwable t) {
             Toast.makeText(MyProfile.this, "dhfbsdgfsh", Toast.LENGTH_SHORT).show();

         }
     });
 }
    private void handlePermission(){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //ask for permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    SELECT_PIC);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case SELECT_PIC:
                for (int i = 0; i < permissions.length; i++) {
                    String permission = permissions[i];
                    if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                        boolean showRationale = ActivityCompat.shouldShowRequestPermissionRationale(this, permission);
                        if (showRationale) {
                            //  Show your own message here
                        } else {
                            showSettingsAlert();
                        }
                    }
                }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    private void showSettingsAlert() {
        androidx.appcompat.app.AlertDialog alertDialog = new androidx.appcompat.app.AlertDialog.Builder(this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("App needs to access the Camera.");
        alertDialog.setButton(androidx.appcompat.app.AlertDialog.BUTTON_NEGATIVE, "DONT ALLOW",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //finish();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SETTINGS",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        openAppSettings(MyProfile.this);
                    }
                });
        alertDialog.show();
    }
    public static void openAppSettings(final Activity context) {
        if (context == null) {
            return;
        }
        final Intent i = new Intent();
        i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        i.addCategory(Intent.CATEGORY_DEFAULT);
        i.setData(Uri.parse("package:" + context.getPackageName()));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        context.startActivity(i);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            //the image URI

            final Uri selectedImage = data.getData();
            if (null !=selectedImage){
                String path=getRealPathFromURI(selectedImage);




                Log.i(TAG, "Image Path : " + path);
                picphoto.post(new Runnable() {
                    @Override
                    public void run() {
                        changephoto.setImageURI(selectedImage);
                        uploadFile(selectedImage);
                    }
                });
            }
        }
    }
    private String getRealPathFromURI(Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(this, contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();


        return result;
    }
    private void uploadFile(Uri fileUri) {

        photo_loader.setVisibility(View.VISIBLE);
        SharedPreferences shpref;
        shpref = getSharedPreferences("MYPREF", Context.MODE_PRIVATE);
        String u = shpref.getString("ID", "");
        //creating a file
        final File file = new File(getRealPathFromURI(fileUri));

//        int compressionRatio = 2;
//        try {
//            Bitmap bitmap = BitmapFactory.decodeFile (file.getPath ());
//            bitmap.compress (Bitmap.CompressFormat.JPEG, compressionRatio, new FileOutputStream(file));
//        }
//        catch (Throwable t) {
//            Log.e("ERROR", "Error compressing file." + t.toString ());
//            t.printStackTrace ();
//        }


        //creating request body for file
        final RequestBody requestFile = RequestBody.create(MediaType.parse(getContentResolver().getType(fileUri)),file);


        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseImageUpload> call = api.ImageUpload(requestFile, Integer.parseInt(u));
        call.enqueue(new Callback<ResponseImageUpload>() {
            @Override
            public void onResponse(Call<ResponseImageUpload> call, Response<ResponseImageUpload> response) {
                Log.i("onResponse", new Gson().toJson(response.body()));
                if (response.body().getStatus().equals("1")) {
                    Log.d("onResponse", "" + response.body().getMessage());
                    photo_loader.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "Profile picture updated successfully", Toast.LENGTH_LONG).show();

                } else {
                    photo_loader.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "Some error occurred..Please try again", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseImageUpload> call, Throwable t) {
                photo_loader.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Some error occurred..", Toast.LENGTH_LONG).show();
            }
        });
    }


        public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}
