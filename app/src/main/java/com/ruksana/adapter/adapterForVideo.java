package com.ruksana.adapter;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.ruksana.model.Model_For_Video;
import com.ruksana.sscboardbookandguide.R;

import java.util.ArrayList;


public class adapterForVideo extends RecyclerView.Adapter<adapterForVideo.myviewholder> {
    ArrayList<Model_For_Video> datalist;

    public adapterForVideo(ArrayList<Model_For_Video> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_layout_video, parent, false);
        return new myviewholder(view);
    }

//    @Override
//    public void onBindViewHolder(@NonNull final myviewholder holder, @SuppressLint("RecyclerView") int position) {
//        holder.name.setText(datalist.get(position).getName());
//
//
//        holder.mlayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // Create an intent to start the PostActivity
//                Intent intent = new Intent(v.getContext(), PdfDetailsActivity.class);
//                intent.putExtra("categoryQ", datalist.get(position).getCategoryQ());
//                intent.putExtra("name", datalist.get(position).getName());
//                intent.putExtra("data", datalist.get(position).getData());
//                v.getContext().startActivity(intent);
//
//            }
//        });
//
//    }

    @Override
    public void onBindViewHolder(@NonNull final myviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(datalist.get(position).getName());

        holder.mlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an AlertDialog.Builder instance
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

                // Set the title and message
                builder.setTitle("Opening Alert!");
                builder.setMessage("Yor are going to browser");

                // Set up the buttons
                builder.setPositiveButton("Go Now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // User clicked "Yes", proceed with the action
                        String url = datalist.get(position).getVideoLink().toString();
                        try {
                            CustomTabsIntent intent = new CustomTabsIntent.Builder()
                                    .build();
                            intent.launchUrl(v.getContext(), Uri.parse(url));
                        } catch (Exception e) {
                            Toast.makeText(v.getContext(), "No link available.. Please try again later", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                builder.setNegativeButton("Later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // User clicked "No", dismiss the dialog
                        dialog.dismiss();
                    }
                });

                // Create the AlertDialog
                AlertDialog dialog = builder.create();

                // Show the dialog
                dialog.show();

                // Customize the dialog colors
                dialog.getWindow().setBackgroundDrawableResource(R.color.dialog_background); // Background color
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(v.getContext(), R.color.positive_button_color)); // Positive button color
                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(v.getContext(), R.color.negative_button_color)); // Negative button color

                // Customize title and message text colors
                TextView titleTextView = dialog.findViewById(android.R.id.title);
                if (titleTextView != null) {
                    titleTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.dialog_title_text));
                }

                TextView messageTextView = dialog.findViewById(android.R.id.message);
                if (messageTextView != null) {
                    messageTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.dialog_message_text));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        LinearLayout mlayout;
        TextView name;
//        ImageView watchNowBtn;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.sample_name_videoId);
//            watchNowBtn = itemView.findViewById(R.id.watchNowButtonId);
            mlayout = itemView.findViewById(R.id.sample_mainLinearId);

        }
    }

}
