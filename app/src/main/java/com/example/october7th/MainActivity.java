package com.example.october7th;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    Switch swVerity;
    TextView tvUserName;
    Button btnSendMessage;
    Button btnFollow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        swVerity = findViewById(R.id.Verity);
        swVerity.setOnCheckedChangeListener(this);
        tvUserName = findViewById(R.id.tvUserName);
        btnSendMessage = findViewById(R.id.btnSendMessage);
        btnFollow = findViewById(R.id.btnFollow);

        btnSendMessage.setOnClickListener(this);
        btnFollow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSendMessage) {
            Toast.makeText(this, R.string.opening_chat, Toast.LENGTH_SHORT).show();
        }

        if (v.getId() == R.id.btnFollow) {
            Toast.makeText(this, R.string.started_following, Toast.LENGTH_SHORT).show();
            btnFollow.setText(R.string.following);
        }

    }

    @Override
    public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
        btnSendMessage.setVisibility(INVISIBLE);

        if(b){
            btnSendMessage.setVisibility(VISIBLE);
            Toast.makeText(this, "true", Toast.LENGTH_SHORT).show();
        }
        else{
            btnSendMessage.setVisibility(INVISIBLE);
            Toast.makeText(this, "false", Toast.LENGTH_SHORT).show();
        }
    }
}