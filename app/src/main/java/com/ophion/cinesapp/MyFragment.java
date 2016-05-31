package com.ophion.cinesapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by smarro on 31/05/16.
 */
public class MyFragment extends Fragment{


    public MyFragment() {
    }
    Button back;
    TextView castellano;
    TextView subtitulada;
    TextView castellano3d;
    TextView subtitulada3d;
    TextView movie_title;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.my_fragment, container, false);
        subtitulada = (TextView) rootView.findViewById(R.id.subtitulada);
        castellano3d = (TextView) rootView.findViewById(R.id.casteallano3d);
        subtitulada3d = (TextView) rootView.findViewById(R.id.subtitulada3d);
        castellano = (TextView) rootView.findViewById(R.id.castellano);
        movie_title = (TextView) rootView.findViewById(R.id.movie_title);
        //back = (Button) rootView.findViewById(R.id.Back);


        movie_title.setText("Hi");
        castellano.setText("Hi");
        subtitulada.setText("Hi");
        castellano3d.setText("Hi");
        subtitulada3d.setText("Hi");


        return rootView;
    }



    public static MyFragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }
}
