package com.example.jefkrisfercatipay.wishlist;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.List;

/**
 * Created by Jef Krisfer Catipay on 10/9/2017.
 */


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private List<wish> wishList;

    public MyAdapter(List<wish> wishList) {
        this.wishList = wishList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView wName, wDesc, wPrice;
        public ImageView wImage;

        public MyViewHolder(View view){
            super(view);
            wName =(TextView) view.findViewById(R.id.tvDname);
            wDesc =(TextView) view.findViewById(R.id.tvDdesc);
            wPrice =(TextView) view.findViewById(R.id.tvDprice);
            wImage=(ImageView) view.findViewById(R.id.ivThumbnail);
        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View iview = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview,parent,false);

        return new MyViewHolder(iview);
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        wish list = wishList.get(position);
        holder.wName.setText(list.getListName());
        holder.wDesc.setText(list.getListDesc());
        holder.wPrice.setText(Double.toString(list.getListPrice()));
        File file = new File(list.getImage());
        Bitmap bmp = BitmapFactory.decodeFile(file.getAbsolutePath());
        holder.wImage.setImageBitmap(bmp);

    }
    @Override
    public int getItemCount() {
        return wishList.size();
    }
}
