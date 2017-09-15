package com.example.admin.w3test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AddCar.OnFragmentInteractionListener, CarFragment.OnListFragmentInteractionListener {

    List<Car> cars;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cars = new ArrayList<>();
        AddCar addCar = AddCar.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.flAddCar,addCar).commit();
        CarFragment carFragment = CarFragment.newInstance(1, cars);
        getSupportFragmentManager().beginTransaction().replace(R.id.flCarList,carFragment).commit();
    }

    @Override
    public void onFragmentInteraction(String model, String type, String year) {
        cars.add(new Car(model,type,year));
        Toast.makeText(this, "car added", Toast.LENGTH_SHORT).show();
        CarFragment carFragment = CarFragment.newInstance(1, cars);
        getSupportFragmentManager().beginTransaction().replace(R.id.flCarList,carFragment).commit();
    }

    @Override
    public void onListFragmentInteraction(Car item) {

    }
}
