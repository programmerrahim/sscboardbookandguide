package com.ruksana.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ruksana.adapter.VerticalAdapter;
import com.ruksana.model.VerticalItem;
import com.ruksana.sscboardbookandguide.R;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private RecyclerView verticalRecyclerView;
    private VerticalAdapter verticalAdapter;
    private List<VerticalItem> verticalItemList;
    private DrawerLayout drawerLayout;
//    private Button joinBtn;
private FloatingActionButton joinBtn;
//    private ProgressBar loadingIndicator; // Added loading indicator

    private String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize Drawer Layout and NavigationView
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Initialize Loading Indicator
//        loadingIndicator = findViewById(R.id.loading_indicator);

        // Set up Navigation Drawer Toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Handle Navigation Item Clicks
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_privacy_policy_id) {
                CustomTabsIntent intent = new CustomTabsIntent.Builder().build();
                String url = "https://banglaserialandnatok.blogspot.com/p/privacy-policy.html";
                intent.launchUrl(MainActivity.this, Uri.parse(url));
            } else if (id == R.id.nav_terms_and_conditions_id) {
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        // Get a reference to the database for course link
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("course/courseLink");


        // Initialize Sections and Set Up Toggle Buttons
        setupSection(R.id.current_affairs_toggle_button, R.id.current_affairs_collapsible_view, R.id.current_affairs_toggle_icon);
        setupSection(R.id.bangla_toggle_button, R.id.bangla_collapsible_view, R.id.bangla_toggle_icon);
        setupSection(R.id.english_toggle_button, R.id.english_collapsible_view, R.id.english_toggle_icon);
        setupSection(R.id.math_toggle_button, R.id.math_collapsible_view, R.id.math_toggle_icon);
        setupSection(R.id.general_knowledge_toggle_button, R.id.general_knowledge_collapsible_view, R.id.general_knowledge_toggle_icon);

        // Handle Button Clicks
        setupButtonClicks();



        // Retrieve data once
        databaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Map<String, Object> userData = (Map<String, Object>) dataSnapshot.getValue();
                    url = (String) userData.get("url");
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("FirebaseError", "Database error: " + databaseError.getMessage());
               
            }
        });

        // Join button
        joinBtn = findViewById(R.id.fab_bottom_right);
        joinBtn.setOnClickListener(view -> {
            CustomTabsIntent intent = new CustomTabsIntent.Builder().build();
            intent.launchUrl(MainActivity.this, Uri.parse(url));
        });

    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_exit, null);
            Button btnCancel = dialogView.findViewById(R.id.btnCancel);
            Button btnExit = dialogView.findViewById(R.id.btnExit);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(dialogView);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

            btnCancel.setOnClickListener(v -> alertDialog.dismiss());
            btnExit.setOnClickListener(v -> super.onBackPressed());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_notification) {
            startActivity(new Intent(MainActivity.this, NoticeActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // Helper Method to Set Up Section Toggle Buttons
    private void setupSection(int toggleButtonId, int collapsibleViewId, int toggleIconId) {
        LinearLayout toggleButton = findViewById(toggleButtonId);
        LinearLayout collapsibleView = findViewById(collapsibleViewId);
        ImageView toggleIcon = findViewById(toggleIconId);

        toggleButton.setOnClickListener(v -> {
            if (collapsibleView.getVisibility() == View.GONE) {
                collapsibleView.setVisibility(View.VISIBLE);
                toggleIcon.setImageResource(R.drawable.down_arrow); // Change icon to down arrow
            } else {
                collapsibleView.setVisibility(View.GONE);
                toggleIcon.setImageResource(R.drawable.right_arrow); // Change icon to right arrow
            }
        });
    }

    // Helper Method to Set Up Button Clicks
    private void setupButtonClicks() {
        // Bangla Sahitto Buttons
        setupButtonClick(R.id.current_affairs_id, "কারেন্ট অ্যাফেয়ার্স - অনুশীলন","current_affairs_practice");
        setupButtonClick(R.id.bangla_id, "বাংলা - অনুশীলন","bangla_practice");
        setupButtonClick(R.id.english_id, "English - Practice","english_practice");
        setupButtonClick(R.id.math_id, "গণিত - অনুশীলন","math_practice");
        setupButtonClick(R.id.general_knowledge_id, "সাধারণ জ্ঞান - অনুশীলন","general_knowledge_practice");


        setupButtonClickForPdf(R.id.current_affairs_pdf_id, "কারেন্ট অ্যাফেয়ার্স - পিডিএফ","current_affairs_pdf");
        setupButtonClickForPdf(R.id.bangla_pdf_id, "বাংলা - পিডিএফ","bangla_pdf");
        setupButtonClickForPdf(R.id.english_pdf_id, "English - Pdf","english_pdf");
        setupButtonClickForPdf(R.id.math_pdf_id, "গণিত - পিডিএফ","math_pdf");
        setupButtonClickForPdf(R.id.general_knowledge_pdf_id, "সাধারণ জ্ঞান - পিডিএফ","general_knowledge_pdf");


        setupButtonClickForVideo(R.id.current_affairs_video_id, "কারেন্ট অ্যাফেয়ার্স - ভিডিও","current_affairs_video");
        setupButtonClickForVideo(R.id.bangla_video_id, "বাংলা - ভিডিও","bangla_video");
        setupButtonClickForVideo(R.id.english_video_id, "English - Video","english_video");
        setupButtonClickForVideo(R.id.math_video_id, "গণিত - ভিডিও","math_video");
        setupButtonClickForVideo(R.id.general_Knowledge_video_id, "সাধারণ জ্ঞান - ভিডিও","general_knowledge_video");

    }

    private void setupButtonClick(int buttonId, String buttonName, String category) {
        LinearLayout button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            // Handle button click (e.g., open a new activity or show a toast)
            // Example: Open a new activity based on the button clicked
            Intent intent = new Intent(MainActivity.this, PracticeActivity.class);
            intent.putExtra("BUTTON_NAME", buttonName);
            intent.putExtra("CATEGORY",category);
            startActivity(intent);
        });
    }
    private void setupButtonClickForPdf(int buttonId, String buttonName, String category) {
        LinearLayout button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            // Handle button click (e.g., open a new activity or show a toast)
            // Example: Open a new activity based on the button clicked
            Intent intent = new Intent(MainActivity.this, PdfActivity.class);
            intent.putExtra("BUTTON_NAME", buttonName);
            intent.putExtra("CATEGORY",category);
            startActivity(intent);
        });
    }

    private void setupButtonClickForVideo(int buttonId, String buttonName, String category) {
        LinearLayout button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            // Handle button click (e.g., open a new activity or show a toast)
            // Example: Open a new activity based on the button clicked
            Intent intent = new Intent(MainActivity.this, VideoActivity.class);
            intent.putExtra("BUTTON_NAME", buttonName);
            intent.putExtra("CATEGORY",category);
            startActivity(intent);
        });
    }

}