package com.example.user.myradio.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.myradio.R;
import com.example.user.myradio.fragments.DetailsFragment;
import com.example.user.myradio.fragments.MainFragment;
import com.example.user.myradio.model.Station;

public class MainActivity extends AppCompatActivity {

    private static MainActivity mainActivity;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.setMainActivity(this);

        FragmentManager fm = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment)fm.findFragmentById(R.id.container_main);

        if(mainFragment == null)
        {
            mainFragment = MainFragment.newInstance("abb", "bbc");
            fm.beginTransaction().add(R.id.container_main, mainFragment).commit();
        }
    }
    public void loadDetailsScreen(Station selectedStation)
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new DetailsFragment()).addToBackStack(null).commit();
    }
}