package com.ophion.cinesapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smarro on 5/23/16.
 */

public class MainActivity extends AppCompatActivity {
    public List<Movie> movieList = new ArrayList<>();
    String[] schedules = new String[5];
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Movie movie = movieList.get(position);
                // Launchear los horarios para dicha movie
                Intent intent = new Intent(MainActivity.this, Main2HsActivity.class);
                intent.putExtra("Movie", movie);
                Toast.makeText(getApplicationContext(), "Seleccionaste " + movie.getTitle() + "!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        for (int i = 0; i < 5; i++) {
            schedules[i] = "16.30, 18.50, 22.15;11.50, 13.00; 16.30, 22.15; 11.50;16.30, 18.50, 22.15;";
        }
        prepareMovieData(schedules);
    }

    private void prepareMovieData(String[] schedules1) {

        // ACLARACION: Aqui estoy hardcodeando las peliculas con horarios fijos.
        // Esto es para probar el funcionamiento de la app y mostrar bien como es la idea, no es
        // parte de la app final. Abajo dejo comentado la idea principal de como seria la carga de
        // peliculas :

        // for i in movies:
        //  Movie movie = new Movie(movie[i].title, movie[i].genre, movie[i].schedule);
        //  movieList.add(movie);

        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", schedules1);
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family",schedules1);
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", schedules1);
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", schedules1);
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy",schedules1);
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", schedules1);
        movieList.add(movie);


        mAdapter.notifyDataSetChanged();
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private MainActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final MainActivity.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}