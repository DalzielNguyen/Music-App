package com.example.mobdevfinalappmusic;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class ActivitySong extends AppCompatActivity {
    TextView textviewTitle,time_start, time_end, Singer;
    SeekBar seek_bar;
    ImageButton btnNext, btnPlay, btnPrevious;
    ImageView imgSong;
//    btnRandom, btnRepeat;

    ArrayList<Song> arraySong = AppContext.getInstance().getSongsList();
    int position =AppContext.getInstance().getIndex();
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        CreateAll();
        //AddSong();
        CreateMediaPlayer();
        mediaPlayer.start();
        btnPlay.setImageResource(R.drawable.pause);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.play);
                }

                else{
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.pause);
                }

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()){
                    btnPlay.setImageResource(R.drawable.pause);
                }
                mediaPlayer.stop();
                mediaPlayer.release();
                if (position == arraySong.size() - 1) {
                    position = 0;
                }
                else{
                    position ++;
                }
                CreateMediaPlayer();
                mediaPlayer.start();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()){
                    btnPlay.setImageResource(R.drawable.pause);
                }
                mediaPlayer.stop();
                mediaPlayer.release();
                if(position == 0)
                    position = arraySong.size()-1;
                else
                    position--;
                CreateMediaPlayer();
                mediaPlayer.start();
            }
        });
        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seek_bar.getProgress());
            }
        });

    }

    private void UpdateTimeSong (){


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat SetTime = new SimpleDateFormat("mm:ss");
                time_start.setText(SetTime.format(mediaPlayer.getCurrentPosition()));
                seek_bar.setProgress(mediaPlayer.getCurrentPosition());
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        if (!mediaPlayer.isPlaying()) {
                            btnPlay.setImageResource(R.drawable.pause);
                        }
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        if (position == arraySong.size() - 1) {
                            position = 0;
                        } else {
                            position++;
                        }
                        CreateMediaPlayer();
                        mediaPlayer.start();
                    }
                });
                handler.postDelayed(this,500);
            }
        },100);
    }

    private void SetTimeTotal (){
        SimpleDateFormat time_format = new SimpleDateFormat("mm:ss");
        time_end.setText(time_format.format(mediaPlayer.getDuration()));
        seek_bar.setMax(mediaPlayer.getDuration());
    }

    private void CreateMediaPlayer(){
        mediaPlayer = MediaPlayer.create(ActivitySong.this, arraySong.get(position).getFileSong());
        textviewTitle.setText(arraySong.get(position).getSongName());
        imgSong.setImageResource(arraySong.get(position).getSongImg());
        Singer.setText(arraySong.get(position).getSingerName());
        SetTimeTotal();
        UpdateTimeSong();
    }

    private void AddSong(){
        arraySong = new ArrayList<>();
        arraySong.add(new Song("Krazy", "Binz", R.drawable.krazy, R.raw.krazy));
        arraySong.add(new Song("Nến và Hoa", "Rhymastic", R.drawable.nen_va_hoa, R.raw.nen_va_hoa));
    }

    private void CreateAll(){
        textviewTitle = (TextView) findViewById(R.id.textviewTitle);
        time_start = (TextView) findViewById(R.id.time_start);
        time_end = (TextView) findViewById(R.id.time_end);
        seek_bar = (SeekBar) findViewById(R.id.seek_bar);
        btnNext = (ImageButton) findViewById(R.id.next);
        btnPlay = (ImageButton) findViewById(R.id.play);
        btnPrevious = (ImageButton) findViewById(R.id.previous);
        Singer = (TextView) findViewById(R.id.singer);
        imgSong = (ImageView) findViewById(R.id.imageSong);
//        btnRandom = (ImageButton) findViewById(R.id.random);
//        btnRepeat = (ImageButton) findViewById(R.id.repeat);

    }

}
