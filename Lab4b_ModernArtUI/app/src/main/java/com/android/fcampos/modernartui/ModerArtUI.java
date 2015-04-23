package com.android.fcampos.modernartui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class ModerArtUI extends Activity {
    public static int juego_colores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moder_art_ui);

        final RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.relLayout);
        final Lienzo fondo = new Lienzo(this);
        final TextView textoGaleria = (TextView) layout1.findViewById(R.id.galeria);
        juego_colores=0;
        textoGaleria.setText("Galeria " + (juego_colores+1));
        layout1.addView(fondo);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                layout1.removeView(fondo);
                juego_colores=i;
                layout1.addView(fondo);
                textoGaleria.setText("Galeria " + (juego_colores+1));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_moder_art_ui, menu);
        return true;
    }
}