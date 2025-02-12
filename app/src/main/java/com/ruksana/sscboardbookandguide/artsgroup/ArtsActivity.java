package com.ruksana.sscboardbookandguide.artsgroup;

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
import com.ruksana.sscboardbookandguide.artsgroup.civics.CivicsBoardBookActivity;
import com.ruksana.sscboardbookandguide.artsgroup.civics.CivicsGuideBookActivity;
import com.ruksana.sscboardbookandguide.artsgroup.civics.CivicsHandNoteActivity;
import com.ruksana.sscboardbookandguide.artsgroup.economics.EconomicsBoardBookActivity;
import com.ruksana.sscboardbookandguide.artsgroup.economics.EconomicsGuideBookActivity;
import com.ruksana.sscboardbookandguide.artsgroup.economics.EconomicsHandNoteActivity;
import com.ruksana.sscboardbookandguide.artsgroup.geography.GeographyBoardBookActivity;
import com.ruksana.sscboardbookandguide.artsgroup.geography.GeographyGuideBookActivity;
import com.ruksana.sscboardbookandguide.artsgroup.geography.GeographyHandNoteActivity;
import com.ruksana.sscboardbookandguide.artsgroup.history.HistoryBoardBookActivity;
import com.ruksana.sscboardbookandguide.artsgroup.history.HistoryGuideBookActivity;
import com.ruksana.sscboardbookandguide.artsgroup.history.HistoryHandNoteActivity;
import com.ruksana.sscboardbookandguide.sciencegroup.ScienceActivity;
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

public class ArtsActivity extends AppCompatActivity {

    private boolean isExpanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts);

        FirebaseApp.initializeApp(this);

        actionBar();

        civicsExpandableButtonSection();
        civicsButtonSection();

        economicsExpandableButtonSection();
        economicsButtonSection();

        geographyExpandableButtonSection();
        geographyButtonSection();

        historyExpandableButtonSection();
        historyButtonSection();


    }


    //actionbar
    private void actionBar() {
        //int action bar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle(R.string.arts_div);


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


    private void civicsExpandableButtonSection() {
        LinearLayout civicsToggleButton = findViewById(R.id.civics_toggle_button);
        LinearLayout civicsCollapsibleView = findViewById(R.id.civics_collapsible_view);
        ImageView civicsToggleIcon = findViewById(R.id.civics_toggle_icon);


        civicsToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    civicsCollapsibleView.setVisibility(View.GONE);
                    civicsToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    civicsCollapsibleView.setVisibility(View.VISIBLE);
                    civicsToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void civicsButtonSection() {
        Button civicsBoardBookButton = findViewById(R.id.civics_board_book_id);
        civicsBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArtsActivity.this, CivicsBoardBookActivity.class));
            }
        });

        Button civicsGuideBookButton = findViewById(R.id.civics_guide_book_id);
        civicsGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArtsActivity.this, CivicsGuideBookActivity.class));
            }
        });

        Button civicsHandNoteButton = findViewById(R.id.civics_hand_note_id);
        civicsHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArtsActivity.this, CivicsHandNoteActivity.class));
            }
        });
    }

    private void economicsExpandableButtonSection() {
        LinearLayout economicsToggleButton = findViewById(R.id.economics_toggle_button);
        LinearLayout economicsCollapsibleView = findViewById(R.id.economics_collapsible_view);
        ImageView economicsToggleIcon = findViewById(R.id.economics_toggle_icon);


        economicsToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    economicsCollapsibleView.setVisibility(View.GONE);
                    economicsToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    economicsCollapsibleView.setVisibility(View.VISIBLE);
                    economicsToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void economicsButtonSection() {
        Button economicsBoardBookButton = findViewById(R.id.economics_board_book_id);
        economicsBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArtsActivity.this, EconomicsBoardBookActivity.class));
            }
        });

        Button economicsGuideBookButton = findViewById(R.id.economics_guide_book_id);
        economicsGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArtsActivity.this, EconomicsGuideBookActivity.class));
            }
        });

        Button economicsHandNoteButton = findViewById(R.id.economics_hand_note_id);
        economicsHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArtsActivity.this, EconomicsHandNoteActivity.class));
            }
        });
    }

    private void geographyExpandableButtonSection() {
        LinearLayout geographyToggleButton = findViewById(R.id.geography_toggle_button);
        LinearLayout geographyCollapsibleView = findViewById(R.id.geography_collapsible_view);
        ImageView geographyToggleIcon = findViewById(R.id.geography_toggle_icon);


        geographyToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    geographyCollapsibleView.setVisibility(View.GONE);
                    geographyToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    geographyCollapsibleView.setVisibility(View.VISIBLE);
                    geographyToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void geographyButtonSection() {
        Button geographyBoardBookButton = findViewById(R.id.geography_board_book_id);
        geographyBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArtsActivity.this, GeographyBoardBookActivity.class));
            }
        });

        Button geographyGuideBookButton = findViewById(R.id.geography_guide_book_id);
        geographyGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArtsActivity.this, GeographyGuideBookActivity.class));
            }
        });

        Button geographyHandNoteButton = findViewById(R.id.geography_hand_note_id);
        geographyHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArtsActivity.this, GeographyHandNoteActivity.class));
            }
        });
    }

    private void historyExpandableButtonSection() {
        LinearLayout historyToggleButton = findViewById(R.id.history_toggle_button);
        LinearLayout historyCollapsibleView = findViewById(R.id.history_collapsible_view);
        ImageView historyToggleIcon = findViewById(R.id.history_toggle_icon);


        historyToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    historyCollapsibleView.setVisibility(View.GONE);
                    historyToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    historyCollapsibleView.setVisibility(View.VISIBLE);
                    historyToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void historyButtonSection() {
        Button historyBoardBookButton = findViewById(R.id.history_board_book_id);
        historyBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArtsActivity.this, HistoryBoardBookActivity.class));
            }
        });

        Button historyGuideBookButton = findViewById(R.id.history_guide_book_id);
        historyGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArtsActivity.this, HistoryGuideBookActivity.class));
            }
        });

        Button historyHandNoteButton = findViewById(R.id.history_hand_note_id);
        historyHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArtsActivity.this, HistoryHandNoteActivity.class));
            }
        });
    }
}