package com.example.a1.myapplication.item;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.a1.myapplication.KatalogActivity;
import com.example.a1.myapplication.R;

public class ItemsActivity extends AppCompatActivity {

        int items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        Intent intent = getIntent();
        items = intent.getIntExtra("items", -1);
//        String itemsNumber = String.format("items%d", "0");
        ListView itemsListView = (ListView) findViewById(R.id.items_list_view);
        String[] array = getResources().getStringArray(R.array.items0);
        switch (items) {
            case 0:
                array = getResources().getStringArray(R.array.items0);
//                startFragment();
                break;
            case 1:
                array = getResources().getStringArray(R.array.items1);
//                System.out.println(array);
                break;
            case 2:
                array = getResources().getStringArray(R.array.items2);
                break;
            case 3:
                array = getResources().getStringArray(R.array.items3);
                break;
            case 4:
                array = getResources().getStringArray(R.array.items4);
                break;
            case 5:
                array = getResources().getStringArray(R.array.items5);
                break;
            case 6:
                array = getResources().getStringArray(R.array.items6);
                break;
            case 7:
                array = getResources().getStringArray(R.array.items7);
                break;
            case 8:
                array = getResources().getStringArray(R.array.items8);
                break;
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        itemsListView.setAdapter(adapter);
        itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ItemsActivity.this, FragmentActivity.class);
                intent.putExtra("items", items);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });


    }

    public void startFragment() {

        Intent intent = new Intent(ItemsActivity.this, FragmentActivity.class);
        //intent.putExtra("items", position);
        startActivity(intent);

        //findViewById(R.id.items_list_view).setVisibility(View.INVISIBLE);
// Инстантиируем Fragment
//        ItemFragment itemFragment = new ItemFragment();
//// Устанавливаем то упражнение, которое хотим показать
// //       detailFragment.setWorkout( 1 );
//// Начинаем транзакцию Fragment через Support FragmentManager
//// (класс, который управляет созданием и хранением Fragment в
// //      системе)
//        FragmentTransaction transaction =
//                getSupportFragmentManager().beginTransaction();
//// Указываем, какой фрагмент и в какой контейнер хотим поместить
//        transaction.add(R.id.test, itemFragment);
//// Запускаем транзакцию (остальное берет на себя система)
//        transaction.commit(); }
    }
}

