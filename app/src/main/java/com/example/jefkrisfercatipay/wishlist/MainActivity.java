package com.example.jefkrisfercatipay.wishlist;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String KEY_TEXT = "key_text" ;
    private static final int KEY_CODE =101 ;
    private static final String TAG ="listing" ;
    private Toolbar toolbar;
    private List<wish> wishList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;

    DatabaseHelper mDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabaseHelper = new DatabaseHelper(this);
        setContentView(R.layout.activity_home);
        findViews();
        setSupportActionBar(toolbar);
        populateView();
        updateViews();



        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent mIntent = new Intent(MainActivity.this, Detail.class);
                wish list = wishList.get(position);
                wish object = new wish(list.getListName(),list.getListDesc(),list.getListPrice(),list.getImage());
                mIntent.putExtra("details",object);
                startActivity(mIntent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));




    }

    public void addData(String name,String desc,Double price,String image) {
    boolean insertData = mDatabaseHelper.addData(name,desc,price,image);
        if(insertData){
            Toast.makeText(this, "Entry Added", Toast.LENGTH_SHORT).show();
        }
        else{

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        wish list =new wish();
        Intent mIntent = new Intent(MainActivity.this,addList.class);
        mIntent.putExtra(KEY_TEXT, list);
        startActivityForResult(mIntent,KEY_CODE);
        return super.onOptionsItemSelected(item);
    }

    private void findViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if(requestCode == KEY_CODE){
               // Toast.makeText(this, "main", Toast.LENGTH_SHORT).show();
                wish object = (wish) data.getSerializableExtra(KEY_TEXT);
                if (object!=null) {
                    //Toast.makeText(this, "adapter", Toast.LENGTH_SHORT).show();
                    addData(object.getListName(),object.getListDesc(),object.getListPrice(),object.getImage());
                    wishList.add(object);
                    updateViews();

                }
                else
                {
                    Toast.makeText(this, "NULLED", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void updateViews() {

        mAdapter = new MyAdapter(wishList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

    }
    private void populateView() {
        try {
            Log.d(TAG, "populate");
            wish object = new wish();
            Cursor data = mDatabaseHelper.getData();
            while (data.moveToNext()) {
                object = new wish(data.getString(1), data.getString(2), data.getDouble(3), data.getString(4));
                wishList.add(object);
            }
        }catch
                (Exception a){
            Toast.makeText(this, "data null", Toast.LENGTH_SHORT).show();
        }
    }
}

