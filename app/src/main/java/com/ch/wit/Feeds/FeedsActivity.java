package com.ch.wit.Feeds;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.ch.wit.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.SearchView;
import java.util.ArrayList;

public class FeedsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.message:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.home:
                    return true;
                case R.id.profile:
                    return true;
                case R.id.new_post:
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        ArrayList<Integer> postData = new ArrayList<>();
        postData.add(1);
        postData.add(2);
        postData.add(1);
        postData.add(2);
        RecyclerView recyclerView = findViewById(R.id.PostRecyclerView);
        PostItemAdapter adapter = new PostItemAdapter(postData);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        final Button navDrawerIB = findViewById(R.id.navDrawerIB);
        adapter.setOnItemClickListener(new PostItemAdapter.ClickListener() {
            @Override
            public void onItemClick(int pos, PostItemAdapter.ViewHolder holder) {
                navDrawerIB.setAlpha(0);
                Intent intent = new Intent(FeedsActivity.this, DetailedPostActivity.class);
                intent.putExtra("Shared", ViewCompat.getTransitionName(holder.postView));
                Pair<View, String> p4 = Pair.create((View)holder.postCardView, ViewCompat.getTransitionName(holder.postCardView));
                Pair<View, String> p2 = Pair.create((View)holder.postActionLayout, ViewCompat.getTransitionName(holder.postActionLayout));
                Pair<View, String> p3 = Pair.create((View)holder.postEndLine, ViewCompat.getTransitionName(holder.postEndLine));
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(FeedsActivity.this,p2,p3,p4);
                startActivity(intent, options.toBundle());
//                startActivity(intent);
            }
//
        });
        final DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navDrawerIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);

//                Resources resources = getResources();
//                float width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 240, resources.getDisplayMetrics());
//                ViewGroup.LayoutParams params = drawer.getLayoutParams();
//                params.width = (int) (width);
//                drawer.setLayoutParams(params);

            }
        });
        SearchView searchView = findViewById(R.id.searchBarSV);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int width = displayMetrics.widthPixels;
                ValueAnimator valueAnimator = ValueAnimator.ofInt(DrawerLayout.LayoutParams.WRAP_CONTENT, DrawerLayout.LayoutParams.MATCH_PARENT);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        navigationView.getLayoutParams().width = (int) animation.getAnimatedValue();
                        navigationView.requestLayout();
                    }
                });
                valueAnimator.setInterpolator(new DecelerateInterpolator());
                valueAnimator.setDuration(100);
                valueAnimator.start();
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
    }


    @Override
    protected void onStart()
    {
        super.onStart();
        final Button navDrawerIB = findViewById(R.id.navDrawerIB);
        navDrawerIB.setAlpha(1);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {



        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.END);
        return true;
    }

}
