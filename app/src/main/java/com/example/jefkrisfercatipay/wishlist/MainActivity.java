package com.example.jefkrisfercatipay.wishlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    ListView mList;
    int[] image ={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    String[] listName ={"somebody","once","told","me"};
    String[] listDesc ={"this meme tho 1","this meme tho 2","this meme tho 3","this meme tho 4"};
    double[] listPrice ={1.99,2.99,3.99,4.99};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        findViews();
        setSupportActionBar(toolbar);
        listName[1] = "a";
        MyAdapter listView = new MyAdapter(MainActivity.this, listName, listDesc, listPrice, image);
        mList.setAdapter((ListAdapter) listView);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(MainActivity.this, Detail.class);
                mIntent.putExtra("name", listName[i]);
                mIntent.putExtra("desc", listDesc[i]);
                mIntent.putExtra("price", listPrice[i]);
                mIntent.putExtra("image", image[i]);
                startActivity(mIntent);
            }
        });

        //end of list view


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
        mList = (ListView) findViewById(R.id.list);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

}
