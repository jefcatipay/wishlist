package com.example.jefkrisfercatipay.wishlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        wish list = wishList.get(position);
        holder.wName.setText(list.getListName());
        holder.wDesc.setText(list.getListDesc());
        holder.wPrice.setText(Double.toString(list.getListPrice()));
        holder.wImage.setImageResource(list.getImage());

    }
    @Override
    public int getItemCount() {
        return wishList.size();
    }
}


//public class MyAdapter extends ArrayAdapter<String> {
//
//
//    private List<wish> wishList;
//    private Context context;
//
//    public MyAdapter(Context context,List<wish> wishList) {
//        super(context, R.layout.listview);
//
//        this.context = context;
//        this.wishList = wishList;
//}
//
//    @Override
//    public int getCount() {
//        return wishList.size()
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//                ViewHolder viewHolder = new ViewHolder();
//        if (convertView == null)
//        {
//
//            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = layoutInflater.inflate(R.layout.listview,parent,false);
//
//            viewHolder.listName =(TextView) convertView.findViewById(R.id.tvDname);
//            viewHolder.listDesc =(TextView) convertView.findViewById(R.id.tvDdesc);
//            viewHolder.listPrice =(TextView) convertView.findViewById(R.id.tvDprice);
//            viewHolder. imgDesc=(ImageView) convertView.findViewById(R.id.ivThumbnail);
//
//            convertView.setTag(viewHolder);
//        }
//        else{
//            viewHolder= (ViewHolder) convertView.getTag();
//        }
//
//        viewHolder.imgDesc.setImageResource(wishList);
//        viewHolder.listName.setText(listName[position]);
//        viewHolder.listPrice.setText(Double.toString(listPrice[position]));
//        viewHolder.listDesc.setText(listDesc[position]);
//        return convertView;
//
//    }
//    static class ViewHolder
//    {
//        TextView listName, listDesc, listPrice;
//        ImageView imgDesc;
//    }
//}
