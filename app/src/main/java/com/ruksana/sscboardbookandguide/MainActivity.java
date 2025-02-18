package com.ruksana.sscboardbookandguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

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

        // Set up Navigation Drawer Toggle
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_menu_24); // Hamburger icon
        }

        // Handle Navigation Item Clicks
        navigationView.setNavigationItemSelectedListener(item -> {
            // Handle navigation item clicks here
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        // Initialize Sections and Set Up Toggle Buttons
        setupSection(R.id.bangla_shaitto_toggle_button, R.id.collapsible_view, R.id.toggle_icon);
        setupSection(R.id.sohopath_toggle_button, R.id.sohopath_collapsible_view, R.id.sohopath_toggle_icon);
        setupSection(R.id.bakoron_toggle_button, R.id.bakoron_collapsible_view, R.id.bakoron_toggle_icon);
//        setupSection(R.id.english_toggle_button, R.id.english_collapsible_view, R.id.english_toggle_icon);
//        setupSection(R.id.grammar_toggle_button, R.id.grammar_collapsible_view, R.id.grammar_toggle_icon);
//        setupSection(R.id.math_toggle_button, R.id.math_collapsible_view, R.id.math_toggle_icon);
//        setupSection(R.id.ict_toggle_button, R.id.ict_collapsible_view, R.id.ict_toggle_icon);
//        setupSection(R.id.islam_toggle_button, R.id.islam_collapsible_view, R.id.islam_toggle_icon);
//        setupSection(R.id.hindu_toggle_button, R.id.hindu_collapsible_view, R.id.hindu_toggle_icon);

        // Handle Button Clicks
        setupButtonClicks();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
        setupButtonClick(R.id.bangla_shaitto_board_book_id, "বাংলা সাহিত্য বোর্ড - বই","bsbbook");
        setupButtonClick(R.id.bangla_shaitto_guide_book_id, "bsbbook","bsbbook");
        setupButtonClick(R.id.bangla_shaitto_hand_note_id, "bnsbbook","bsbbook");

        // Sohopath Buttons
        setupButtonClick(R.id.sohopath_board_book_id, "Sohopath Board Book","bsbbook");
        setupButtonClick(R.id.sohopath_guide_book_id, "Sohopath Guide Book","bsbbook");
        setupButtonClick(R.id.sohopath_hand_note_id, "Sohopath Hand Note","bsbbook");

        // Bakoron Buttons
        setupButtonClick(R.id.bakoron_board_book_id, "Bakoron Board Book","bsbbook");
        setupButtonClick(R.id.bakoron_guide_book_id, "Bakoron Guide Book","bsbbook");
        setupButtonClick(R.id.bakoron_hand_note_id, "Bakoron Hand Note","bsbbook");
//
//        // English Buttons
//        setupButtonClick(R.id.english_board_book_id, "English Board Book");
//        setupButtonClick(R.id.english_guide_book_id, "English Guide Book");
//        setupButtonClick(R.id.english_hand_note_id, "English Hand Note");
//
//        // Grammar Buttons
//        setupButtonClick(R.id.grammar_board_book_id, "Grammar Board Book");
//        setupButtonClick(R.id.grammar_guide_book_id, "Grammar Guide Book");
//        setupButtonClick(R.id.grammar_hand_note_id, "Grammar Hand Note");
//
//        // Math Buttons
//        setupButtonClick(R.id.math_board_book_id, "Math Board Book");
//        setupButtonClick(R.id.math_guide_book_id, "Math Guide Book");
//        setupButtonClick(R.id.math_hand_note_id, "Math Hand Note");
//
//        // ICT Buttons
//        setupButtonClick(R.id.ict_board_book_id, "ICT Board Book");
//        setupButtonClick(R.id.ict_guide_book_id, "ICT Guide Book");
//        setupButtonClick(R.id.ict_hand_note_id, "ICT Hand Note");
//
//        // Islam Buttons
//        setupButtonClick(R.id.islam_board_book_id, "Islam Board Book");
//        setupButtonClick(R.id.islam_guide_book_id, "Islam Guide Book");
//        setupButtonClick(R.id.islam_hand_note_id, "Islam Hand Note");
//
//        // Hindu Buttons
//        setupButtonClick(R.id.hindu_board_book_id, "Hindu Board Book");
//        setupButtonClick(R.id.hindu_guide_book_id, "Hindu Guide Book");
//        setupButtonClick(R.id.hindu_hand_note_id, "Hindu Hand Note");
    }

    // Helper Method to Handle Button Clicks
    private void setupButtonClick(int buttonId, String buttonName, String category) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            // Handle button click (e.g., open a new activity or show a toast)
            // Example: Open a new activity based on the button clicked
             Intent intent = new Intent(MainActivity.this, AllSubjectActivity.class);
             intent.putExtra("BUTTON_NAME", buttonName);
             intent.putExtra("CATEGORY",category);
             startActivity(intent);
        });
    }
}