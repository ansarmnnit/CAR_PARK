package com.example.ansar.carpark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LocationListActivity extends AppCompatActivity {

    private EditText searchview;
    private Button searchbutton;
    private RecyclerView list;
    private LocationListAdapter locationListAdapter;
    private List<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);
        searchview=(EditText)findViewById(R.id.search_view);
        searchbutton=(Button)findViewById(R.id.search_btn);
        list=(RecyclerView)findViewById(R.id.list_view);

        list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        list.setHasFixedSize(true);


        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });
    }

    private List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("jaipur");
        list.add("jaipur");
        list.add("jaipur");
        list.add("jaipur");
        list.add("jaipur");
        list.add("jaipur");
        list.add("jaipur");
        list.add("jaipur");

        return list;
    }
    private void search()
    {
        String cityname=searchview.getText().toString();


        if(!cityname.equals(""))
        {
            items = getList();
            locationListAdapter = new LocationListAdapter(this, items, new ListItemClick());
            list.setAdapter(locationListAdapter);
        }
        else
        {
            Toast.makeText(this, "please enter city name", Toast.LENGTH_SHORT).show();
        }
    }

    class ListItemClick implements LocationListAdapter.ItemClickListener {

        @Override
        public void onItemClick(String location) {
            Intent intent = new Intent(LocationListActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

}
