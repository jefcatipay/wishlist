package com.example.jefkrisfercatipay.wishlist;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import static android.R.id.list;

/**
 * Created by Jef Krisfer Catipay on 10/9/2017.
 */
public class Detail extends AppCompatActivity {
    private static final int KEY_CODE = 999 ;
    private static final String KEY_TEST = "EDIT";
    private static final String TAG ="DETAIL" ;
    TextView testname,testdesc,testprice;
    ImageView imgDesc;
    private Toolbar toolbar;
//   wish b;
    DatabaseHelper mDatabaseHelper;
    String p="";

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findviews();




        Intent mintent = getIntent();
        wish w = (wish) mintent.getSerializableExtra("details");

        testname.setText(w.getListName());
        testdesc.setText(w.getListDesc());
        testprice.setText(Double.toString(w.getListPrice()));
        p = w.getImage();

        Toast.makeText(this, p, Toast.LENGTH_SHORT).show();
        File file = new File(w.getImage());

        Bitmap bmp = BitmapFactory.decodeFile(file.getAbsolutePath());
        imgDesc.setImageBitmap(bmp);

        }

    private void findviews() {
        testname= (TextView) findViewById(R.id.etTitle);
        testdesc= (TextView) findViewById(R.id.etDesc);
        testprice= (TextView) findViewById(R.id.etPrice);
        imgDesc= (ImageView) findViewById(R.id.imageView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();

        int id = item.getItemId();
        findviews();


        if(id == R.id.edit){
            try {
                String temp1 = testname.getText().toString();
                String temp2 = testdesc.getText().toString();
                Double temp3 = Double.parseDouble(testprice.getText().toString());

                wish object = new wish(temp1, temp2, temp3, p);
                Intent mIntent = new Intent(Detail.this,Edit.class);

                mIntent.putExtra(KEY_TEST,object);
                startActivityForResult(mIntent,KEY_CODE);

            }catch(Exception a){
                Toast.makeText(this, "error on click", Toast.LENGTH_SHORT).show();
            }

        }
        if(id == R.id.delete){
            try {

                String temp1 = testname.getText().toString();
                Cursor data = mDatabaseHelper.getWishID(temp1);
                int itemID = -1;
                while (data.moveToNext()) {
                    itemID = data.getInt(0);
                }
                if (itemID > -1) {
                    Log.d(TAG, " found it" + itemID);
                }
                mDatabaseHelper.deleteWish(itemID, temp1);
                Toast.makeText(this, "DELETE", Toast.LENGTH_SHORT).show();
                Intent mIntent = new Intent(Detail.this, MainActivity.class);
                startActivity(mIntent);
            }catch (Exception a){
                Toast.makeText(this, "error on delete", Toast.LENGTH_SHORT).show();
            }
        }

        return super.onOptionsItemSelected(item);
    }
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.details, menu);
        return true;
    }

}




