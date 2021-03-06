package com.example.android.findjoinsports.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.findjoinsports.Constants.ConstansAPI;
import com.example.android.findjoinsports.DATA.Comment_Data;
import com.example.android.findjoinsports.DATA.Notification_Data;
import com.example.android.findjoinsports.DATA.Request_JoinData_Creator;
import com.example.android.findjoinsports.DATA.User_Data;
import com.example.android.findjoinsports.R;
import com.example.android.findjoinsports.Request_Join_Creator;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.regex.Pattern;

public class Adapter_Comment extends RecyclerView.Adapter<Adapter_Comment.MyViewHolder> {

    private List<Comment_Data> comment_dataList;
    private Context context;
    private OnItemClickListener listener;


    public Adapter_Comment(List<Comment_Data> comment_dataList, Context context, OnItemClickListener listener) {
        this.comment_dataList = comment_dataList;
        this.context = context;
        this.listener = listener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_comment, parent, false);
        return new MyViewHolder(view);
    }

    public interface OnItemClickListener {


        void onItemClick(int id);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Comment_Data comment_data = comment_dataList.get(position);


        holder.name.setText(comment_data.getName());
        holder.tv_comment.setText(comment_data.getCm_data());


        String ph = ConstansAPI.URL_PHOTO_USER +comment_data.getPhoto_user();

        if (ph.equalsIgnoreCase("")){
            ph = "default";
        }
        Picasso.with(context).load(ph).placeholder(R.drawable.n).into(holder.images);


//        String reg = "[0-9]{16}";
//        String temp = user_data.getPhoto_user();
//        String ph = "";
//        boolean matches = Pattern.matches(reg, temp);
//        if (matches)
//            ph = "https://graph.facebook.com/" + user_data.getPhoto_user() + "/picture?width=250&height=250";
//        else ph = "http://192.168.1.3/android_register_login/"+user_data.getPhoto_user();
//
//
//        if (ph.equalsIgnoreCase("")){
//            ph = "default";
//        }
//        Picasso.with(context).load(ph).placeholder(R.drawable.se_ball).into(holder.images);
//        Log.d("pp", ph);


        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick((comment_data.getId()));
//                listener.onItemClick(Integer.parseInt(notification_data.getStatus_id()));




            }


            // listener.listener(user_dataList.get(position).getId(), user_dataList.get(position).getName(), user_dataList.get(position).getEmail(), user_dataList.get(position).getUser_firstname(), user_dataList.get(position).getUser_lastname(), user_dataList.get(position).getUser_tel(), user_dataList.get(position).getUser_age(), user_dataList.get(position).getUser_sex(), user_dataList.get(position).getPhoto_user());


        });
    }

    @Override
    public int getItemCount() {
        return comment_dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, tv_comment, user_tel, user_sex, user_age, user_firstname, user_lastname;
        ImageView images;
        LinearLayout rootView;


        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            tv_comment = itemView.findViewById(R.id.tv_comment);
            images = itemView.findViewById(R.id.images);
            rootView = itemView.findViewById(R.id.rootView);
        }
    }
}
