package com.example.send_data_from_fragment_to_another_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, new TV_Fragment())
                .commit();

    }

    @Override
    public void onItemClicked(Name name) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, MainFragment.newInstance(name.getName())).commit();
    }
}