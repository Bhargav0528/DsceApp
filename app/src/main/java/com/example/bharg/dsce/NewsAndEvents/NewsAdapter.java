package com.example.bharg.dsce.NewsAndEvents;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bharg.dsce.R;
import com.example.bharg.dsce.models.News_model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by bhargav-0528 on 28/1/18.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    public Context c;
    private List<News_model> models;
    private FirebaseAuth mAuth;
    private DatabaseReference dref;


    public NewsAdapter(Context c, List<News_model> models) {
        this.c = c;
        this.models = models;
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_model, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final NewsAdapter.ViewHolder holder, int position) {

         News_model news_model = models.get(position);

        mAuth = FirebaseAuth.getInstance();
        dref = FirebaseDatabase.getInstance().getReference();


        holder.mainText.setText(news_model.getText());
        holder.description.setText(news_model.getDescription());
        holder.category.setText(news_model.getCategory());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView mainText;
        public TextView description;
        public TextView category;

        public ViewHolder(View itemView) {
            super(itemView);

            mainText = itemView.findViewById(R.id.themessage);
            description = itemView.findViewById(R.id.description);
            category = itemView.findViewById(R.id.category);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(c,"Hello",Toast.LENGTH_SHORT).show();
        }
    }
}
