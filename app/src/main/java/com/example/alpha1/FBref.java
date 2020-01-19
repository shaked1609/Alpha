package com.example.alpha1;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FBref {
    public static FirebaseAuth refAuth=FirebaseAuth.getInstance();


    public static FirebaseDatabase FBDB = FirebaseDatabase.getInstance();
    public static DatabaseReference refmember=FBDB.getReference("members");
    public static FirebaseStorage FBST = FirebaseStorage.getInstance();
    public static StorageReference refStor=FBST.getReference();
    public static StorageReference refm=refStor.child("Images");
    public static StorageReference mStorageRef = FBST.getReference();



}