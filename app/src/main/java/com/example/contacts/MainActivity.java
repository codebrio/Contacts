package com.example.contacts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.contacts.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //To assign them id
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        //declare fragments
        final Home home = new Home();
        final Contact contact = new Contact();
        final Profile profile = new Profile();
        //onclick
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //if-else  condition
                int id = menuItem.getItemId ();
                if (id == R.id.home) {
                    setFragment ( home );
                    return true;
                } else if (id == R.id.Contact) {
                    setFragment ( contact );
                    return true;
                } else if (id == R.id.profile) {
                    setFragment ( profile );
                    return true;
                }
                return false;
            }

        });

    }
    //frame layout code
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }
}
