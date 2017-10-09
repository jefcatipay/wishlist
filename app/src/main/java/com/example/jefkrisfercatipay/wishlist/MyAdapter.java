package com.example.jefkrisfercatipay.wishlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jef Krisfer Catipay on 10/9/2017.
 */

public class MyAdapter extends ArrayAdapter<String> {

    private String[] listName;
    private String[] listDesc;
    private double[] listPrice;
    private int[] imgDesc;

    private Context context;

    public MyAdapter(Context context, String[] testname, String[] listDesc, double[] listPrice, int[] imgDesc) {
        super(context, R.layout.listview);

        this.context = context;
        this.listName =testname;
        this.imgDesc =imgDesc;
        this.listDesc = listDesc;
        this.listPrice = listPrice;
}

    @Override
    public int getCount() {
        return listName.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                ViewHolder viewHolder = new ViewHolder();
        if (convertView == null)
        {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listview,parent,false);

            viewHolder.listName =(TextView) convertView.findViewById(R.id.tvDname);
            viewHolder.listDesc =(TextView) convertView.findViewById(R.id.tvDdesc);
            viewHolder.listPrice =(TextView) convertView.findViewById(R.id.tvDprice);
            viewHolder. imgDesc=(ImageView) convertView.findViewById(R.id.ivThumbnail);

            convertView.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) convertView.getTag();
        }

        viewHolder.imgDesc.setImageResource(imgDesc[position]);
        viewHolder.listName.setText(listName[position]);
        viewHolder.listPrice.setText(Double.toString(listPrice[position]));
        viewHolder.listDesc.setText(listDesc[position]);
        return convertView;

    }
    static class ViewHolder
    {
        TextView listName, listDesc, listPrice;
        ImageView imgDesc;
    }
}
