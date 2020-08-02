package com.ch.wit.Adapters;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import com.ch.wit.R;
import com.ch.wit.generated.callback.OnClickListener;
import com.ch.wit.gestures.DoubleClickListener;

import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;


public class PostItemAdapter extends RecyclerView.Adapter<PostItemAdapter.ViewHolder> {
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
        ViewCompat.setTransitionName(holder.postEndLine, "PostExpandComment");
        if (dir == R.layout.feed_fragment) {
            holder.profilePhotoIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onProfileClick("profileId");
                }
            });

        }
        holder.commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickListener.onItemClick(holder.getAdapterPosition(), holder);
            }
        });

        holder.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setActivated(!v.isActivated());
            }
        });

        if (holder.moreIB != null) {
            holder.moreIB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onMoreClick(holder.getAdapterPosition(), holder);
                }
            });
        }

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
        final TextView nameView, lastSeenView, likeCountView, commentCountView, shareCountView;
        public final CardView postActionLayout,postCardView;
        public final Space postEndLine;
        final ImageButton commentButton,likeButton,moreIB;
        final ConstraintLayout layout;
        final ImageView profilePhotoIV;
        ViewHolder(View itemView) {
            super(itemView);
            moreIB = itemView.findViewById(R.id.moreIB);
            profilePhotoIV = itemView.findViewById(R.id.profilePhotoIV);
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
        void onProfileClick(String profileId);
        void onMoreClick(int adapterPosition, ViewHolder holder);
    }

}