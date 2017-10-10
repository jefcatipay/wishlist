package com.example.jefkrisfercatipay.wishlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jef Krisfer Catipay on 10/10/2017.
 */

public class addList extends AppCompatActivity {

    TextView name, desc, price;
    ImageView image;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_list);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViews();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        Intent data = new Intent();
        setResult(Activity.RESULT_OK, data);
        finish();

        return super.onOptionsItemSelected(item);
    }
    private void findViews() {
        name = (TextView) findViewById(R.id.etTitle);
        desc = (TextView) findViewById(R.id.etDesc);
        price = (TextView) findViewById(R.id.etPrice);
        image = (ImageView) findViewById(R.id.imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.verifyadd, menu);
        return true;
    }
}
