package com.example.android.jokedisplay;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android.jokedisplay.databinding.ActivityJokeDisplayBinding;

public class JokeDisplayActivity extends AppCompatActivity {

    private ActivityJokeDisplayBinding binding;
    public static final String EXTRA_JOKE = "JokeDisplayActivity.EXTRA_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_joke_display);

        getIntentData();
    }

    private void getIntentData() {
        Intent intent = getIntent();
        if (intent != null && intent.getStringExtra(EXTRA_JOKE) != null) {
            String joke = intent.getStringExtra(EXTRA_JOKE);
            binding.jokeTextView.setText(joke);
        } else {
            Toast.makeText(this, R.string.no_joke_provided, Toast.LENGTH_SHORT).show();
        }
    }
}
