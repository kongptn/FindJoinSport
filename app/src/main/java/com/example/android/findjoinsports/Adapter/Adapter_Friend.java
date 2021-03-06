package com.example.android.findjoinsports.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.findjoinsports.Constants.ConstansAPI;
import com.example.android.findjoinsports.DATA.User_Data;
import com.example.android.findjoinsports.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_Friend extends RecyclerView.Adapter<Adapter_Friend.MyViewHolder> {

    private List<User_Data> user_dataList;
    private Context context;
    private OnItemClickListener listener;


    public Adapter_Friend(List<User_Data> user_dataList, Context context, OnItemClickListener listener) {
        this.user_dataList = user_dataList;
        this.context = context;
        this.listener = listener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    public interface OnItemClickListener {
        void listener(int uesr_id, String name, String email, String user_firstname, String user_lastname, String user_tel, String user_age, String user_sex, String photo_user);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final User_Data user_data = user_dataList.get(position);


        holder.name.setText(user_data.getName());
        holder.email.setText(user_data.getEmail());


        String ph = ConstansAPI.URL_PHOTO_USER+user_data.getPhoto_user();

        if (ph.equalsIgnoreCase("")) {
            ph = "default";
        }
        Picasso.with(context).load(ph).placeholder(R.drawable.n).into(holder.images);

        /* String reg = "[0-9]{16}";
        String temp = us.getPhoto_user();
        String ph = "";
        boolean matches = Pattern.matches(reg, temp);
        if (matches)
            ph = "https://graph.facebook.com/" + us.getPhoto_user() + "/picture?width=250&height=250";
    else ph = "http://192.168.1.3/android_register_login/"+us.getPhoto_user();


        if (ph.equalsIgnoreCase("")){
            ph = "default";
        }
        Picasso.with(context).load(ph).placeholder(R.drawable.se_ball).into(holder.images);
        Log.d("pp", ph);*/


        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.listener(user_dataList.get(position).getId(), user_dataList.get(position).getName(), user_dataList.get(position).getEmail(), user_dataList.get(position).getUser_firstname(), user_dataList.get(position).getUser_lastname(), user_dataList.get(position).getUser_tel(), user_dataList.get(position).getUser_age(), user_dataList.get(position).getUser_sex(), user_dataList.get(position).getPhoto_user());

            }
        });
    }

    @Override
    public int getItemCount() {
        return user_dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, email, user_tel, user_sex, user_age, user_firstname, user_lastname;
        ImageView images;
        LinearLayout rootView;


        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            images = itemView.findViewById(R.id.images);
            rootView = itemView.findViewById(R.id.rootView);
        }
    }
}