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
import com.ruksana.sscboardbookandguide.sciencegroup.biology.BiologyBoardBookActivity;
import com.ruksana.sscboardbookandguide.sciencegroup.biology.BiologyGuideBookActivity;
import com.ruksana.sscboardbookandguide.sciencegroup.biology.BiologyHandNoteActivity;
import com.ruksana.sscboardbookandguide.sciencegroup.chemistry.ChemistryBoardBookActivity;
import com.ruksana.sscboardbookandguide.sciencegroup.chemistry.ChemistryGuideBookActivity;
import com.ruksana.sscboardbookandguide.sciencegroup.chemistry.ChemistryHandNoteActivity;
import com.ruksana.sscboardbookandguide.sciencegroup.hmath.HigherMathBoardBookActivity;
import com.ruksana.sscboardbookandguide.sciencegroup.hmath.HigherMathGuideBookActivity;
import com.ruksana.sscboardbookandguide.sciencegroup.hmath.HigherMathHandNoteActivity;
import com.ruksana.sscboardbookandguide.sciencegroup.physics.PhysicsBoardBookActivity;
import com.ruksana.sscboardbookandguide.sciencegroup.physics.PhysicsGuideBookActivity;
import com.ruksana.sscboardbookandguide.sciencegroup.physics.PhysicsHandNoteActivity;

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

        chemistryExpandableButtonSection();
        chemistryButtonSection();

        biologyExpandableButtonSection();
        biologyButtonSection();

        hmathExpandableButtonSection();
        hmathButtonSection();
    }

    //actionbar
    private void actionBar() {
        //int action bar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle(R.string.science_div);


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
                startActivity(new Intent(ScienceActivity.this, PhysicsBoardBookActivity.class));
            }
        });

        Button physicsGuideBookButton = findViewById(R.id.physics_guide_book_id);
        physicsGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScienceActivity.this, PhysicsGuideBookActivity.class));
            }
        });

        Button physicsHandNoteButton = findViewById(R.id.physics_hand_note_id);
        physicsHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScienceActivity.this, PhysicsHandNoteActivity.class));
            }
        });
    }

    private void chemistryExpandableButtonSection() {
        LinearLayout chemistryToggleButton = findViewById(R.id.chemistry_toggle_button);
        LinearLayout chemistryCollapsibleView = findViewById(R.id.chemistry_collapsible_view);
        ImageView chemistryToggleIcon = findViewById(R.id.chemistry_toggle_icon);


        chemistryToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    chemistryCollapsibleView.setVisibility(View.GONE);
                    chemistryToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    chemistryCollapsibleView.setVisibility(View.VISIBLE);
                    chemistryToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void chemistryButtonSection() {
        Button chemistryBoardBookButton = findViewById(R.id.chemistry_board_book_id);
        chemistryBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScienceActivity.this, ChemistryBoardBookActivity.class));
            }
        });

        Button chemistryGuideBookButton = findViewById(R.id.chemistry_guide_book_id);
        chemistryGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScienceActivity.this, ChemistryGuideBookActivity.class));
            }
        });

        Button chemistryHandNoteButton = findViewById(R.id.chemistry_hand_note_id);
        chemistryHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScienceActivity.this, ChemistryHandNoteActivity.class));
            }
        });
    }

    private void biologyExpandableButtonSection() {
        LinearLayout biologyToggleButton = findViewById(R.id.biology_toggle_button);
        LinearLayout biologyCollapsibleView = findViewById(R.id.biology_collapsible_view);
        ImageView biologyToggleIcon = findViewById(R.id.biology_toggle_icon);


        biologyToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    biologyCollapsibleView.setVisibility(View.GONE);
                    biologyToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    biologyCollapsibleView.setVisibility(View.VISIBLE);
                    biologyToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void biologyButtonSection() {
        Button biologyBoardBookButton = findViewById(R.id.biology_board_book_id);
        biologyBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScienceActivity.this, BiologyBoardBookActivity.class));
            }
        });

        Button biologyGuideBookButton = findViewById(R.id.biology_guide_book_id);
        biologyGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScienceActivity.this, BiologyGuideBookActivity.class));
            }
        });

        Button biologyHandNoteButton = findViewById(R.id.biology_hand_note_id);
        biologyHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScienceActivity.this, BiologyHandNoteActivity.class));
            }
        });
    }

    private void hmathExpandableButtonSection() {
        LinearLayout hmathToggleButton = findViewById(R.id.hmath_toggle_button);
        LinearLayout hmathCollapsibleView = findViewById(R.id.hmath_collapsible_view);
        ImageView hmathToggleIcon = findViewById(R.id.hmath_toggle_icon);


        hmathToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    hmathCollapsibleView.setVisibility(View.GONE);
                    hmathToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    hmathCollapsibleView.setVisibility(View.VISIBLE);
                    hmathToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void hmathButtonSection() {
        Button hmathBoardBookButton = findViewById(R.id.hmath_board_book_id);
        hmathBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScienceActivity.this, HigherMathBoardBookActivity.class));
            }
        });

        Button hmathGuideBookButton = findViewById(R.id.hmath_guide_book_id);
        hmathGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScienceActivity.this, HigherMathGuideBookActivity.class));
            }
        });

        Button hmathHandNoteButton = findViewById(R.id.hmath_hand_note_id);
        hmathHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScienceActivity.this, HigherMathHandNoteActivity.class));
            }
        });
    }

}