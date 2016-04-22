package com.example.marcolemmens.csi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CSI extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csi);

        Intent intent = getIntent();
        int id = intent.getIntExtra("pos", 0);



        CriminalProvider criminalProvider = new CriminalProvider(this);

        CrimeListAdapter crimeListAdapter = new CrimeListAdapter(this, criminalProvider.GetCriminal(id).crimes);


        Criminal selectedCriminal = criminalProvider.GetCriminal(id);



        TextView tvName = (TextView) findViewById(R.id.textViewName);
        TextView tvGender = (TextView) findViewById(R.id.textViewGender);
        TextView tvAge = (TextView) findViewById(R.id.textViewAge);
        TextView tvBounty = (TextView) findViewById(R.id.textViewBounty);
        ImageView tvMugshot = (ImageView) findViewById(R.id.imageViewMugshot);


        tvName.setText(selectedCriminal.name);
        tvGender.setText(selectedCriminal.gender);
        tvAge.setText(Integer.toString(selectedCriminal.age));
        tvBounty.setText(Integer.toString(selectedCriminal.getBountyInDollars()));
        tvMugshot.setImageDrawable(selectedCriminal.mugshot);



        ListView listview = (ListView) findViewById(R.id.listViewCrimes);
        //Create an adapter that feeds the data to the listview
        listview.setAdapter(crimeListAdapter);



    }

    // Start de 2e view op wanneer er op de knop word geklikt

    public void sendMessage(View view) {

        Intent intent = getIntent();
        int id = intent.getIntExtra("pos", 0);

        Intent intent2 = new Intent(this, ReportActivity.class);
        intent.putExtra("pos", id);
        startActivity(intent2);
    }


}
