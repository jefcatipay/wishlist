package com.example.jefkrisfercatipay.wishlist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

/**
 * Created by Jef Krisfer Catipay on 10/10/2017.
 */

public class Edit extends AppCompatActivity {

    private static final String KEY_TEXT = "key_text";
    private static final String KEY_TEST = "EDIT";
    private static final int CAMERA_REQUEST = 1888;
    TextView name, desc, price;
    ImageView image;
    String p= "";
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_list);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViews();

        Intent mintent = getIntent();
        wish w = (wish) mintent.getSerializableExtra(KEY_TEST);
        name.setText(w.getListName());
        desc.setText(w.getListDesc());
        price.setText(Double.toString(w.getListPrice()));

        File file = new File(w.getImage());

        Bitmap bmp = BitmapFactory.decodeFile(file.getAbsolutePath());
        image.setImageBitmap(bmp);

        image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);

            }

        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        try {
            //  Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
            String temp1 = name.getText().toString();
            String temp2 = desc.getText().toString();
            Double temp3 = Double.parseDouble(price.getText().toString());

            Intent data = new Intent(Edit.this, Detail.class);
            Bundle extra = new Bundle();
            wish object = new wish(temp1,temp2,temp3,p);

            //  Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
            extra.putSerializable(KEY_TEXT, object);
            data.putExtras(extra);
            setResult(Activity.RESULT_OK, data);

            //    Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
            finish();
        }
        catch(Exception z){
            Toast.makeText(this, "Please Complete all the data", Toast.LENGTH_SHORT).show();
        }
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
    private void SaveImage(Bitmap finalBitmap) {

        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/saved_images");
        myDir.mkdirs();

        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-"+ n +".jpg";
        File file = new File (myDir, fname);
        if (file.exists ()) file.delete ();
        try {
            FileOutputStream out = new FileOutputStream(file);

            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CAMERA_REQUEST && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap bitmap =(Bitmap) extras.get("data");

            SaveImage(bitmap);
            Uri tempUri = getImageUri(getApplicationContext(), bitmap);
            File finalFile = new File(getRealPathFromURI(tempUri));
            p = finalFile.toString();
            Bitmap bmp = BitmapFactory.decodeFile(finalFile.getAbsolutePath());
            image.setImageBitmap(bmp);

            //   Toast.makeText(this, "end result", Toast.LENGTH_SHORT).show();
        }
    }
}

