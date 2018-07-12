package com.example.a1.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.a1.myapplication.contacts.ContactActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mainListView = (ListView) findViewById(R.id.main_list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.main_array));
        mainListView.setAdapter(adapter);
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent;

                switch (position) {
                    case 0:
                        intent = new Intent(MainActivity.this, KatalogActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        System.out.println("kfl");
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, ContactActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
//        switch (view) {
//            case view.get
//        }
    }

//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        switch(position) {
//            case 0:
//                System.out.println("Catalog");
//                break;
//            case 1:
//                System.out.println("40-to  tam");
//                break;
//        }
//    }

}
