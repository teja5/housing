package com.vk.housing;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.vk.housing.util.ResultCallBackListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class UploadGroceryImageActivity extends AppCompatActivity {


    Button btn_upload,btn_pick;

    private static final int CAMERA_REQUEST = 1888;
    int SELECT_PICTURE = 200;

    private ArrayList<String> paths = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);

        btn_pick = findViewById(R.id.btn_pick);


        btn_upload = findViewById(R.id.btn_upload);


        btn_pick.setOnClickListener(v -> {
            imageDialog();
        });


        btn_upload.setOnClickListener(v -> {

            Injection.housingRepository(getApplicationContext()).uploadImage(paths.get(0), new ResultCallBackListener() {
                @Override
                public void onSuccess(Object o) {
                    Log.d("Success", o.toString());
                }

                @Override
                public void onFailure(Object o) {

                }
            });
//            Injection.housingRepository(getApplicationContext()).imageOrder("Bearer " + Util.getUser(getApplicationContext()).getToken(), Util.getUser(getApplicationContext()).getId(), paths, new ResultCallBackListener() {
//                @Override
//                public void onSuccess(Object o) {
//                    Log.d("Succes","Uploaded");
//                }
//
//                @Override
//                public void onFailure(Object o) {
//
//                }
//            });
        });

        //TODO Pick Images or Click Pictures

        //TODO Show List of Images

        //TODO Upload images to show orders

    }

    public void imageDialog() {
        Dialog dialog = new Dialog(UploadGroceryImageActivity.this);
        dialog.setContentView(R.layout.dialog_image_pick);
        dialog.findViewById(R.id.iv_image_two).setOnClickListener(view -> {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, CAMERA_REQUEST);
            dialog.dismiss();
        });
        dialog.findViewById(R.id.iv_image_one).setOnClickListener(view -> {
            Intent i = new Intent();
            i.setType("image/*");
            i.setAction(Intent.ACTION_GET_CONTENT);

            // pass the constant to compare it
            // with the returned requestCode
            startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
            dialog.dismiss();
        });
        dialog.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
//                    iv_pic.setImageURI(selectedImageUri);
                }
            } else if (requestCode == CAMERA_REQUEST) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                paths.add(saveToInternalStorage(photo));
//                iv_pic.setImageBitmap(photo);
            }
        }
    }

    private String saveToInternalStorage(Bitmap bitmapImage) {
        ContextWrapper cw = new ContextWrapper(UploadGroceryImageActivity.this);
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath = new File(directory, "profile"+paths.size()+".jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.JPEG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mypath.getAbsolutePath();
    }

//    public class uploadToServer extends AsyncTask<Void, Void, String> {
//
//        private ProgressDialog pd = new ProgressDialog(UploadGroceryImageActivity.this);
//        protected void onPreExecute() {
//            super.onPreExecute();
//            pd.setMessage("Wait image uploading!");
//            pd.show();
//        }
//
//        @Override
//        protected String doInBackground(Void... params) {
//
//            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//            nameValuePairs.add(new BasicNameValuePair("base64", ba1));
//            nameValuePairs.add(new BasicNameValuePair("ImageName", System.currentTimeMillis() + ".jpg"));
//            try {
//                HttpClient httpclient = new DefaultHttpClient();
//                HttpPost httppost = new HttpPost(URL);
//                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//                HttpResponse response = httpclient.execute(httppost);
//                String st = EntityUtils.toString(response.getEntity());
//                Log.v("log_tag", "In the try Loop" + st);
//
//            } catch (Exception e) {
//                Log.v("log_tag", "Error in http connection " + e.toString());
//            }
//            return "Success";
//
//        }
//
//        protected void onPostExecute(String result) {
//            super.onPostExecute(result);
//            pd.hide();
//            pd.dismiss();
//        }
//    }

}
