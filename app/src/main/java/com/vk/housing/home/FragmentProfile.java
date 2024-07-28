package com.vk.housing.home;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vk.housing.Injection;
import com.vk.housing.R;
import com.vk.housing.adapter.ProfileAdapter;
import com.vk.housing.data.remote.dao.Settings;
import com.vk.housing.settings.SettingsActivity;
import com.vk.housing.util.OnActionClickListener;
import com.vk.housing.util.ResultCallBackListener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FragmentProfile extends Fragment implements OnActionClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int CAMERA_REQUEST = 1888;
    int SELECT_PICTURE = 200;
    ImageView iv_pic;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView rv_profile_items;

    ProfileAdapter profileAdapter;

    ArrayList<Settings> settings;

    public FragmentProfile() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentProfile newInstance(String param1, String param2) {
        FragmentProfile fragment = new FragmentProfile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        iv_pic = view.findViewById(R.id.iv_picture);
        iv_pic.setOnClickListener(view1 -> {
//            Intent intent = new Intent(getActivity(), SettingsActivity.class);
//            startActivity(intent);
            imageDialog();
        });

        rv_profile_items = view.findViewById(R.id.rv_profile_items);
        rv_profile_items.setLayoutManager(new LinearLayoutManager(
                getActivity(),
                LinearLayoutManager.VERTICAL,
                false));
        settings = new ArrayList<>();
        settings.add(new Settings(1, "Edit Profile"));
        settings.add(new Settings(2, "Saved Properties"));
        settings.add(new Settings(3, "Change Password"));
        settings.add(new Settings(4, "About Us"));
        settings.add(new Settings(5, "Terms Of Service"));
        profileAdapter = new ProfileAdapter(settings, getActivity(), this);
        rv_profile_items.setAdapter(profileAdapter);

        return view;
    }

    void uploadImage(long property_id, String filepath) {
        Injection.housingRepository(getContext()).uploadImage(property_id, filepath, new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {

            }

            @Override
            public void onFailure(Object o) {

            }
        });
    }

    public void imageDialog() {
        Dialog dialog = new Dialog(getContext());
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

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (resultCode == Activity.RESULT_OK) {
//
//            // compare the resultCode with the
//            // SELECT_PICTURE constant
//            if (requestCode == SELECT_PICTURE) {
//                // Get the url of the image from data
//                Uri selectedImageUri = data.getData();
//                if (null != selectedImageUri) {
//                    // update the preview image in the layout
//                    iv_pick.setImageURI(selectedImageUri);
//                }
//            }
//        }
//    }


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
                    iv_pic.setImageURI(selectedImageUri);
                }

                try {
                    InputStream inputStream = getActivity().getContentResolver().openInputStream(data.getData());
                    if (inputStream != null) {
                        Log.d("IS", "Notnull");
                    } else {
                        Log.d("IS", "null");
                    }
                    saveInputStream(inputStream);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
//                savefile(selectedImageUri);

            } else if (requestCode == CAMERA_REQUEST) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                uploadImage(2, saveToInternalStorage(photo));
                iv_pic.setImageBitmap(photo);
            }
        }
    }

    //TODO Pick image and upload image
    private void saveInputStream(InputStream is) {

        ContextWrapper cw = new ContextWrapper(getContext().getApplicationContext());

        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath = new File(directory, "check.jpg");

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(new FileOutputStream(mypath.getAbsolutePath(), false));
            byte[] buf = new byte[1024];
            bis.read(buf);
            do {
                bos.write(buf);
            } while (bis.read(buf) != -1);
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("Exception", e.getMessage());
        } finally {
            try {
                if (bis != null) bis.close();
                if (bos != null) bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //TODO Picking image check
    private void savefile(Uri sourceuri) {
        String sourceFilename = sourceuri.getPath();
//        String destinationFilename = android.os.Environment.getExternalStorageDirectory().getPath()+File.separatorChar+"abc.mp3";
        ContextWrapper cw = new ContextWrapper(getContext().getApplicationContext());

        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath = new File(directory, "check.jpg");

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(sourceFilename));
            bos = new BufferedOutputStream(new FileOutputStream(mypath.getAbsolutePath(), false));
            byte[] buf = new byte[1024];
            bis.read(buf);
            do {
                bos.write(buf);
            } while (bis.read(buf) != -1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) bis.close();
                if (bos != null) bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveFileDirectory(File mypath) {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(mypath));
            bos = new BufferedOutputStream(new FileOutputStream(mypath.getAbsolutePath(), false));
            byte[] buf = new byte[1024];
            bis.read(buf);
            do {
                bos.write(buf);
            } while (bis.read(buf) != -1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) bis.close();
                if (bos != null) bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String saveToInternalStorage(Bitmap bitmapImage) {
        ContextWrapper cw = new ContextWrapper(getContext().getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath = new File(directory, "profile.jpg");

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

    @Override
    public void onItemClickListener(int position, Object o) {
        Intent intent = new Intent(getActivity(), SettingsActivity.class);
        startActivity(intent);
    }
}