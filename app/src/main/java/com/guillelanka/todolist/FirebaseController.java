package com.guillelanka.todolist;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.UUID;

public class FirebaseController {

    static private final String DATABASE_NAME = "https://chat-b1b1d-default-rtdb.europe-west1.firebasedatabase.app/";
    static private final FirebaseDatabase database = FirebaseDatabase.getInstance(DATABASE_NAME);
    static private final DatabaseReference databaseRoot = database.getReference("ToDoList");

    public static void addList(Usuario usuario, List<Lista> lista){
        databaseRoot.child(usuario.userKey).child("Listas").push().setValue(lista);
    }
    public static void addTask(Usuario usuario, String key, List<Tarea> listaTarea){
        databaseRoot.child(usuario.userKey).child("Listas").child(key).setValue(listaTarea);
    }

    public static DatabaseReference getDatabaseRoot() {
        return databaseRoot;
    }
}
