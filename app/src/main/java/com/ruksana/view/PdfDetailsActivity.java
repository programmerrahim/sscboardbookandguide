package com.ruksana.view;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.FirebaseApp;
import com.ruksana.sscboardbookandguide.R;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class PdfDetailsActivity extends AppCompatActivity {


    private PDFView pdfView;
    private ProgressBar progressBar;
    String PDF_URL = "https://pub-db2705d10dde459bbc5b0d7088cbd3c7.r2.dev/test.pdf"; // Replace with your public URL

    String pdfUrl, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_pdf);


        //int action bar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;


        //add back button
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        FirebaseApp.initializeApp(this);


        pdfView = findViewById(R.id.pdf_view);
        progressBar = findViewById(R.id.progress_bar);

        pdfUrl = getIntent().getStringExtra("data");
        title = getIntent().getStringExtra("name");

        actionBar.setTitle(title);

        new DownloadPdfTask().execute(pdfUrl);


    }//End On create

    private class DownloadPdfTask extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    return new BufferedInputStream(connection.getInputStream());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            if (inputStream != null) {
                pdfView.fromStream(inputStream)
                        .enableSwipe(true)
                        .swipeHorizontal(false)
                        .enableDoubletap(true)
                        .fitEachPage(true)
                        .autoSpacing(false)
                        .enableAnnotationRendering(true) // render annotations (such as comments, colors or forms)
                        .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                        .load();
                progressBar.setVisibility(View.GONE);


            } else {
                // Handle error (e.g., show a Toast)
                android.widget.Toast.makeText(PdfDetailsActivity.this, "Failed to load PDF", android.widget.Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();//go previous activity, when back button of  actionbar clicked
        return super.onSupportNavigateUp();
    }


}