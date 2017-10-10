package com.example.jefkrisfercatipay.wishlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String KEY_TEXT = "key_text" ;
    private static final int KEY_CODE =101 ;
    private Toolbar toolbar;
    public List<wish> wishList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;

    ListView mList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        findViews();
        setSupportActionBar(toolbar);

    mAdapter = new MyAdapter(wishList);
    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent mIntent = new Intent(MainActivity.this, Detail.class);
                startActivity(mIntent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                // ...
            }
        }));

    wish w = new wish("SOME","BODY",1.99,R.drawable.insertphoto);
        wishList.add(w);
    w = new wish("TOLD","ME",2.99,R.drawable.insertphoto);
        wishList.add(w);




  //      mList.setAdapter((ListAdapter) listView);
//        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent mIntent = new Intent(MainActivity.this, Detail.class);

//                startActivity(mIntent);
//            }
//        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent mIntent = new Intent(MainActivity.this,addList.class);
        startActivity(mIntent);

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

            }


        }

    }
}
