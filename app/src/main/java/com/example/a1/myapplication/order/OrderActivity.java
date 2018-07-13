package com.example.a1.myapplication.order;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.a1.myapplication.R;
import com.example.a1.myapplication.mailSender.GMailSender;

public class OrderActivity extends AppCompatActivity implements View.OnFocusChangeListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //кнопка назад
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        //очищаем все текстовые поля при нажатии
        EditText editTextName = findViewById(R.id.edit_text_name);
        EditText editTextPhone = findViewById(R.id.edit_text_phone);
        EditText editTextMail = findViewById(R.id.edit_text_mail);
        EditText editTextCommentary = findViewById(R.id.edit_text_commentary);
//        editTextName.setOnClickListener(this);
//        editTextPhone.setOnClickListener(this);
//        editTextMail.setOnClickListener(this);
//        editTextCommentary.setOnClickListener(this);
        editTextName.setOnFocusChangeListener(this);
        editTextPhone.setOnFocusChangeListener(this);
        editTextMail.setOnFocusChangeListener(this);
        editTextCommentary.setOnFocusChangeListener(this);

        Button button = findViewById(R.id.button_order);
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

//    @Override
//    public void onClick(View view) {
//        //System.out.println("3bs");
//       EditText editText = (EditText) view;
//        if (editText.getText().toString().equals(getString(R.string.name)) | editText.getText().toString().equals(getString(R.string.phone))
//                | editText.getText().toString().equals(getString(R.string.mail)) |editText.getText().toString().equals(getString(R.string.commentary))){
//            ((EditText) view).setText("");
//
//
//        }
//    }


    @Override
    public void onFocusChange(View view, boolean b) {
        if (b) {
            EditText editText = (EditText) view;
            if (editText.getText().toString().equals(getString(R.string.name)) | editText.getText().toString().equals(getString(R.string.phone))
                    | editText.getText().toString().equals(getString(R.string.mail)) | editText.getText().toString().equals(getString(R.string.commentary))) {
                ((EditText) view).setText("");


            }
        }
    }
    //boolean mailOk = false;

//    public void mailOk(Boolean state){
//        mailOk = state;
//    }


    @Override
    public void onClick(View view) {

        final EditText editTextName = findViewById(R.id.edit_text_name);
        final EditText editTextPhone = findViewById(R.id.edit_text_phone);
        final EditText editTextMail = findViewById(R.id.edit_text_mail);
        final EditText editTextCommentary = findViewById(R.id.edit_text_commentary);
        final ProgressBar progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);
        //mailOk = false;

        if (!hasConnection(this)){
            progressBar.setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(), "Ошибка, проверьте подключение", Toast.LENGTH_LONG).show();
            return;
        }

        final Handler myHandler = new Handler();


        new Thread(new Runnable() {

            public void run() {



                try {

                    GMailSender sender = new GMailSender(

                            "oldham.mobileapp@gmail.com",

                            "OldhamNumberOne2018");


                    //sender.addAttachment(Environment.getExternalStorageDirectory().getPath()+"/image.jpg");

                    sender.sendMail("Заказ из мобильного приложения", "Информация по заказу\nИмя: " + editTextName.getText().toString()
                                    + "\nТелефон: " + editTextPhone.getText().toString() + "\nПочта: " + editTextMail.getText().toString() +
                                    "\nЗаказ: " + editTextCommentary.getText().toString(),

                            "oldham.mobileapp@gmail.com",

                            "sohateq34@gmail.com");
                    myHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            editTextName.setText("");
                            editTextPhone.setText("");
                            editTextMail.setText("");
                            editTextCommentary.setText("");
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(getApplicationContext(), "Заказ отправлен!", Toast.LENGTH_LONG).show();

                        }
                    });

                    //mailOk = true;


                } catch (Exception e) {

                    myHandler.post(new Runnable() {
                        @Override
                        public void run() {

                           //progressBar.setVisibility(View.INVISIBLE);
                            //Toast.makeText(getApplicationContext(), "Ошибка, проверьте подключение", Toast.LENGTH_LONG).show();
                        }
                    });


                }


                //Toast.makeText(getApplicationContext(),"Заказ успешно отправлен!",Toast.LENGTH_LONG).show();
                //finishActivity(1);


            }

        }).start();

//        if (mailOk) {
//            editTextName.setText("");
//            editTextPhone.setText("");
//            editTextMail.setText("");
//            editTextCommentary.setText("");
//        } else{
//            Toast.makeText(getApplicationContext(),"Ошибка",Toast.LENGTH_LONG).show();
//        }

    }

    public static boolean hasConnection(final Context context)
    {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        wifiInfo = cm.getActiveNetworkInfo();
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        return false;
    }

}
