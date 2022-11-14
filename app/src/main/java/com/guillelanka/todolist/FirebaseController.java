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

    public static DatabaseReference getDatabaseRoot() {
        return databaseRoot;
    }

    public void start(Context context){

    }

    public static void addList(Usuario usuario, List<Lista> lista){
        databaseRoot.child(usuario.userKey).setValue(lista);
    }
    public static void addTask(Usuario usuario, String nombreLista, List<Tarea> listaTarea){
        databaseRoot.child(usuario.userKey).child(nombreLista).setValue(listaTarea);
    }




}
