package com.example.motivationalspeaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NickVujicic3 extends AppCompatActivity {

    VideoView video;
    TextView url;
    ProgressDialog pd;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
   /* private DatabaseReference reference=firebaseDatabase.getReference();
    private DatabaseReference childreference=reference.child("url");*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nick_vujicic3);

        video=(VideoView)findViewById(R.id.video3);
        pd=new ProgressDialog(NickVujicic3.this);
        url=(TextView)findViewById(R.id.text3);
        pd.setMessage("Buffering Please wait");
        pd.show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseDatabase.getInstance().getReference("Speakers").child("Speaker2").child("url3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String message=snapshot.getValue(String.class);
                Uri uri= Uri.parse(message);
                video.setVideoURI(uri);
                video.start();
                video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        pd.dismiss();
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}
