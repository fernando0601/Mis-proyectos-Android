package com.android.fcampos.modernartui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

public class ModerArtUI extends Activity {
    public static int juego_colores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moder_art_ui);

        final RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.relLayout);
        final Lienzo fondo = new Lienzo(this);
        juego_colores=0;
        layout1.addView(fondo);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                layout1.removeView(fondo);
                juego_colores=i;
                layout1.addView(fondo);
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

    class Lienzo extends View {

        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            int azul=0;
            int gris=0;
            int naranja=0;
            int verde=0;
            int rojo=0;
            int ancho=canvas.getWidth();
            int largo=canvas.getHeight();
            Resources res = getResources();
            switch (juego_colores+1){
                case 1:
                    azul = res.getColor(R.color.azul_1);
                    gris = res.getColor(R.color.gris_1);
                    naranja = res.getColor(R.color.naranja_1);
                    verde = res.getColor(R.color.verde_1);
                    rojo = res.getColor(R.color.rojo_1);
                    break;
                case 2:
                    azul = res.getColor(R.color.azul_2);
                    gris = res.getColor(R.color.gris_2);
                    naranja = res.getColor(R.color.naranja_2);
                    verde = res.getColor(R.color.verde_2);
                    rojo = res.getColor(R.color.rojo_2);
                    break;
                case 3:
                    azul = res.getColor(R.color.azul_3);
                    gris = res.getColor(R.color.gris_3);
                    naranja = res.getColor(R.color.naranja_3);
                    verde = res.getColor(R.color.verde_3);
                    rojo = res.getColor(R.color.rojo_3);
                    break;
                case 4:
                    azul = res.getColor(R.color.azul_4);
                    gris = res.getColor(R.color.gris_4);
                    naranja = res.getColor(R.color.naranja_4);
                    verde = res.getColor(R.color.verde_4);
                    rojo = res.getColor(R.color.rojo_4);
                    break;
                case 5:
                    azul = res.getColor(R.color.azul_5);
                    gris = res.getColor(R.color.gris_5);
                    naranja = res.getColor(R.color.naranja_5);
                    verde = res.getColor(R.color.verde_5);
                    rojo = res.getColor(R.color.rojo_5);
                    break;
                case 6:
                    azul = res.getColor(R.color.azul_6);
                    gris = res.getColor(R.color.gris_6);
                    naranja = res.getColor(R.color.naranja_6);
                    verde = res.getColor(R.color.verde_6);
                    rojo = res.getColor(R.color.rojo_6);
                    break;
                case 7:
                    azul = res.getColor(R.color.azul_7);
                    gris = res.getColor(R.color.gris_7);
                    naranja = res.getColor(R.color.naranja_7);
                    verde = res.getColor(R.color.verde_7);
                    rojo = res.getColor(R.color.rojo_7);
                    break;
            }

            Paint pincel1 = new Paint();
            pincel1.setColor(azul);
            canvas.drawRect(0,0,ancho/2,largo/2,pincel1);
            pincel1.setColor(gris);
            canvas.drawRect(0,largo/2,ancho/2,largo,pincel1);
            pincel1.setColor(naranja);
            canvas.drawRect(ancho/2,0,ancho,largo/3,pincel1);
            pincel1.setColor(rojo);
            canvas.drawRect(ancho/2,largo/3,ancho,2*(largo/3),pincel1);
            pincel1.setColor(verde);
            canvas.drawRect(ancho/2,2*(largo/3),ancho,largo,pincel1);
        }

        public void cambia(Canvas canvas){
            canvas.drawColor(Color.BLUE);
        }
    }

}