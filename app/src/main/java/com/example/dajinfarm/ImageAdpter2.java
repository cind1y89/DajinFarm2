package com.example.dajinfarm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;


public class ImageAdpter2 extends BaseAdapter {
        private Context context;
        public ImageAdpter2(Context context)
        {
            this.context = context;
        }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null)
        {
            imageView = new ImageView(this.context);
            imageView.setLayoutParams(new AbsListView.LayoutParams(350,400));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        }
        else imageView = (ImageView)convertView;


        imageView.setImageResource(R.drawable.cardback2);

        return imageView;
    }
}