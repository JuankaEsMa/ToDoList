package com.guillelanka.todolist;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
import java.util.UUID;

public class FirebaseController {

    static private final String DATABASE_NAME = "https://chat-b1b1d-default-rtdb.europe-west1.firebasedatabase.app/";
    static private final FirebaseDatabase database = FirebaseDatabase.getInstance(DATABASE_NAME);
    static private final DatabaseReference databaseRoot = database.getReference("ToDoList");

    public void start(Context context){

    }

    public static void addList(Usuario usuario, List<String> lista){
        databaseRoot.child(usuario.userKey).setValue(lista);
    }
    public static void addTask(Usuario usuario, int posicion, List<String> listaTarea){
        databaseRoot.child(usuario.userKey).child(posicion+"").setValue(listaTarea);
    }




}
