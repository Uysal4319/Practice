package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,EditText.OnEditorActionListener{
    TextView tv;
    TextView tvKarekterOzellikleri;
    int sayac=0;

    Button bSaldir;
    Button bYemek;
    Button bUyu;
    Karakter k;

    EditText isim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("mesaj","create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            k=savedInstanceState.getParcelable("karakter");
        }else {
            k =new Karakter();
            k.hareketSayisi=10;
            k.kilo=10;
            k.saldiriGucu=100;
        }

        tv = (TextView) findViewById(R.id.cevap);
        tvKarekterOzellikleri =(TextView)findViewById(R.id.bilmece);

        bSaldir = (Button) findViewById(R.id.saldir);
        bYemek = (Button) findViewById(R.id.yemek);
        bUyu = (Button) findViewById(R.id.uyu);

        bSaldir.setOnClickListener(this);
        bYemek.setOnClickListener(this);
        bUyu.setOnClickListener(this);


        tvKarekterOzellikleri.setText(k.toString());
        tv.setText("Oyuna hosgeldiniz, lütfen bir karakter seciniz");

        isim = (EditText) findViewById(R.id.editText2);
        isim.setOnEditorActionListener(this);



    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("mesaj","start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("mesaj","stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("mesaj","destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("mesaj","pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("mesaj","pause");
    }

    @Override
    public boolean onEditorAction(TextView tv2 , int x, KeyEvent ke){
       tv.setText("Karakterin ismi : "+ isim.getText());
       k.isim=(String) isim.getText().toString();
       isim.setVisibility(View.INVISIBLE);
       tvKarekterOzellikleri.setText(k.toString());
       tvKarekterOzellikleri.setVisibility(View.VISIBLE);

        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==bSaldir.getId())
            tv.setText(k.savas());
        else if(v.getId()==bYemek.getId())
            tv.setText(k.yemek());
        else if(v.getId()==bUyu.getId())
            tv.setText(k.uyumak());

        tvKarekterOzellikleri.setText(k.toString());
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putString("anahtar","deger");
        outState.putParcelable("karakter",k);
    }
}
