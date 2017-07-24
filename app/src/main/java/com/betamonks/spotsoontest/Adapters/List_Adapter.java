package com.betamonks.spotsoontest.Adapters;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.betamonks.spotsoontest.R;

import java.util.ArrayList;

/**
 * Created by bm-admin on 7/12/16.
 */
public class List_Adapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<String> nameList;
    private ArrayList<String> phoneList;
    //private LayoutInflater inflater;
    private static LayoutInflater inflater = null;
    // public ImageLoader imageLoader;
    private String name[];
    private String time[];

    public List_Adapter(Activity a, String[] name,String[] time) {
        this.activity = a;
        this.name = name;
        this.time = time;
        this.phoneList = phoneList;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View vi = view;
        if (view == null) {
            vi = inflater.inflate(R.layout.list_adapter, null);

            TextView title = (TextView) vi.findViewById(R.id.title);
            title.setText(name[position]);

            TextView artist = (TextView) vi.findViewById(R.id.time);
            artist.setText(time[position]);

        }


        return vi;
    }
}
