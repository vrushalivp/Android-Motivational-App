
package com.example.motivationalspeaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/*

public class Dashboard extends Activity {
    ListView list;
    String[] web = {
            "Les Brown",
            "Nick Vujicic",
    } ;
    Integer[] imageId = {
            R.drawable.ls1,
            R.drawable.nv,

    };
    FirebaseDatabase databases;
    DatabaseReference dref;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    FirebaseAuth mFirebaseAuth;


    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menulist, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mFirebaseAuth = FirebaseAuth.getInstance();
        databases=FirebaseDatabase.getInstance();
        dref=databases.getReference();


        CustomList adapter = new
                CustomList(Dashboard.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(Dashboard.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.i1) {
            FirebaseAuth.getInstance().signOut();
            Intent intToMain=new Intent(Dashboard.this,MainActivity.class);
            startActivity(intToMain);

        }

        return super.onOptionsItemSelected(item);
    }
}*/


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    ListView list;
    String[] web = {
            "Les Brown",
            "Nick Vujicic"
    } ;
    Integer[] imageId = {
            R.drawable.ls1,
            R.drawable.nv,

    };
    FirebaseDatabase firebaseDatabase;

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menulist, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        FirebaseDatabase.getInstance().getReference("Speakers").child("Speaker1").child("Name").setValue("Les Brown");
        FirebaseDatabase.getInstance().getReference("Speakers").child("Speaker2").child("Name").setValue("Nick Vijucic");

        CustomList adapter = new
                CustomList(Dashboard.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(Dashboard.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                if (id == 0){
                    Intent i = new Intent(Dashboard.this,VidPlaylist1.class);
                    startActivity(i);
                }
                else{
                    Intent i = new Intent(Dashboard.this,VidPlaylist2.class);
                    startActivity(i);
                }

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.i1) {
            FirebaseAuth.getInstance().signOut();
            Intent intToMain=new Intent(Dashboard.this,MainActivity.class);
            startActivity(intToMain);

        }
        return super.onOptionsItemSelected(item);
    }
}