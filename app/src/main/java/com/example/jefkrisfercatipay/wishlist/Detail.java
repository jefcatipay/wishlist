package com.example.jefkrisfercatipay.wishlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jef Krisfer Catipay on 10/9/2017.
 */

public class Detail extends AppCompatActivity {
    TextView testname,testdesc,testprice;
    ImageView imgDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.list_detail);

        testname= (TextView) findViewById(R.id.tvDname);
        testdesc= (TextView) findViewById(R.id.tvDdesc);
        testprice= (TextView) findViewById(R.id.tvDprice);
        imgDesc= (ImageView) findViewById(R.id.ivDimg);

        Bundle bundle =getIntent().getExtras();
        if(bundle!=null){
            testname.setText(bundle.getString("name"));
            testdesc.setText(bundle.getString("desc"));
            testprice.setText(Double.toString(bundle.getDouble("price")));
            imgDesc.setImageResource(bundle.getInt("image"));

        }

    }


}
