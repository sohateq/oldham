package com.example.a1.myapplication.item;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.a1.myapplication.R;


public class FragmentActivity extends AppCompatActivity {
    int items;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        //кнопка назад
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        items = intent.getIntExtra("items", -1);
        position = intent.getIntExtra("position", -1);



        ItemFragment itemFragment = new ItemFragment();
        itemFragment.setItem(items);
        itemFragment.setPosition(position);
// Устанавливаем то упражнение, которое хотим показать
        //       detailFragment.setWorkout( 1 );
// Начинаем транзакцию Fragment через Support FragmentManager
// (класс, который управляет созданием и хранением Fragment в
        //      системе)
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
// Указываем, какой фрагмент и в какой контейнер хотим поместить
        transaction.add(R.id.fragment_test, itemFragment);
// Запускаем транзакцию (остальное берет на себя система)
        transaction.commit(); }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    }

