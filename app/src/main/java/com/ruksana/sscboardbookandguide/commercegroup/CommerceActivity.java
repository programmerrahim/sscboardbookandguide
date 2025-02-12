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
import com.ruksana.sscboardbookandguide.commercegroup.accounting.AccountingBoardBookActivity;
import com.ruksana.sscboardbookandguide.commercegroup.accounting.AccountingGuideBookActivity;
import com.ruksana.sscboardbookandguide.commercegroup.accounting.AccountingHandNoteActivity;
import com.ruksana.sscboardbookandguide.commercegroup.business.BusinessBoardBookActivity;
import com.ruksana.sscboardbookandguide.commercegroup.business.BusinessGuideBookActivity;
import com.ruksana.sscboardbookandguide.commercegroup.business.BusinessHandNoteActivity;
import com.ruksana.sscboardbookandguide.commercegroup.finance.FinanceBoardBookActivity;
import com.ruksana.sscboardbookandguide.commercegroup.finance.FinanceGuideBookActivity;
import com.ruksana.sscboardbookandguide.commercegroup.finance.FinanceHandNoteActivity;
import com.ruksana.sscboardbookandguide.commercegroup.sc.ScBoardBookActivity;
import com.ruksana.sscboardbookandguide.commercegroup.sc.ScGuideBookActivity;
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

public class CommerceActivity extends AppCompatActivity {

    private boolean isExpanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commerce);

        FirebaseApp.initializeApp(this);

        actionBar();

        accountingExpandableButtonSection();
        accountingButtonSection();

        financeExpandableButtonSection();
        financeButtonSection();

        businessExpandableButtonSection();
        businessButtonSection();

        scienceExpandableButtonSection();
        scienceButtonSection();


    }

    //------------


    //actionbar
    private void actionBar() {
        //int action bar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle(R.string.commerce_div);


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


    private void accountingExpandableButtonSection() {
        LinearLayout accountingToggleButton = findViewById(R.id.accounting_toggle_button);
        LinearLayout accountingCollapsibleView = findViewById(R.id.accounting_collapsible_view);
        ImageView accountingToggleIcon = findViewById(R.id.accounting_toggle_icon);


        accountingToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    accountingCollapsibleView.setVisibility(View.GONE);
                    accountingToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    accountingCollapsibleView.setVisibility(View.VISIBLE);
                    accountingToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void accountingButtonSection() {
        Button accountingBoardBookButton = findViewById(R.id.accounting_board_book_id);
        accountingBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommerceActivity.this, AccountingBoardBookActivity.class));
            }
        });

        Button accountingGuideBookButton = findViewById(R.id.accounting_guide_book_id);
        accountingGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommerceActivity.this, AccountingGuideBookActivity.class));
            }
        });

        Button accountingHandNoteButton = findViewById(R.id.accounting_hand_note_id);
        accountingHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommerceActivity.this, AccountingHandNoteActivity.class));
            }
        });
    }

    private void financeExpandableButtonSection() {
        LinearLayout financeToggleButton = findViewById(R.id.finance_toggle_button);
        LinearLayout financeCollapsibleView = findViewById(R.id.finance_collapsible_view);
        ImageView financeToggleIcon = findViewById(R.id.finance_toggle_icon);


        financeToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    financeCollapsibleView.setVisibility(View.GONE);
                    financeToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    financeCollapsibleView.setVisibility(View.VISIBLE);
                    financeToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void financeButtonSection() {
        Button financeBoardBookButton = findViewById(R.id.finance_board_book_id);
        financeBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommerceActivity.this, FinanceBoardBookActivity.class));
            }
        });

        Button financeGuideBookButton = findViewById(R.id.finance_guide_book_id);
        financeGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommerceActivity.this, FinanceGuideBookActivity.class));
            }
        });

        Button financeHandNoteButton = findViewById(R.id.finance_hand_note_id);
        financeHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommerceActivity.this, FinanceHandNoteActivity.class));
            }
        });
    }

    private void businessExpandableButtonSection() {
        LinearLayout businessToggleButton = findViewById(R.id.business_toggle_button);
        LinearLayout businessCollapsibleView = findViewById(R.id.business_collapsible_view);
        ImageView businessToggleIcon = findViewById(R.id.business_toggle_icon);


        businessToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    businessCollapsibleView.setVisibility(View.GONE);
                    businessToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    businessCollapsibleView.setVisibility(View.VISIBLE);
                    businessToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void businessButtonSection() {
        Button businessBoardBookButton = findViewById(R.id.business_board_book_id);
        businessBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommerceActivity.this, BusinessBoardBookActivity.class));
            }
        });

        Button businessGuideBookButton = findViewById(R.id.business_guide_book_id);
        businessGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommerceActivity.this, BusinessGuideBookActivity.class));
            }
        });

        Button businessHandNoteButton = findViewById(R.id.business_hand_note_id);
        businessHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommerceActivity.this, BusinessHandNoteActivity.class));
            }
        });
    }

    private void scienceExpandableButtonSection() {
        LinearLayout scienceToggleButton = findViewById(R.id.science_toggle_button);
        LinearLayout scienceCollapsibleView = findViewById(R.id.science_collapsible_view);
        ImageView scienceToggleIcon = findViewById(R.id.science_toggle_icon);


        scienceToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    scienceCollapsibleView.setVisibility(View.GONE);
                    scienceToggleIcon.setImageResource(R.drawable.right_arrow);

                } else {
                    scienceCollapsibleView.setVisibility(View.VISIBLE);
                    scienceToggleIcon.setImageResource(R.drawable.down_arrow);

                }
                isExpanded = !isExpanded;
            }
        });
    }

    private void scienceButtonSection() {
        Button scienceBoardBookButton = findViewById(R.id.science_board_book_id);
        scienceBoardBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommerceActivity.this, ScBoardBookActivity.class));
            }
        });

        Button scienceGuideBookButton = findViewById(R.id.science_guide_book_id);
        scienceGuideBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommerceActivity.this, ScGuideBookActivity.class));
            }
        });

        Button scienceHandNoteButton = findViewById(R.id.science_hand_note_id);
        scienceHandNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommerceActivity.this, ScGuideBookActivity.class));
            }
        });
    }
}