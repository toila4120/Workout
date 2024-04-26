package com.example.workout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context mContext;
    private List<User> mListUser;

    public UserAdapter(Context mContext, List<User> mListUser) {
        this.mContext = mContext;
        this.mListUser = mListUser;
    }

    public UserAdapter(){
    }

    public void setData(List<User> list) {
        this.mListUser = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflate= LayoutInflater.from(mContext);
        view=inflate.inflate(R.layout.item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        final User user=mListUser.get(position);
        if (user==null) {
            return;
        }
        holder.textView.setText(mListUser.get(position).getName());
        holder.textView2.setText(mListUser.get(position).getDemdExercises());
        Glide.with(mContext)
                .load((mListUser.get(position).getImgname()))
                .into(holder.imgName1);
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGoTo(user, position);
            }
        });
    }
    private void onClickGoTo(User user,int position ) {
        Intent intent=new Intent(mContext,cardio.class);
        Bundle bundle= new Bundle();
        bundle.putSerializable(mListUser.get(position).getName().toLowerCase(),user);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if(mListUser !=null ) {
            return mListUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout layoutItem;
        private ImageView imgName1;
        private TextView textView;
        private TextView textView2;

        public UserViewHolder(View itemView) {
            super(itemView);
            layoutItem=itemView.findViewById(R.id.layout_item);
            imgName1=itemView.findViewById(R.id.imgname);
            textView=itemView.findViewById(R.id.name);
            textView2=itemView.findViewById(R.id.textView2);
        }
    }
}
