package com.nyfz.httpdemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nyfz.httpdemo.R;

import java.util.List;

/**
 * Created by zhangliang on 2017-9-4.
 */

public class ServiceitemAdapter extends ArrayAdapter <Serviceitem>{
    private List<Serviceitem> list;
    private Context context;
    private int resourceId;
    private LayoutInflater inflater;
    /**
     * 构造方法
     * @param context
     * @param resourceId ListView的layout的id
     * @param list 填充数据
     */
    public ServiceitemAdapter(Context context, int resourceId, List<Serviceitem> list){
        super(context,resourceId,list);

        this.resourceId=resourceId;
        this.list=list;
    }
    @Override
    public View getView(int position, final View convertView, ViewGroup parent){
        Serviceitem fruit=getItem(position);
        final View view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
           final ImageView  mPhoto = (ImageView) view.findViewById(R.id.imagePhoto);
            TextView textName = (TextView) view.findViewById(R.id.textName);
          TextView textPrice= (TextView) view.findViewById(R.id.textPrice);
            textName.setText(fruit.getName());
          textPrice.setText(fruit.getPrice());
          DownImage downImage = new DownImage(fruit.getPhoto().toString());
          downImage.loadImage(new DownImage.ImageCallBack() {
           @Override
           public void getDrawable(Drawable drawable) {
              mPhoto.setImageDrawable(drawable);
           }
       });

        // viewHolder.mPhoto.setImageBitmap(fruit.getImage());	//设置Bitmap
        return view;
    }


}
