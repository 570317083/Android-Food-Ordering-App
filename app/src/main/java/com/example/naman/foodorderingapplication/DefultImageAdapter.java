package com.example.naman.foodorderingapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Naman on 11-11-2018.
 */

public class DefultImageAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.ccd, R.drawable.mitti,
            R.drawable.mochacafe, R.drawable.o2cafe,
            R.drawable.yolocafe,R.drawable.buddyscafe,
            R.drawable.chikaapi,R.drawable.beanscafe



    };

    // Constructor
    public DefultImageAdapter(Context c)
    {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setImageResource(mThumbIds[position]);

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(528, 528));
        return imageView;


    }}
