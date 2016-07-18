package com.asi.addtorecyclerviewatruntime;

/**
 * Created by ASI on 18/07/2016.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<FeedItem> feedItemList;
    private Context mContext;
    public MyAdapter(Context context,ArrayList<FeedItem>feedItemList) {
        this.feedItemList=feedItemList;
        this.mContext=context;
    }
    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_view_layout, null);
        // create ViewHolder
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData
        viewHolder.mMailTextView.setText(feedItemList.get(position).getMAIL());
        viewHolder.mNameTextView.setText(feedItemList.get(position).getNAME());
    }
    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mNameTextView,mMailTextView;
        public ImageView imgViewIcon;
        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            mNameTextView = (TextView) itemLayoutView.findViewById(R.id.NameTextView);
            mMailTextView=(TextView)itemLayoutView.findViewById(R.id.MailTextView);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.DeleteIcon);
        }
    }
    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return feedItemList.size();
    }
}