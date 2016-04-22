package com.example.marcolemmens.csi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

@SuppressLint("InflateParams")  // See: https://code.google.com/p/android-developer-preview/issues/detail?id=1203
public class CrimeListAdapter extends ArrayAdapter<Crime> {

	private Context context;
	private List<Crime> crimes;

	public CrimeListAdapter(Context context, List<Crime> crimes) {
		super(context, R.layout.crimelistitem, crimes);
		
		this.context = context;
		this.crimes = crimes;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		Crime requestedCrime = crimes.get(position);

		//TOOD: replace this simple view by the layout as defined in criminallistitem.xml"

		View crimeView = convertView;

	if(crimeView == null) {

		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		crimeView = inflater.inflate(R.layout.crimelistitem, null);

	}

		TextView crime1 = (TextView) crimeView.findViewById(R.id.crime1);
		TextView crime2 = (TextView) crimeView.findViewById(R.id.crime2);
		TextView crime3 = (TextView) crimeView.findViewById(R.id.crime3);

		crime1.setText(requestedCrime.name);
		crime2.setText(requestedCrime.description);
		crime3.setText(Integer.toString(requestedCrime.bountyInDollars));



		return crimeView;


	}

}
