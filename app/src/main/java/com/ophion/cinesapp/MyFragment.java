package com.ophion.cinesapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by smarro on 31/05/16.
 */
public class MyFragment extends Fragment{

    Movie movie;
    int position;

    public MyFragment() {
    }
    //Button back;
    TextView castellano;
    TextView subtitulada;
    TextView castellano3d;
    TextView subtitulada3d;
    TextView movie_title;
    TextView genre;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.my_fragment, container, false);
        subtitulada = (TextView) rootView.findViewById(R.id.subtitulada1);
        castellano3d = (TextView) rootView.findViewById(R.id.casteallano3d1);
        subtitulada3d = (TextView) rootView.findViewById(R.id.subtitulada3d1);
        castellano = (TextView) rootView.findViewById(R.id.castellano1);
        movie_title = (TextView) rootView.findViewById(R.id.movie_title);

        String [] idiomas;

        idiomas = parseIdiomas(movie, position);

        movie_title.setText(movie.getTitle());

        castellano.setText("Castellano: " + idiomas[0]);
        subtitulada.setText("Subtitulada: "+ idiomas[1]);
        castellano3d.setText("Castellano 3D: " + idiomas[2]);
        subtitulada3d.setText("Subtitulada 3D" + idiomas[3]);


        return rootView;
    }



    public static MyFragment newInstance(Movie movieObj, int position) {
        MyFragment fragment = new MyFragment();
        fragment.setSomeObject(movieObj);
        fragment.setCine(position);
        return fragment;
    }

    public void setSomeObject(Movie movieObj) {
        movie = movieObj;
    }
    public void setCine(int positionObj) {
        position = positionObj;
    }

    public String[] parseIdiomas(Movie movie, int position){
        String delims = "[;]+";
        String horarios;
        horarios = movie.getSchedule(position);
        String[] tokens = horarios.split(delims);
        return tokens;
    }
}

