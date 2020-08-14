package com.example.android.notes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, myToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_closed
        );
        if(drawer!=null){
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if(navigationView!=null){
            navigationView.setNavigationItemSelectedListener(this);
        }

        ArrayList<NotePreview> previews = new ArrayList<>();
        previews.add(new NotePreview("Lores ipsum dores sit amet Lores ipsum dores sit amet Lores ipsum dores sit amet ","8 jul 2020"));
        previews.add(new NotePreview("Lores ipsum dores sit amet Lores ipsum dores sit amet Lores ipsum dores sit amet ","8 jul 2020"));
        previews.add(new NotePreview("Lores ipsum dores sit amet Lores ipsum dores sit amet Lores ipsum dores sit amet ","8 jul 2020"));
        previews.add(new NotePreview("Lores ipsum dores sit amet Lores ipsum dores sit amet Lores ipsum dores sit amet ","8 jul 2020"));
        previews.add(new NotePreview("Lores ipsum dores sit amet Lores ipsum dores sit amet Lores ipsum dores sit amet ","8 jul 2020"));
        previews.add(new NotePreview("Lores ipsum dores sit amet Lores ipsum dores sit amet Lores ipsum dores sit amet ","8 jul 2020"));
        previews.add(new NotePreview("Lores ipsum dores sit amet Lores ipsum dores sit amet Lores ipsum dores sit amet ","8 jul 2020"));
        previews.add(new NotePreview("Lores ipsum dores sit amet Lores ipsum dores sit amet Lores ipsum dores sit amet ","8 jul 2020"));
        previews.add(new NotePreview("Lores ipsum dores sit amet Lores ipsum dores sit amet Lores ipsum dores sit amet ","8 jul 2020"));
        previews.add(new NotePreview("Lores ipsum dores sit amet Lores ipsum dores sit amet Lores ipsum dores sit amet ","8 jul 2020"));
        previews.add(new NotePreview("Lores ipsum dores sit amet Lores ipsum dores sit amet Lores ipsum dores sit amet ","8 jul 2020"));

        NotePreviewAdapter adapter = new NotePreviewAdapter(this,previews);
        RecyclerView previewList = findViewById(R.id.preview_list);
        previewList.setAdapter(adapter);
        previewList.setLayoutManager(new LinearLayoutManager(this));

    }

    public void onFabClicked(View view) {
        Intent i = new Intent(this,AddNoteActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.search_icon) {
            return true;
        }

        if (item.getItemId() == R.id.edit_icon) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

}
