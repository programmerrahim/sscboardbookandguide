package com.ruksana.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.ruksana.adapter.adapter;
import com.ruksana.model.Model_For_practice;
import com.ruksana.sscboardbookandguide.R;

import java.util.ArrayList;

public class PracticeActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;

    RecyclerView recview;

    ArrayList<Model_For_practice> datalist;
    FirebaseFirestore db;

    adapter adapter;

    String name;
    String category;

    private ProgressBar loadingIndicator; // Added loading indicator


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);


        FirebaseApp.initializeApp(this);

        // Initialize Loading Indicator
        loadingIndicator = findViewById(R.id.loading_indicator);


        name = getIntent().getStringExtra("BUTTON_NAME");
        category = getIntent().getStringExtra("CATEGORY");


        //int action bar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;


        //add back button
        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(name);


        recview = findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(PracticeActivity.this));

        db = FirebaseFirestore.getInstance();

        datalist = new ArrayList<>();

        adapter = new adapter(datalist);


        recview.setAdapter(adapter);


        datalist.clear();
        loadData();


        swipeRefreshLayout = findViewById(R.id.main_swipe_layoutId);
        swipeRefreshLayout.setOnRefreshListener(() -> {

            datalist.clear();
            loadData();

            swipeRefreshLayout.setRefreshing(false);
        });
    }

    //onCreate End


    private void loadData() {
        // Show loading indicator while fetching course data
        loadingIndicator.setVisibility(View.VISIBLE);
        db = FirebaseFirestore.getInstance();
        db.collection("PracticeItems")
                .orderBy("category", Query.Direction.ASCENDING)
                .whereEqualTo("category", category)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        ArrayList<DocumentSnapshot> list = (ArrayList<DocumentSnapshot>) queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d : list) {
                            Model_For_practice obj = d.toObject(Model_For_practice.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                        // Hide loading indicator when data is loaded
                        loadingIndicator.setVisibility(View.GONE);
                    }
                });
    }


    //Back Override method
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();//go previous activity, when back button of  actionbar clicked
        return super.onSupportNavigateUp();
    }
}