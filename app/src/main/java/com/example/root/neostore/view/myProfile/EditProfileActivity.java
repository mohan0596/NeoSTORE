package com.example.root.neostore.view.myProfile;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.neostore.R;
import com.example.root.neostore.common.Base.BaseActivity;

import java.io.Serializable;

import de.hdodenhof.circleimageview.CircleImageView;
import pub.devrel.easypermissions.EasyPermissions;

public class EditProfileActivity extends BaseActivity implements Serializable, View.OnClickListener {
    private Toolbar toolbar;
    private TextView title;
    private CircleImageView civ_profile;
    private static int IMG_RESULT=1;
    private Button btn_submitt;

    @Override
    protected int getContentView() {
        return R.layout.activity_edit_profile;
    }

    @Override
    protected void initView() {
        toolbar=findViewById(R.id.my_toolbar);
        title=toolbar.findViewById(R.id.title);
        civ_profile=findViewById(R.id.profile_pic_id);
        btn_submitt=findViewById(R.id.submit_id);

    }

    @Override
    protected void setListeners() {
        civ_profile.setOnClickListener(this);
        btn_submitt.setOnClickListener(this);

    }

    @Override
    protected void setActionBar() {
        title.setText(R.string.edit_profile);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
    }

    @Override
    protected void setAdapter() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:onBackPressed();
                break;

            case R.id.search_id:
                return true;
        }
        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String ImageDecode;
        super.onActivityResult(requestCode, resultCode, data);
        String[] galleryPermissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};

        if (EasyPermissions.hasPermissions(this, galleryPermissions)) {
            pickImageFromGallery();
        } else {
            EasyPermissions.requestPermissions(this, "Access for storage",
                    101, galleryPermissions);
        }
        try {

            if (requestCode == IMG_RESULT && resultCode == RESULT_OK
                    && null != data) {


                Uri URI = data.getData();
                String[] FILE = { MediaStore.Images.Media.DATA };


                Cursor cursor = getContentResolver().query(URI,
                        FILE, null, null, null);

                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(FILE[0]);
                ImageDecode = cursor.getString(columnIndex);
                cursor.close();

                civ_profile.setImageBitmap(BitmapFactory
                        .decodeFile(ImageDecode));

            }
        } catch (Exception e) {
            Toast.makeText(this, "Please try again", Toast.LENGTH_LONG)
                    .show();
        }

    }

    private void pickImageFromGallery() {
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId())
        {
            case R.id.profile_pic_id:
                intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,IMG_RESULT);
                break;
            case R.id.submit_id:
                civ_profile.setDrawingCacheEnabled(true);
                Bitmap b=civ_profile.getDrawingCache();
                intent=new Intent(this, MyAccountActivity.class);
                intent.putExtra("Bitmap", b);
                startActivity(intent);
        }
    }
}
