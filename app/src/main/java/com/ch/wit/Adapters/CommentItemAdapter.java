package com.ch.wit.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ch.wit.R;
import java.util.ArrayList;

public class CommentItemAdapter extends RecyclerView.Adapter<CommentItemAdapter.ViewHolder>{
    private final ArrayList<Integer> postData;
    private final int dir;
    public CommentItemAdapter(ArrayList<Integer> postData, int dir ) {
        this.dir = dir;
        this.postData = postData;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(dir, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {


    }


    @Override
    public int getItemCount() {
        return postData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        final TextView nameView,lastSeenView,commentTV;
        ViewHolder(View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.profileNameTV);
            commentTV = itemView.findViewById(R.id.commentTV);
            lastSeenView = itemView.findViewById(R.id.lastSeenTV);
        }
    }


}