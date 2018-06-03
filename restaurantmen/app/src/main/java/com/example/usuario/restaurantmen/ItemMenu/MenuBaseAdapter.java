package com.example.usuario.restaurantmen.ItemMenu;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.usuario.restaurantmen.R;

import java.util.ArrayList;

public class MenuBaseAdapter extends BaseAdapter implements OnLoadCompleImg{

    private ArrayList<ItemMenuStructure> LIST;
    private ArrayList<TextView> counter;
    private Context context;
    public MenuBaseAdapter(Context contex, ArrayList<ItemMenuStructure> list) {
        this.context = contex;
        this.LIST = list;
        counter = new ArrayList<TextView>();
    }
    public TextView getCounter(int position){
        return this.counter.get(position);
    }
    @Override
    public int getCount() {

        return this.LIST.size();
    }

    @Override
    public Object getItem(int position)
    {
        return this.LIST.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflate = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflate.inflate(R.layout.itemfood, null);
        }
        TextView txt1 = (TextView)convertView.findViewById(R.id.texto1);
        TextView txt2 = (TextView)convertView.findViewById(R.id.texto2);

        txt1.setText(this.LIST.get(position).getFoodname());
        txt2.setText(this.LIST.get(position).getQuantity());
        ImageView img = (ImageView)convertView.findViewById(R.id.poster);
        counter.add(txt2);
        if(this.LIST.get(position).getImg()== null)
        {
            LoaderImg loader =new LoaderImg();
            loader.setOnLoadCompleteImg(img,position,this);
            loader.execute(this.LIST.get(position).getUrlimg());
        }
        else {

            img.setImageBitmap(this.LIST.get(position).getImg());
        }
        //Falta la programacion del hilo para la carga de la imagen
        //LoaderImg hilo = new LoaderImg();
        //hilo.setLoadImage(img, this);
        //hilo.execute(this.LIST.get(position).getPoster());
        return convertView;
    }
    @Override
    public void OnLoadCompleteImgResult(ImageView img, int position, Bitmap imgsourceimg) {
        this.LIST.get(position).setImg(imgsourceimg);
        img.setImageBitmap(imgsourceimg);

    }
}