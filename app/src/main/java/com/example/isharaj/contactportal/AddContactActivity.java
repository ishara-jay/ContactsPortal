package com.example.isharaj.contactportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.isharaj.contactportal.entities.Person;
import com.example.isharaj.contactportal.services.DatabaseHelper;

public class AddContactActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    private EditText firstNameField;
    private EditText lastNameFIeld;
    private EditText mobileNumberField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        this.firstNameField = findViewById(R.id.first_nameEdit);
        this.lastNameFIeld =  findViewById(R.id.last_nameEdit);
        this.mobileNumberField = findViewById(R.id.contact_numberEdit);
        mDatabaseHelper = new DatabaseHelper(this);
    }

    public void onClickAdd(View view){
        String firstName = firstNameField.getText().toString();
        String lastName = lastNameFIeld.getText().toString();
        String mobileNumber = mobileNumberField.getText().toString();

        if(firstName == null || lastName == null || mobileNumber ==null){
            toastMessage("Please fill the all fields first");
        }else{
            Person person = new Person(firstName,lastName,mobileNumber);
            addData(person);
            goToContactList();
        }
    }

    private void goToContactList() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void addData(Person person){
        boolean isInsertedSuccessfully = mDatabaseHelper.addContact(person);
        if(isInsertedSuccessfully){
            toastMessage("Contact added successfully");
        }
        else {
            toastMessage("Something went wrong");
        }
    }

    public void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


}
