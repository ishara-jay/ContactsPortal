package com.example.isharaj.contactportal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.isharaj.contactportal.entities.Person;
import com.example.isharaj.contactportal.services.DatabaseHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> people = new ArrayList<>();
    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDatabaseHelper = new DatabaseHelper(this);
        getContacts();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,people);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void goToAddContactActivity(View view){
        Intent addContactIntent = new Intent(this,AddContactActivity.class);
        startActivity(addContactIntent);
    }

    public void getContacts() {
        people.clear();
        Cursor contacts = mDatabaseHelper.getData();
        while(contacts.moveToNext()){
            people.add(new Person(contacts.getString(1),
                    contacts.getString(2),
                    contacts.getString(3)));
        }
        Collections.sort(people);
    }
}
