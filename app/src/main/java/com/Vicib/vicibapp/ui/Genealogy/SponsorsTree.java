package com.Vicib.vicibapp.ui.Genealogy;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.Vicib.vicibapp.ApiClient;
import com.Vicib.vicibapp.ApiInterface;
import com.Vicib.vicibapp.R;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SponsorsTree extends Fragment {
    LinearLayout new_entry_layout,new_entry_main,new_entry_text;
    TextView entry_level,entry_under,entry_side,up_username,entry_under_layout,up_username_layout,new_entry_under;
    LinearLayout new_rightentry_text,new_right_entry_layout;
    TextView up_right_username,new_right_entry_under,up_right_username_layout,entry_right_under_layout;
    RelativeLayout rl_right_entry,rl_left_entry;

    public SponsorsTree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view= inflater.inflate(R.layout.fragment_sponsors_tree, container, false);





        return view;
    }

}
