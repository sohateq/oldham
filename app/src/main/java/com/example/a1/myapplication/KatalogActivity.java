package com.example.a1.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.a1.myapplication.item.ItemsActivity;

public class KatalogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katalog);
        //getResources().getStringArray(R.array.groups);

        ListView katalogListView = (ListView) findViewById(R.id.katalog_list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.groups));
        katalogListView.setAdapter(adapter);
        katalogListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //System.out.println(position);
                Intent intent = new Intent(KatalogActivity.this, ItemsActivity.class);
                intent.putExtra("items", position);
                startActivity(intent);


            }
        });
   }
}
