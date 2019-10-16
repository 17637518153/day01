package com.example.wanzixizuoye_one.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wanzixizuoye_one.R;
import com.example.wanzixizuoye_one.bean.FenLeiBean;

import java.util.List;

public class FenLeiAdapter extends RecyclerView.Adapter<FenLeiAdapter.ViewHolder> {


    private Context context;
    private List<FenLeiBean.DataBean.CurrentCategoryBean.SubCategoryListBean> beanList;

    public FenLeiAdapter(Context context, List<FenLeiBean.DataBean.CurrentCategoryBean.SubCategoryListBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fenlei, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        FenLeiBean.DataBean.CurrentCategoryBean.SubCategoryListBean bean = beanList.get(i);
        viewHolder.tv_name.setText(bean.getName());
        Glide.with(context).load(bean.getWap_banner_url()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tv_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }
}
