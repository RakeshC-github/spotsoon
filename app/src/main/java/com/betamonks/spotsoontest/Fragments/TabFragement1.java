package com.betamonks.spotsoontest.Fragments;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.betamonks.spotsoontest.Adapters.List_Adapter;
import com.betamonks.spotsoontest.R;

import java.util.ArrayList;



public class TabFragement1 extends Fragment{


    ListView listView;
    List_Adapter list_adapter;
    String name[] = {"AR.Rahman","AR.Rahman Songs","AR.Rahman Albums"};
    String time[] = {"2 HOURS AGE","6 HOURS AGE","8 HOURS AGE"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.tab1, container, false);


        listView = (ListView)view.findViewById(R.id.list);

        list_adapter = new List_Adapter(getActivity(),name,time);
        listView.setAdapter(list_adapter);






        return view;
    }
}
