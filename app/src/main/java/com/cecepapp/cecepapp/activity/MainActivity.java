package com.cecepapp.cecepapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.cecepapp.cecepapp.R;
import com.cecepapp.cecepapp.fragment.AboutFragment;
import com.cecepapp.cecepapp.fragment.ContactFragment;
import com.cecepapp.cecepapp.fragment.FriendsFragment;
import com.cecepapp.cecepapp.preference.UserPreferences;

import static com.cecepapp.cecepapp.fragment.ProfileFragment.newInstance;



public class MainActivity extends AppCompatActivity {

    private boolean gantiFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();
        return true;
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.profile:
                    gantiFragment(newInstance());
                    return true;
                case R.id.contact:
                    gantiFragment(ContactFragment.newInstance());
                    return true;
                case R.id.friends:
                    gantiFragment(FriendsFragment.newInstance());
                    return true;
                case R.id.about:
                    gantiFragment(AboutFragment.newInstance());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setLogo(R.drawable.pratoms);
        }

        if (savedInstanceState == null) {
            gantiFragment(newInstance());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.logout) {
            UserPreferences.clearLoggedInUser(getBaseContext());
            startActivity(new Intent(getBaseContext(), LoginActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
