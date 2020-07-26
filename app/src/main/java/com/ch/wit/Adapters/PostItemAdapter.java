package com.ch.wit.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import com.ch.wit.R;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;


public class PostItemAdapter extends RecyclerView.Adapter<PostItemAdapter.ViewHolder>{
    private final ArrayList<Integer> postData;
    private final int dir;
    public PostItemAdapter(ArrayList<Integer> postData, int dir ) {
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
        holder.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setActivated(!v.isActivated());
            }
        });

    }

    private static ClickListener clickListener;
    public void setOnItemClickListener(ClickListener clickListener) {
        PostItemAdapter.clickListener = clickListener;
    }
    @Override
    public int getItemCount() {
        return postData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        public final ImageView postView;
        final TextView nameView;
        final TextView lastSeenView;
        final TextView likeCountView;
        final TextView commentCountView;
        final TextView shareCountView;
        public final CardView postActionLayout;
        public final CardView postCardView;
        public final Space postEndLine;
        final ImageButton commentButton,likeButton;
        final ConstraintLayout layout;
        ViewHolder(View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.profileNameTV);
            lastSeenView = itemView.findViewById(R.id.lastSeenTV);
            likeCountView = itemView.findViewById(R.id.likeCountTV);
            commentCountView = itemView.findViewById(R.id.commentCountTV);
            commentButton = itemView.findViewById(R.id.commentIB);
            likeButton = itemView.findViewById(R.id.likeIB);
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