package com.example.woekun.myapplication;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SongAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private int mItemHeight = 0;
    private int mNumColumns = 0;
    private RelativeLayout.LayoutParams mImageViewLayoutParams;
    private Activity activity;

    private static final String[] CONTENT = new String[] { "Akon", "Justin Bieber", "AlRight", "Big Sean",
            "Britney Spears", "Hilary", "Micheal Buble", "Akon", "Justin Bieber", "AlRight", "Big Sean",
            "Britney Spears", "Hilary", "Micheal Buble", "Britney Spears", "Hilary", "Micheal Buble", "Akon",
            "Justin Bieber", "AlRight", "Big Sean", "Britney Spears", "Hilary", "Micheal Buble", "Akon",
            "Justin Bieber", "AlRight", "Big Sean", "Britney Spears", "Hilary", "Micheal Buble", "Akon",
            "Justin Bieber", "AlRight", "Big Sean", "Britney Spears", "Hilary", "Micheal Buble", "Britney Spears",
            "Hilary", "Micheal Buble", "Akon", "Justin Bieber", "AlRight", "Big Sean", "Britney Spears", "Hilary",
            "Micheal Buble" };
    private static final int[] ICONS = new int[] { R.drawable.cover_akon, R.drawable.cover_justin,
            R.drawable.cover_alright, R.drawable.cover_big_sean, R.drawable.cover_britney, R.drawable.cover_hilary,
            R.drawable.cover_mb, R.drawable.cover_akon, R.drawable.cover_justin, R.drawable.cover_alright,
            R.drawable.cover_big_sean, R.drawable.cover_britney, R.drawable.cover_hilary, R.drawable.cover_mb,
            R.drawable.cover_britney, R.drawable.cover_hilary, R.drawable.cover_mb, R.drawable.cover_akon,
            R.drawable.cover_justin, R.drawable.cover_alright, R.drawable.cover_big_sean, R.drawable.cover_britney,
            R.drawable.cover_hilary, R.drawable.cover_mb, R.drawable.cover_akon, R.drawable.cover_justin,
            R.drawable.cover_alright, R.drawable.cover_big_sean, R.drawable.cover_britney, R.drawable.cover_hilary,
            R.drawable.cover_mb, R.drawable.cover_akon, R.drawable.cover_justin, R.drawable.cover_alright,
            R.drawable.cover_big_sean, R.drawable.cover_britney, R.drawable.cover_hilary, R.drawable.cover_mb,
            R.drawable.cover_britney, R.drawable.cover_hilary, R.drawable.cover_mb, R.drawable.cover_akon,
            R.drawable.cover_justin, R.drawable.cover_alright, R.drawable.cover_big_sean, R.drawable.cover_britney,
            R.drawable.cover_hilary, R.drawable.cover_mb };

    public SongAdapter(Activity activity) {
        this.activity = activity;
        mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mImageViewLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
    }

    public int getCount() {
        return CONTENT.length;
    }

    // set numcols
    public void setNumColumns(int numColumns) {
        mNumColumns = numColumns;
    }

    public int getNumColumns() {
        return mNumColumns;
    }

    // set photo item height
    public void setItemHeight(int height) {
        if (height == mItemHeight) {
            return;
        }
        mItemHeight = height;
        mImageViewLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mItemHeight);
        notifyDataSetChanged();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {

        if (view == null)
            view = mInflater.inflate(R.layout.song_thumbnail, null);



        final ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transitionIntent = new Intent(activity, Main2Activity.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                      activity, viewHolder.cover, "cover");
                activity.startActivity(transitionIntent, options.toBundle());
            }
        });

        viewHolder.cover.setLayoutParams(mImageViewLayoutParams);

        // Check the height matches our calculated column width
        if (viewHolder.cover.getLayoutParams().height != mItemHeight) {
            viewHolder.cover.setLayoutParams(mImageViewLayoutParams);
        }

        viewHolder.cover.setImageResource(ICONS[position % ICONS.length]);
        viewHolder.title.setText(CONTENT[position % CONTENT.length]);

        return view;
    }

    class ViewHolder{
        ImageView cover;
        TextView title, subTitle;

        public ViewHolder(View view){
            this.cover = (ImageView) view.findViewById(R.id.cover);
            this.title = (TextView) view.findViewById(R.id.title);
            this.subTitle = (TextView) view.findViewById(R.id.sub_title);
        }
    }
}
