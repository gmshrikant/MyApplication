package com.example.shrikant.popularmovies;

import android.content.Context;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Shrikant on 10/3/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

private static final String TAG = MovieAdapter.class.getSimpleName();

final private ListItemClickListener mOnClickListener;

private int mNumberItems;

public interface ListItemClickListener
{
    void onListItemClick(int clickedItemIndex);
}
    /**
     * Constructor for MovieAdapter that accepts a number of items to display and the specification
     * for the ListItemClickListener.
     *
     * @param numberOfItems Number of items to display in list
     */
    public MovieAdapter(int numberOfItems,ListItemClickListener onClickListener) {
        mNumberItems = numberOfItems;
        mOnClickListener = onClickListener ;
    }

    /**
     *
     * This gets called when each new ViewHolder is created. This happens when the RecyclerView
     * is laid out. Enough ViewHolders will be created to fill the screen and allow for scrolling.
     *
     * @param viewGroup The ViewGroup that these ViewHolders are contained within.
     * @param viewType  If your RecyclerView has more than one type of item (which ours doesn't) you
     *                  can use this viewType integer to provide a different layout. See
     *                  {@link android.support.v7.widget.RecyclerView.Adapter#getItemViewType(int)}
     *                  for more details.
     * @return A new NumberViewHolder that holds the View for each list item
     */
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)  {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.movie_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        MovieViewHolder viewHolder = new MovieViewHolder(view);


        return viewHolder;


    }

    /**
     * OnBindViewHolder is called by the RecyclerView to display the data at the specified
     * position. In this method, we update the contents of the ViewHolder to display the correct
     * indices in the list for this particular position, using the "position" argument that is conveniently
     * passed into us.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.bind(position);
    }

    /**
     * This method simply returns the number of items to display. It is used behind the scenes
     * to help layout our Views and for animations.
     *
     * @return The number of items available
     */
    @Override
    public int getItemCount() {
        return mNumberItems;
    }

// TODO (5) Implement OnClickListener in the NumberViewHolder class
/**
 * Cache of the children views for a list item.
 */
class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView listItemMoviePoster;
    // Will display which ViewHolder is displaying this data
    TextView viewHolderMovieName;

    /**
     * Constructor for our ViewHolder. Within this constructor, we get a reference to our
     * TextViews and set an onClickListener to listen for clicks. Those will be handled in the
     * onClick method below.
     * @param itemView The View that you inflated in
     *                 {@link MovieAdapter#onCreateViewHolder(ViewGroup, int)}
     */

    public MovieViewHolder(View itemView) {
        super(itemView);

        listItemMoviePoster = (ImageView) itemView.findViewById(R.id.iv_movie_poster);
        viewHolderMovieName = (TextView) itemView.findViewById(R.id.tv_movie_name);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int mPosition = getAdapterPosition();
        mOnClickListener.onListItemClick(mPosition);
    }

    /**
     * A method we wrote for convenience. This method will take an integer as input and
     * use that integer to display the appropriate text within a list item.
     * @param listIndex Position of the item in the list
     */
    void bind(int listIndex) {
        viewHolderMovieName.setText(String.valueOf(listIndex));
    }

 }}
