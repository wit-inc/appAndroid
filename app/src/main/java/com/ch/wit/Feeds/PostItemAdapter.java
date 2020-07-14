package com.ch.wit.Feeds;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import com.ch.wit.R;
import java.util.ArrayList;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;


public class PostItemAdapter extends RecyclerView.Adapter<PostItemAdapter.ViewHolder>{
    private final ArrayList<Integer> postData;
    public PostItemAdapter(ArrayList<Integer> postData) {
        this.postData = postData;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.post_fragment, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ViewCompat.setTransitionName(holder.postCardView, "PostExpandCardView");
        ViewCompat.setTransitionName(holder.layout, "exp");
        ViewCompat.setTransitionName(holder.postActionLayout, "PostExpandActionPanel");
        ViewCompat.setTransitionName(holder.postEndLine,"PostExpandComment");
        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(holder.getAdapterPosition(), holder);
            }
        };
        holder.commentButton.setOnClickListener(onclick);
    }

    private static ClickListener clickListener;
    void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }
    @Override
    public int getItemCount() {
        return postData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        public ImageView postView;
        TextView nameView, lastSeenView, likeCountView ,commentCountView, shareCountView;
        CardView postActionLayout,postCardView;
        Space postEndLine;
        ImageButton commentButton;
        ConstraintLayout layout;
        ViewHolder(View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.profileNameTV);
            lastSeenView = itemView.findViewById(R.id.lastSeenTV);
            likeCountView = itemView.findViewById(R.id.likeCountTV);
            commentCountView = itemView.findViewById(R.id.commentCountTV);
            commentButton = itemView.findViewById(R.id.commentIB);
            shareCountView = itemView.findViewById(R.id.shareCountTV);
            postView = itemView.findViewById(R.id.postContentIV);
            postCardView = itemView.findViewById(R.id.postContentCV);
            postActionLayout = itemView.findViewById(R.id.postActionCV);
            postEndLine = itemView.findViewById(R.id.postEndLine);
            layout = itemView.findViewById(R.id.postLayout);
        }
    }

    public interface ClickListener {
        void onItemClick(int position, ViewHolder holder);
    }

}