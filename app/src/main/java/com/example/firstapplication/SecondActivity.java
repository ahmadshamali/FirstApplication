package com.example.firstapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private TextView tvName, tvPrice, tvBrand, tvSeats, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();

        String name = getIntent().getStringExtra("name");
        double price = getIntent().getDoubleExtra("price", 0);
        String brand = getIntent().getStringExtra("brand");
        int seats = getIntent().getIntExtra("seats", 0);
        String description = getIntent().getStringExtra("description");

        tvName.setText(name);
        tvPrice.setText("Price: $" + price);
        tvBrand.setText("Brand " + brand);
        tvSeats.setText(seats + " Seats");
        tvDescription.setText(description);
    }

    private void initViews() {
        tvName = findViewById(R.id.tvName);
        tvPrice = findViewById(R.id.tvPrice);
        tvBrand = findViewById(R.id.tvBrand);
        tvSeats = findViewById(R.id.tvSeats);
        tvDescription = findViewById(R.id.tvDescription);
    }
}