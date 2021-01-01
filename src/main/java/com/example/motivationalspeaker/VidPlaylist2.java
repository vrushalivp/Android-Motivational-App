package com.example.motivationalspeaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class VidPlaylist2 extends AppCompatActivity {

    ListView list;
    String[] web1 = {
            "God's Plan for Your Life",
            "Don't Limit God",
            "Overcoming Hopelessness"
    } ;
    Integer[] imageId1 = {
            R.drawable.nickvid1,
            R.drawable.nickvid2,
            R.drawable.nickvid3

    };

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menulist, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vid_playlist2);
/*
        FirebaseDatabase.getInstance().getReference("Speakers").child("Speaker1").child("Name").setValue("Les Brown");
        FirebaseDatabase.getInstance().getReference("Speakers").child("Speaker2").child("Name").setValue("Nick Vijucic");*/

        CustomList2 adapter = new
                CustomList2(VidPlaylist2.this, web1, imageId1);
        list=(ListView)findViewById(R.id.list1);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(VidPlaylist2.this, "You Clicked at " +web1[+ position], Toast.LENGTH_SHORT).show();
                if (id == 0){
                    Intent i = new Intent(VidPlaylist2.this,NickVujicic.class);
                    startActivity(i);
                }
                else if (id == 1){
                    Intent i = new Intent(VidPlaylist2.this,NickVujicic2.class);
                    startActivity(i);
                }else if (id == 2){
                    Intent i = new Intent(VidPlaylist2.this,NickVujicic3.class);
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
            Intent intToMain=new Intent(VidPlaylist2.this,MainActivity.class);
            startActivity(intToMain);
        }

        return super.onOptionsItemSelected(item);
    }
}
