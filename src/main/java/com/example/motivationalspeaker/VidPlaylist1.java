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
public class VidPlaylist1 extends AppCompatActivity {

    ListView list;
    String[] web = {
            "Why it Pays to Be Hungry",
            "How Bamboo Trees will Bring Out Your Best Self",
            "The Ultimate Les Brown Motivational Compilation"
    } ;
    Integer[] imageId = {
            R.drawable.lsvid1,
            R.drawable.lsvid2,
            R.drawable.lsvid3

    };

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menulist, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vid_playlist1);
/*

        FirebaseDatabase.getInstance().getReference("Speakers").child("Speaker1").child("Name").setValue("Les Brown");
        FirebaseDatabase.getInstance().getReference("Speakers").child("Speaker2").child("Name").setValue("Nick Vijucic");
*/

        CustomList1 adapter = new
                CustomList1(VidPlaylist1.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(VidPlaylist1.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                if (id == 0){
                    Intent i = new Intent(VidPlaylist1.this,LesBrown.class);
                    startActivity(i);
                }
                else if (id == 1){
                    Intent i = new Intent(VidPlaylist1.this,LesBrown2.class);
                    startActivity(i);
                }else if (id == 2){
                    Intent i = new Intent(VidPlaylist1.this,LesBrown3.class);
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
            Intent intToMain=new Intent(VidPlaylist1.this,MainActivity.class);
            startActivity(intToMain);
        }

        return super.onOptionsItemSelected(item);
    }
}
