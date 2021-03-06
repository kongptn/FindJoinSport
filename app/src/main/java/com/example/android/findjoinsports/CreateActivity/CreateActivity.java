package com.example.android.findjoinsports.CreateActivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.findjoinsports.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateActivity extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_act, null);


        Button bt_cre_fb_type = (Button) view.findViewById(R.id.bt_cre_fb_type);
        bt_cre_fb_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),CreateFootball.class);
                startActivity(i);
            }
        });

        Button bt_cre_bas_type = (Button) view.findViewById(R.id.bt_cre_bas_type);
        bt_cre_bas_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),CreateBasketball.class);
                startActivity(i);
            }
        });


        Button bt_cre_bad_type = (Button) view.findViewById(R.id.bt_cre_bbgun_type);
        bt_cre_bad_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),CreateBB_Gun.class);
                startActivity(i);
            }
        });
        return view;
    }

}
