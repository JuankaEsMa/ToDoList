package com.guillelanka.todolist;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.guillelanka.todolist.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    Usuario usuario;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPref = this.getSharedPreferences(
                this.getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        if(sharedPref.getString(this.getString(R.string.userKey),"").equals("")){
            editor = sharedPref.edit();
            String userKey = UUID.randomUUID().toString();
            editor.putString(this.getString(R.string.userKey),userKey);
            editor.apply();
        }else {
            Toast.makeText(this,getString(R.string.userKey),Toast.LENGTH_LONG).show();
        }
        usuario = new Usuario(sharedPref.getString(this.getString(R.string.userKey),"fallo"));

        List<Tarea> listaTareas = new ArrayList<>();
        Tarea newTarea = new Tarea("baguet");
        List<Lista> listaListas = new ArrayList<>();
        //FirebaseController.addTask(usuario,1, listaTareas);

        listaTareas.add(newTarea);

        Lista newLista = new Lista("Panes", listaTareas);
        //FirebaseController.addList(usuario,listaListas);
        FirebaseController.addTask(usuario,"Cacahuete",listaTareas);


        FirebaseController.getDatabaseRoot().child(usuario.userKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Tarea> listaListas = new ArrayList<Tarea>();
                for (DataSnapshot item: dataSnapshot.getChildren()
                     ) {
                    Tarea tarea = new Tarea();


                    Toast.makeText(getApplicationContext(),tarea.toString(),Toast.LENGTH_LONG).show();
                    //Lista lista = item.getValue(Lista.class);
                    //Log.i("item", lista.toString());
                    //listaListas.add(lista);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.btAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MainActivity.this, PopUpTask.class);
                startActivity(intent);
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}