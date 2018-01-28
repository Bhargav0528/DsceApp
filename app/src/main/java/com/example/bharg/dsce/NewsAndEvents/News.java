package com.example.bharg.dsce.NewsAndEvents;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bharg.dsce.R;
import com.example.bharg.dsce.models.News_model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class News extends Fragment {

    private RecyclerView recView;
    private RecyclerView.Adapter recadap;

    private FirebaseAuth mAuth;
    private DatabaseReference dref;

    List<News_model> news_models;

    public News() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        mAuth = FirebaseAuth.getInstance();

        recView = (RecyclerView)view.findViewById(R.id.recview);
        recView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recView.setLayoutManager(layoutManager);

        news_models = new ArrayList<>();
        dref = FirebaseDatabase.getInstance().getReference();

        dref.child("news").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot postsnap:dataSnapshot.getChildren()) {

                    News_model news_model = postsnap.getValue(News_model.class);
                    news_models.add(news_model);
                    recadap.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        recadap = new NewsAdapter(getActivity(),news_models);
        recView.setAdapter(recadap);
        return view;
    }

}
