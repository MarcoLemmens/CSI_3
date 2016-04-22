package com.example.marcolemmens.csi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.security.Provider;

public class CriminalsList extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criminals_list);


        CriminalProvider criminalProvider = new CriminalProvider(this);

        CriminalListAdapter criminalListAdapter = new CriminalListAdapter(this, criminalProvider.GetCriminals());



        //Get a reference to the listview
        ListView listview = (ListView) findViewById(R.id.listView1);
        //Get a reference to the list with names
        final String[] criminals = getResources().getStringArray(R.array.names);
        //Create an adapter that feeds the data to the listview
        listview.setAdapter(criminalListAdapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//Get the name from the array that is in the same position as the chosen listitem.
                //Todo start intent and pass name using putExtra
                startApp(position);
            }
        });
    }


    public void startApp(int pos){

        Intent intent = new Intent(this, CSI.class);
        intent.putExtra("pos", pos);
        startActivity(intent);

    }



}
