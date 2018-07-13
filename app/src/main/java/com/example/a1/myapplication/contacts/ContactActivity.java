package com.example.a1.myapplication.contacts;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.util.Linkify;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a1.myapplication.R;

import org.w3c.dom.Text;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        //кнопка назад
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        //для Москвы
        TextView textView = findViewById(R.id.moscow_text_view);
        textView.setText(Html.fromHtml(getString(R.string.moscow_contacts)));
        //textView.setText(getString(R.string.contacts1));
        Linkify.addLinks(textView, Linkify.ALL);
        Button button = findViewById(R.id.moscow_button);
        button.setOnClickListener(this);

        //для Спб
        textView = findViewById(R.id.spb_text_view);
        textView.setText(Html.fromHtml(getString(R.string.spb_contacts)));
        //textView.setText(getString(R.string.contacts1));
        Linkify.addLinks(textView, Linkify.ALL);
        button = findViewById(R.id.spb_button);
        button.setOnClickListener(this);

        //для Нижнего
        textView = findViewById(R.id.nishnii_text_view);
        textView.setText(Html.fromHtml(getString(R.string.nishnii_contacts)));
        //textView.setText(getString(R.string.contacts1));
        Linkify.addLinks(textView, Linkify.ALL);
        button = findViewById(R.id.nishnii_button);
        button.setOnClickListener(this);

        //для Екб
        textView = findViewById(R.id.ekb_text_view);
        textView.setText(Html.fromHtml(getString(R.string.ekb_contacts)));
        //textView.setText(getString(R.string.contacts1));
        Linkify.addLinks(textView, Linkify.ALL);
        button = findViewById(R.id.ekb_button);
        button.setOnClickListener(this);

        //для Новосибирска
        textView = findViewById(R.id.novosib_text_view);
        textView.setText(Html.fromHtml(getString(R.string.novosib_contacts)));
        //textView.setText(getString(R.string.contacts1));
        Linkify.addLinks(textView, Linkify.ALL);
        button = findViewById(R.id.novosib_button);
        button.setOnClickListener(this);




    }

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

    @Override
    public void onClick(View view) {
        String geoURI;
        Uri geo;
        Intent geoIntent;

        if (view.getId() == R.id.moscow_button) {
            //System.out.println("Всё ок");
            geoURI = "geo:0,0?q=55.774224, 37.532078";
            geo = Uri.parse(geoURI);
            geoIntent = new Intent(Intent.ACTION_VIEW, geo);

            if (geoIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(geoIntent);
            }
        }else if (view.getId() == R.id.spb_button) {
                geoURI = "geo:0,0?q=192029, г. Санкт-Петербург, Большой Смоленский пр-т, 2";
                geo = Uri.parse(geoURI);
                geoIntent = new Intent(Intent.ACTION_VIEW, geo);

                if (geoIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(geoIntent);
                }
            }
            else if (view.getId() == R.id.nishnii_button) {
                geoURI = "geo:0,0?q=603024, г. Нижний Новгород, Ул. Полтавская д.22 офис 410";
                geo = Uri.parse(geoURI);
                geoIntent = new Intent(Intent.ACTION_VIEW, geo);

                if (geoIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(geoIntent);
                }
            }
            else if (view.getId() == R.id.ekb_button) {
                geoURI = "geo:0,0?q=620100, г. Екатеринбург, ул. Сибирский тракт, д.12 корпус 3, офис 215";
                geo = Uri.parse(geoURI);
                geoIntent = new Intent(Intent.ACTION_VIEW, geo);

                if (geoIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(geoIntent);
                }
            }
            else if (view.getId() == R.id.novosib_button) {
                geoURI = "geo:0,0?q=630047, г. Новосибирск, ул. Северная 4, а/я 115";
                geo = Uri.parse(geoURI);
                geoIntent = new Intent(Intent.ACTION_VIEW, geo);

                if (geoIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(geoIntent);
                }
            }

    }
}
