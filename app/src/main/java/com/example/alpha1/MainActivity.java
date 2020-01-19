package com.example.alpha1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2,et3;
    Button btn;
    String st1;
    String st2;
String phone,email,name;
member ber;
DatabaseReference reff;
public FirebaseAuth refAuth = FirebaseAuth.getInstance();
    Intent t;
    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        btn= (Button)findViewById(R.id.button);
        et1=(EditText) findViewById( R.id.et1 );
        et2=(EditText)findViewById(R.id.et2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void getdata (View view){
         st1 = et1.getText().toString();
         st2 = et2.getText().toString();

        Toast.makeText( this,st1+st2,Toast.LENGTH_SHORT).show();
        refAuth.createUserWithEmailAndPassword( st1,st2).addOnCompleteListener( this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d( "email pass", "creaUserWithEmail : success" );
                    FirebaseUser user = refAuth.getCurrentUser();
                } else {
                    Toast.makeText( MainActivity.this, "Auth failed",
                            Toast.LENGTH_SHORT ).show();
                    Log.w( "MainActivity", "createUserWithEmail : failed", task.getException() );
                }
            }

        } );

        }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String s= item.getTitle().toString();
        t=new Intent(this, MainActivity.class);
        if (s.equals("LogIn")){
            t=new Intent(this, MainActivity.class);
            startActivity(t);}

        if (s.equals("List")){
            t=new Intent(this, Main2Activity.class);
            startActivity(t);
        }
        if (s.equals("gallery")){
            t=new Intent(this, Main3Activity.class);
            startActivity(t);
        }
        if (s.equals("pdf")){
            t=new Intent(this, Main4Activity.class);
            startActivity(t);
        }
        return super.onOptionsItemSelected(item);
    }




}
