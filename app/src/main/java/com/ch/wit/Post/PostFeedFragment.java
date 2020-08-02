package com.ch.wit.Post;


import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.ch.wit.R;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.app.Activity.RESULT_OK;


public class PostFeedFragment extends Fragment {
    ImageView imageView;
    LinearLayout docsLL;
    View view;
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_post_feed, parent, false);
        imageView =view.findViewById(R.id.docIM);
        Button postFeedBV =view.findViewById(R.id.postFeedBV);
        postFeedBV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setActivated(!v.isActivated());

            }
        });

        ImageButton galleryIB =view.findViewById(R.id.galleryIB);
        galleryIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto , 1);
            }
        });

        ImageButton cameraIB =view.findViewById(R.id.cameraIB);
        cameraIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePicture, 0);//zero can be replaced with any action code (called requestCode)
            }
        });


        docsLL = view.findViewById(R.id.docsLL);

        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent imageReturnedIntent) {

        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        LayoutInflater inflater = getLayoutInflater();
        View myLayout = inflater.inflate(R.layout.post_docs_layout, docsLL, false);
        if(resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1:
                    Uri selectedImage = imageReturnedIntent.getData();
                    imageView.setImageURI(selectedImage);
                    ((ImageView)myLayout.findViewById(R.id.flag)).setImageDrawable(imageView.getDrawable());
                    break;
               case 0:
                    Bitmap photo = (Bitmap) imageReturnedIntent.getExtras().get("data");
                    imageView.setImageBitmap(photo);
                   ((ImageView)myLayout.findViewById(R.id.flag)).setImageDrawable(imageView.getDrawable());
                   break;
            }
            docsLL.addView(myLayout);

        }
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO) {

        } else if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES) {


        }
    }
}
