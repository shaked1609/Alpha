package com.example.alpha1;
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Environment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import static com.example.alpha1.FBref.refAuth;


public class Main4Activity extends AppCompatActivity {
    private EditText myEditText;
String em,ph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        refAuth = FirebaseAuth.getInstance();
        myEditText = findViewById(R.id.editText);
        ActivityCompat.requestPermissions(Main4Activity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)


    public void createMyPDF(View view){
        super.onStart();
        FirebaseUser user=refAuth.getCurrentUser();
        em=user.getEmail();
        ph=user.getPhoneNumber();

        PdfDocument myPdfDocument = new PdfDocument();
        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(300,600,1).create();
        PdfDocument.Page myPage = myPdfDocument.startPage(myPageInfo);
        Paint myPaint = new Paint();
        String myString =ph+""+em;
        int x = 10, y=25;
        myPage.getCanvas().drawText(myString,x,y,myPaint);

        myPdfDocument.finishPage( myPage );


        String myFilePath = Environment.getExternalStorageDirectory().getPath() + "/myPDFFile.pdf";
        File myFile = new File(myFilePath);
        try {
            myPdfDocument.writeTo(new FileOutputStream(myFile));
        }
        catch (Exception e){
            e.printStackTrace();
            myEditText.setText("ERROR");
        }

        myPdfDocument.close();
    }
}