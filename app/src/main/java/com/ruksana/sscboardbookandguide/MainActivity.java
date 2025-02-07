package com.ruksana.sscboardbookandguide;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.ruksana.sscboardbookandguide.artsgroup.ArtsActivity;
import com.ruksana.sscboardbookandguide.bakoron.BakoronBoardBookActivity;
import com.ruksana.sscboardbookandguide.bakoron.BakoronGuideBookActivity;
import com.ruksana.sscboardbookandguide.bakoron.BakoronHandNoteActivity;
import com.ruksana.sscboardbookandguide.banglasahitto.BanglaSahittoHandNoteActivity;
import com.ruksana.sscboardbookandguide.banglasahitto.BanglaSahittoGuideBookActivity;
import com.ruksana.sscboardbookandguide.banglasahitto.BanglaSahittoBoardBookActivity;
import com.ruksana.sscboardbookandguide.commercegroup.CommerceActivity;
import com.ruksana.sscboardbookandguide.english.EnglishBoardBookActivity;
import com.ruksana.sscboardbookandguide.english.EnglishGuideBookActivity;
import com.ruksana.sscboardbookandguide.english.EnglishHandNoteActivity;
import com.ruksana.sscboardbookandguide.grammar.GrammarBoardBookActivity;
import com.ruksana.sscboardbookandguide.grammar.GrammarGuideBookActivity;
import com.ruksana.sscboardbookandguide.grammar.GrammarHandNoteActivity;
import com.ruksana.sscboardbookandguide.ict.IctBoardBookActivity;
import com.ruksana.sscboardbookandguide.ict.IctGuideBookActivity;
import com.ruksana.sscboardbookandguide.ict.IctHandNoteActivity;
import com.ruksana.sscboardbookandguide.math.MathBoardBookActivity;
import com.ruksana.sscboardbookandguide.math.MathGuideBookActivity;
import com.ruksana.sscboardbookandguide.math.MathHandNoteActivity;
import com.ruksana.sscboardbookandguide.sciencegroup.ScienceActivity;
import com.ruksana.sscboardbookandguide.sohopath.SohopathBoardBookActivity;
import com.ruksana.sscboardbookandguide.sohopath.SohopathGuideBookActivity;
import com.ruksana.sscboardbookandguide.sohopath.SohopathHandNoteActivity;


public class MainActivity extends AppCompatActivity {


    private boolean isExpanded = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);


        banglaSahittoExpandableButtonSection();
        banglaSahittoButtonSection();


        sohopathExpandableButtonSection();
        sohopathButtonSection();


        bakoronExpandableButtonSection();
        bakoronButtonSection();

        englishExpandableButtonSection();
        englishButtonSection();

        grammarExpandableButtonSection();
        grammarButtonSection();

        mathExpandableButtonSection();
        mathButtonSection();

        ictExpandableButtonSection();
        ictButtonSection();


        scienceDivButtonSection();

        commerceDivButtonSection();

        artsDivButtonSection();


    }

    private void banglaSahittoExpandableButtonSection() {
        LinearLayout banglaSahittoToggleButton = findViewById(R.id.bangla_shaitto_toggle_button);
        LinearLayout banglaSahittoCollapsibleView = findViewById(R.id.collapsible_view);
        ImageView primaryToggleIcon = findViewById(R.id.toggle_icon);


        banglaSahittoToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    banglaSahittoCollapsibleView.setVisibility(View.GONE);
                    primaryToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    banglaSahittoCollapsibleView.setVisibility(View.VISIBLE);
                    primaryToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void banglaSahittoButtonSection() {
        Button banglaSahittoBoardBookButton = findViewById(R.id.bangla_shaitto_board_book_id);
        banglaSahittoBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BanglaSahittoBoardBookActivity.class));
            }
        });

        Button banglaSahittoGuideBookButton = findViewById(R.id.bangla_shaitto_guide_book_id);
        banglaSahittoGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BanglaSahittoGuideBookActivity.class));
            }
        });

        Button banglaSahittoHandNoteButton = findViewById(R.id.bangla_shaitto_hand_note_id);
        banglaSahittoHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BanglaSahittoHandNoteActivity.class));
            }
        });
    }

    private void sohopathExpandableButtonSection() {
        LinearLayout sohopathToggleButton = findViewById(R.id.sohopath_toggle_button);
        LinearLayout sohopathCollapsibleView = findViewById(R.id.sohopath_collapsible_view);
        ImageView primaryToggleIcon = findViewById(R.id.sohopath_toggle_icon);


        sohopathToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    sohopathCollapsibleView.setVisibility(View.GONE);
                    primaryToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    sohopathCollapsibleView.setVisibility(View.VISIBLE);
                    primaryToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void sohopathButtonSection() {
        Button sohopathBoardBookButton = findViewById(R.id.sohopath_board_book_id);
        sohopathBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SohopathBoardBookActivity.class));
            }
        });

        Button banglaSahittoGuideBookButton = findViewById(R.id.sohopath_guide_book_id);
        banglaSahittoGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SohopathGuideBookActivity.class));
            }
        });

        Button banglaSahittoHandNoteButton = findViewById(R.id.sohopath_hand_note_id);
        banglaSahittoHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SohopathHandNoteActivity.class));
            }
        });
    }

    private void bakoronExpandableButtonSection() {
        LinearLayout bakoronToggleButton = findViewById(R.id.bakoron_toggle_button);
        LinearLayout bakoronCollapsibleView = findViewById(R.id.bakoron_collapsible_view);
        ImageView bakoronToggleIcon = findViewById(R.id.bakoron_toggle_icon);


        bakoronToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    bakoronCollapsibleView.setVisibility(View.GONE);
                    bakoronToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    bakoronCollapsibleView.setVisibility(View.VISIBLE);
                    bakoronToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void bakoronButtonSection() {
        Button bakoronBoardBookButton = findViewById(R.id.bakoron_board_book_id);
        bakoronBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BakoronBoardBookActivity.class));
            }
        });

        Button bakoronGuideBookButton = findViewById(R.id.bakoron_guide_book_id);
        bakoronGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BakoronGuideBookActivity.class));
            }
        });

        Button bakoronHandNoteButton = findViewById(R.id.bakoron_hand_note_id);
        bakoronHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BakoronHandNoteActivity.class));
            }
        });
    }


    private void englishExpandableButtonSection() {
        LinearLayout englishToggleButton = findViewById(R.id.english_toggle_button);
        LinearLayout englishCollapsibleView = findViewById(R.id.english_collapsible_view);
        ImageView englishToggleIcon = findViewById(R.id.english_toggle_icon);


        englishToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    englishCollapsibleView.setVisibility(View.GONE);
                    englishToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    englishCollapsibleView.setVisibility(View.VISIBLE);
                    englishToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void englishButtonSection() {
        Button englishBoardBookButton = findViewById(R.id.english_board_book_id);
        englishBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EnglishBoardBookActivity.class));
            }
        });

        Button englishGuideBookButton = findViewById(R.id.english_guide_book_id);
        englishGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EnglishGuideBookActivity.class));
            }
        });

        Button englishHandNoteButton = findViewById(R.id.english_hand_note_id);
        englishHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EnglishHandNoteActivity.class));
            }
        });
    }

    private void grammarExpandableButtonSection() {
        LinearLayout grammarToggleButton = findViewById(R.id.grammar_toggle_button);
        LinearLayout grammarCollapsibleView = findViewById(R.id.grammar_collapsible_view);
        ImageView grammarToggleIcon = findViewById(R.id.grammar_toggle_icon);


        grammarToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    grammarCollapsibleView.setVisibility(View.GONE);
                    grammarToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    grammarCollapsibleView.setVisibility(View.VISIBLE);
                    grammarToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void grammarButtonSection() {
        Button grammarBoardBookButton = findViewById(R.id.grammar_board_book_id);
        grammarBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GrammarBoardBookActivity.class));
            }
        });

        Button grammarGuideBookButton = findViewById(R.id.grammar_guide_book_id);
        grammarGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GrammarGuideBookActivity.class));
            }
        });

        Button grammarHandNoteButton = findViewById(R.id.grammar_hand_note_id);
        grammarHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GrammarHandNoteActivity.class));
            }
        });
    }

    private void mathExpandableButtonSection() {
        LinearLayout mathToggleButton = findViewById(R.id.math_toggle_button);
        LinearLayout mathCollapsibleView = findViewById(R.id.math_collapsible_view);
        ImageView mathToggleIcon = findViewById(R.id.math_toggle_icon);


        mathToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    mathCollapsibleView.setVisibility(View.GONE);
                    mathToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    mathCollapsibleView.setVisibility(View.VISIBLE);
                    mathToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void mathButtonSection() {
        Button mathBoardBookButton = findViewById(R.id.math_board_book_id);
        mathBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MathBoardBookActivity.class));
            }
        });

        Button mathGuideBookButton = findViewById(R.id.math_guide_book_id);
        mathGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MathGuideBookActivity.class));
            }
        });

        Button mathHandNoteButton = findViewById(R.id.math_hand_note_id);
        mathHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MathHandNoteActivity.class));
            }
        });
    }

    private void ictExpandableButtonSection() {
        LinearLayout ictToggleButton = findViewById(R.id.ict_toggle_button);
        LinearLayout ictCollapsibleView = findViewById(R.id.ict_collapsible_view);
        ImageView ictToggleIcon = findViewById(R.id.ict_toggle_icon);


        ictToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    ictCollapsibleView.setVisibility(View.GONE);
                    ictToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    ictCollapsibleView.setVisibility(View.VISIBLE);
                    ictToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void ictButtonSection() {
        Button ictBoardBookButton = findViewById(R.id.ict_board_book_id);
        ictBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, IctBoardBookActivity.class));
            }
        });

        Button ictGuideBookButton = findViewById(R.id.ict_guide_book_id);
        ictGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, IctGuideBookActivity.class));
            }
        });

        Button ictHandNoteButton = findViewById(R.id.ict_hand_note_id);
        ictHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, IctHandNoteActivity.class));
            }
        });
    }

    private void scienceDivButtonSection() {
        LinearLayout scienceDivBoardBookButton = findViewById(R.id.science_div_toggle_button);
        scienceDivBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ScienceActivity.class));
            }
        });
    }

    private void commerceDivButtonSection() {
        LinearLayout commerceDivBoardBookButton = findViewById(R.id.commerce_div_toggle_button);
        commerceDivBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CommerceActivity.class));
            }
        });
    }

    private void artsDivButtonSection() {
        LinearLayout artsDivBoardBookButton = findViewById(R.id.arts_div_toggle_button);
        artsDivBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ArtsActivity.class));
            }
        });
    }

//    hi

}
