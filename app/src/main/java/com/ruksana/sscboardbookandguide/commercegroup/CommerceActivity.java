package com.ruksana.sscboardbookandguide.commercegroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.ruksana.sscboardbookandguide.R;
import com.ruksana.sscboardbookandguide.sc.ScBoardBookActivity;
import com.ruksana.sscboardbookandguide.sc.ScGuideBookActivity;
import com.ruksana.sscboardbookandguide.sc.ScHandNoteActivity;

public class CommerceActivity extends AppCompatActivity {

    private boolean isExpanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);

        FirebaseApp.initializeApp(this);

        actionBar();

        scExpandableButtonSection();
        scButtonSection();
    }

    private void scExpandableButtonSection() {
        LinearLayout scToggleButton = findViewById(R.id.sc_toggle_button);
        LinearLayout scCollapsibleView = findViewById(R.id.sc_collapsible_view);
        ImageView scToggleIcon = findViewById(R.id.sc_toggle_icon);


        scToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    scCollapsibleView.setVisibility(View.GONE);
                    scToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    scCollapsibleView.setVisibility(View.VISIBLE);
                    scToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void scButtonSection() {
        Button scBoardBookButton = findViewById(R.id.sc_board_book_id);
        scBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommerceActivity.this, ScBoardBookActivity.class));
            }
        });

        Button scGuideBookButton = findViewById(R.id.sc_guide_book_id);
        scGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommerceActivity.this, ScGuideBookActivity.class));
            }
        });

        Button scHandNoteButton = findViewById(R.id.sc_hand_note_id);
        scHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommerceActivity.this, ScHandNoteActivity.class));
            }
        });
    }

    //actionbar
    private void actionBar() {
        //int action bar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("ব্যবসায় শিক্ষা বিভাগ");


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