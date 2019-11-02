package com.example.mobdevfinalappmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ActivityA extends AppCompatActivity {
    ArrayList<Song> image_details;
    ListView listView;
    customlayout adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image_details = getListData();

        AppContext.getInstance().setSongsList(image_details);

        listView = (ListView) findViewById(R.id.listView);
        adapter = new customlayout(this, image_details);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AppContext.getInstance().setIndex(position);
                Intent intent = new Intent(ActivityA.this, ActivitySong.class);
                startActivity(intent);
            }
        });


    }



    private  ArrayList<Song> getListData() {
        ArrayList<Song> list = new ArrayList<Song>();
            Song Bai1 = new Song("Krazy", "Binz", R.drawable.krazy, R.raw.krazy);
            list.add(Bai1);
            Song Bai2 = new Song("Nen va Hoa", "Rhymastic", R.drawable.nen_va_hoa, R.raw.nen_va_hoa);
            list.add(Bai2);
            Song Bai3 = new Song("Simple love", "Obito ft.Seachains", R.drawable.obito, R.raw.simple_love);
            list.add(Bai3);
            Song Bai4 = new Song("Het thuong can nho", "Duc Phuc", R.drawable.ducphuc, R.raw.het_thuong_can_nho_duc_phuc);
            list.add(Bai4);
            Song Bai5 = new Song("La ban khong the yeu", "Lou Hoang", R.drawable.lou, R.raw.la_ban);
            list.add(Bai5);
            Song Bai6 = new Song("Quen anh di", "Binz ft.SlimV", R.drawable.binz2, R.raw.quen_anh_di);
            list.add(Bai6);
            Song Bai7 = new Song("SOFAR", "Binz", R.drawable.binz, R.raw.sofar);
            list.add(Bai7);
            Song Bai8= new Song("Treasure", "Rhymastics", R.drawable.rhy1, R.raw.treasure);
            list.add(Bai8);
            Song Bai9 = new Song("Yeu nhu tre con", "B Ray", R.drawable.bray1, R.raw.yeu_nhu_tre_con);
            list.add(Bai9);

        return list;
    }
}
