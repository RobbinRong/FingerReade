package com.robbin.fingerread.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.robbin.fingerread.R;
import com.robbin.fingerread.bean.MovieCommonsZY;
import com.robbin.fingerread.constant.Settings;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/20.
 */
public class MovieCommonZYAdapter extends RecyclerView.Adapter<MovieCommonZYAdapter.ViewHoler> {
    private MovieCommonsZY commonsZY;
    private  Context context;

    public MovieCommonZYAdapter(MovieCommonsZY commonsZY, Context context) {
        this.commonsZY = commonsZY;
        this.context = context;
    }

    @Override
    public ViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_common_zy,parent,false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(ViewHoler holder, int position) {
        MovieCommonsZY.Data data = commonsZY.data.get(position);
        if(Settings.isNightMode){
            holder.cvItem.setCardBackgroundColor(Color.rgb(100,100,100));
        }
        Glide.with(context).load(data.avatarurl).placeholder(R.drawable.ic_placeholder).into(holder.imUserLogo);
        holder.tvName.setText(data.nickName);
        holder.tvAuthinfo.setText(data.authInfo);
        holder.tvApprove.setText(data.approve+"");
        holder.tvScore.setText(data.score*2+"");
        holder.tvContent.setText(data.content);
        holder.tvDate.setText(data.startTime);
    }

    @Override
    public int getItemCount() {
        if(null!=commonsZY&&!commonsZY.data.isEmpty()){
            return  commonsZY.data.size();
        }
        return 0;

    }
    public void change(MovieCommonsZY commonsZY){
        this.commonsZY=commonsZY;
        this.notifyDataSetChanged();
    }
    public void append(MovieCommonsZY commonsZY){
        this.commonsZY.data.addAll(commonsZY.data);
        this.notifyDataSetChanged();
    }


    class ViewHoler extends RecyclerView.ViewHolder{
        @Bind(R.id.cv_item)
        CardView cvItem;
        @Bind(R.id.iv_zy)
        com.makeramen.roundedimageview.RoundedImageView imUserLogo;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_authinfo)
        TextView tvAuthinfo;
        @Bind(R.id.tv_score)
        TextView tvScore;
        @Bind(R.id.tv_content)
        TextView tvContent;
        @Bind(R.id.tv_date)
        TextView tvDate;
        @Bind(R.id.tv_common_approve)
        TextView tvApprove;

        public ViewHoler(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
