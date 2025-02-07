package com.ruksana.sscboardbookandguide.sciencegroup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.FirebaseApp;
import com.ruksana.sscboardbookandguide.R;
import com.ruksana.sscboardbookandguide.sc.ScBoardBookActivity;
import com.ruksana.sscboardbookandguide.sc.ScGuideBookActivity;
import com.ruksana.sscboardbookandguide.sc.ScHandNoteActivity;

public class ScienceActivity extends AppCompatActivity {

    private boolean isExpanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);

        FirebaseApp.initializeApp(this);

        actionBar();

        physicsExpandableButtonSection();
        physicsButtonSection();
    }

    private void physicsExpandableButtonSection() {
        LinearLayout physicsToggleButton = findViewById(R.id.physics_toggle_button);
        LinearLayout physicsCollapsibleView = findViewById(R.id.physics_collapsible_view);
        ImageView physicsToggleIcon = findViewById(R.id.physics_toggle_icon);


        physicsToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    physicsCollapsibleView.setVisibility(View.GONE);
                    physicsToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    physicsCollapsibleView.setVisibility(View.VISIBLE);
                    physicsToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void physicsButtonSection() {
        Button physicsBoardBookButton = findViewById(R.id.physics_board_book_id);
        physicsBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScienceActivity.this, physicsBoardBookActivity.class));
            }
        });

        Button physicsGuideBookButton = findViewById(R.id.physics_guide_book_id);
        physicsGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScienceActivity.this, physicsGuideBookActivity.class));
            }
        });

        Button physicsHandNoteButton = findViewById(R.id.physics_hand_note_id);
        physicsHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScienceActivity.this, physicsHandNoteActivity.class));
            }
        });
    }

    //actionbar
    private void actionBar() {
        //int action bar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("বিজ্ঞান বিভাগ");


        //add back button
        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    //Back Override method
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();//go previous activity, when back button of  actionbar clicked
        return super.onSupportNavigateUp();
    }
}