package com.example.usuario.restaurantmen.ItemMenu;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class LoaderImg extends AsyncTask<String, String, Bitmap> {

    private OnLoadCompleImg event;
    private ImageView containerimg;
    private int position;
        public void setOnLoadCompleteImg (ImageView container,int position ,OnLoadCompleImg event) {
        this.event = event;
        this.position =position;
        this.containerimg=container;
    }
    @Override
    protected Bitmap doInBackground(String... strings) {
        String url =strings[0];
        try {
            URL imgurl = new URL(url);
            InputStream file = imgurl.openConnection().getInputStream();
            Bitmap img = BitmapFactory.decodeStream(file);
            return img;
        } catch (MalformedURLException exp) {
            Log.i("ERROR",exp.getMessage());
        } catch (IOException exp) {
            Log.i("ERROR",exp.getMessage());
        }
        return null;
    }

    protected void onPostExecute(Bitmap img) {


        this.event.OnLoadCompleteImgResult(this.containerimg,this.position,img);
    }
}
