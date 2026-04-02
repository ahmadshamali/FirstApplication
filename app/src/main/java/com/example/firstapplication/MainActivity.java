package com.example.firstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.firstapplication.dataaccess.Car;
import com.example.firstapplication.dataaccess.CarDA;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listViewCars;
    private EditText etMaxPrice, etSeats;
    private Button btnFilter;
    private List<Car> originalCars, filteredCars;
    private ArrayAdapter<Car> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //code here
        initViews();

        CarDA da = new CarDA();

        originalCars = da.getCars();
        filteredCars = new ArrayList<Car>(originalCars);

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, filteredCars);

        listViewCars.setAdapter(adapter);

        listViewCars.setOnItemClickListener((parent, view, position, id) -> {

            Car selectedCar = filteredCars.get(position);

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("name", selectedCar.getName());
            intent.putExtra("brand", selectedCar.getBrand());
            intent.putExtra("price", selectedCar.getPrice());
            intent.putExtra("seats", selectedCar.getSeats());
            intent.putExtra("description", selectedCar.getDescription());

            startActivity(intent);
        });


        btnFilter.setOnClickListener(v -> applyFilter());
    }

    private void initViews() {
        listViewCars = findViewById(R.id.listViewCars);
        etMaxPrice = findViewById(R.id.etMaxPrice);
        etSeats = findViewById(R.id.etSeats);
        btnFilter = findViewById(R.id.btnFilter);
    }

    private void applyFilter() {
        String maxPriceText = etMaxPrice.getText().toString().trim();
        String seatsText = etSeats.getText().toString().trim();
        etMaxPrice.getText().clear();
        etSeats.getText().clear();
        filteredCars.clear();

        Double maxPrice = null;
        Integer seats = null;

        if (!maxPriceText.isEmpty()) {
            maxPrice = Double.parseDouble(maxPriceText);
//            priceFilter=true;
        }
        if (!seatsText.isEmpty()) {
            seats = Integer.parseInt(seatsText);
//            seatFilter =true;
        }

        for (Car car : originalCars) {
            boolean priceFilter = true;
            boolean seatFilter = true;

            if (maxPrice != null) {
                if (car.getPrice() > maxPrice) {
                    priceFilter = false;
                }
            }
            if (seats != null) {
                if (car.getSeats() != seats) {
                    seatFilter = false;
                }
            }

            if (seatFilter && priceFilter) {
                filteredCars.add(car);
            }


        }
        adapter.notifyDataSetChanged();
    }
}