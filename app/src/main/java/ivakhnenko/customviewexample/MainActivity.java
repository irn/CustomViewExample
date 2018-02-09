package ivakhnenko.customviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ivakhnenko.customviewexample.model.User;
import ivakhnenko.customviewexample.model.UserRole;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("ruslan");
        float rating = 1;
        for (int i = 100; i < 120; i++){
            User user = new User();
            user.setName("User " + i);
            user.setRole(UserRole.ADMIN);
            user.setRating(rating++);
            user.setAddress("Address " + i);
            user.setAddress("Kharkiv Klochkivska street 23");
            user.setId(i);
            databaseReference.child("riffusers").child(String.valueOf(user.getId())).setValue(user);
            if (rating == 5){
                rating = 1;
            }
        }



        databaseReference.child("ruslan").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        findViewById(R.id.curstomview).setOnClickListener((view) -> {
            ((ImageView)view.findViewById(R.id.imageView2)).setImageResource(android.R.color.holo_blue_dark);
        });
    }
}
