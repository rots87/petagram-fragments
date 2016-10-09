package com.leonetardo.petagram;

import android.content.Intent;

import com.leonetardo.petagram.adapter.PageAdapter;
import com.leonetardo.petagram.fragment.PerfilFragment;
import com.leonetardo.petagram.fragment.RecyclerViewMainFragment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verFavoritas();
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        //esto es para que el action bar que tengo hecho se vea bien en todas las pantallas
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    //Este metodo va a inflar (mostrar) en la vista el menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    //este metodo define qué es lo que sucede cuando aprieto alguna de las opciones del menú de opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // el item es la opcion presionada que me llega aca
        switch (item.getItemId()) {
            case R.id.mContacto:
                Intent intent = new Intent(this, ActivityContacto.class);
                startActivity(intent);
                break;
            case R.id.mAcercaDe:
                Intent intent2 = new Intent(this, ActivityAcercaDe.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewMainFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.pet);
    }

    public void verFavoritas(){
        FloatingActionButton estrella = (FloatingActionButton) findViewById(R.id.btnEstrella);
        estrella.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Favoritas.class);
                startActivity(intent);
            }
        });
    }

}
