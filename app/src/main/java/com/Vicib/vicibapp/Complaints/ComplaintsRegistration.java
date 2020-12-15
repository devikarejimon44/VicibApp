package com.Vicib.vicibapp.Complaints;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.Vicib.vicibapp.IDCard;
import com.Vicib.vicibapp.MainActivity;
import com.Vicib.vicibapp.MyProfile.MyProfile;
import com.Vicib.vicibapp.ProductStore;
import com.Vicib.vicibapp.R;
import com.Vicib.vicibapp.ui.Dashboard.DashBoardFragment;

public class ComplaintsRegistration extends AppCompatActivity {
    LinearLayout complaints_dash,complaints_productstore,complaints_compliants,complaints_idcard,compliants_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaints_registration);
        ImageView back_complaintregistration=findViewById(R.id.back_complaintregistration);
        back_complaintregistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        complaints_dash=findViewById(R.id.complaints_dash);
        complaints_dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        complaints_productstore=findViewById(R.id.complaints_productstore);
        complaints_productstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProductStore.class));
            }
        });
        complaints_compliants=findViewById(R.id.complaints_compliants);
        complaints_idcard=findViewById(R.id.complaints_idcard);
        complaints_idcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), IDCard.class));
            }
        });
        compliants_profile=findViewById(R.id.compliants_profile);
        compliants_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MyProfile.class));
            }
        });
    }
}