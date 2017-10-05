package com.example.shrikant.popularmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.shrikant.popularmovies.R;

public class MainActivity extends AppCompatActivity implements MovieAdapter.ListItemClickListener{
    private RecyclerView mMoviesList;
    private MovieAdapter mAdapter;

    private static final int NUM_LIST_ITEMS = 100;
    Toast mToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMoviesList = (RecyclerView) findViewById(R.id.rv_movies);

         /*
     * A LinearLayoutManager is responsible for measuring and positioning item views within a
     * RecyclerView into a linear list. This means that it can produce either a horizontal or
     * vertical list depending on which parameter you pass in to the LinearLayoutManager
     * constructor. By default, if you don't specify an orientation, you get a vertical list.
     * In our case, we want a vertical list, so we don't need to pass in an orientation flag to
     * the LinearLayoutManager constructor.
     *
     * There are other LayoutManagers available to display your data in uniform grids,
     * staggered grids, and more! See the developer documentation for more details.
     */
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mMoviesList.setLayoutManager(layoutManager);

        /*
         * Use this setting to improve performance if you know that changes in content do not
         * change the child layout size in the RecyclerView
         */
        mMoviesList.setHasFixedSize(true);

        // TODO (13) Pass in this as the ListItemClickListener to the GreenAdapter constructor
        /*
         * The GreenAdapter is responsible for displaying each item in the list.
         */
        mAdapter = new MovieAdapter(NUM_LIST_ITEMS, this);
        mMoviesList.setAdapter(mAdapter);

    }
    @Override
    public void onListItemClick(int clickedItemIndex) {

        if(mToast != null) {
            mToast.cancel();
        }
        String toastMessage= "item# "+clickedItemIndex+" clicked";
        mToast = Toast.makeText(getApplicationContext(),toastMessage,Toast.LENGTH_SHORT);
        mToast.show();
    }


}
