package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterItem extends RecyclerView.Adapter<AdapterItem.ItemViewHolder> {
    Context ctx;
    List<String> desc_list;
    List<Integer> image_list;

    public AdapterItem(Context ctx, List<String> deskripsi_list, List<Integer> image_list) {
        this.ctx = ctx;
        this.desc_list = deskripsi_list;
        this.image_list = image_list;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(ctx).inflate(R.layout.item_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterItem.ItemViewHolder holder, int position) {
        holder.tv_desc.setText(desc_list.get(position));
        holder.iv_product.setImageDrawable(ctx.getResources().getDrawable(image_list.get(position)));
    }

    @Override
    public int getItemCount() {
        return desc_list.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView iv_product;
        TextView tv_desc;
        Button btn_detail;

        public ItemViewHolder(View itemView) {
            super(itemView);
            iv_product = itemView.findViewById(R.id.product_iv);
            tv_desc = itemView.findViewById(R.id.desc_tv);
            btn_detail = itemView.findViewById(R.id.detail_btn);
            btn_detail.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v == btn_detail) {
                Intent i = new Intent(ctx, DetailActivity.class);
                i.putExtra("image", image_list.get(getAdapterPosition()));
                i.putExtra("text", desc_list.get(getAdapterPosition()));
                ctx.startActivity(i);
            }
        }
    }
}
