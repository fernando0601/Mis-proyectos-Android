package com.android.fcampos.modernartui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Fernando Campos Sandoval on 23/04/2015.
 * This class draws the rectangles simulating paints
 */
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
        int largo_ini = (canvas.getHeight())/10;
        int largo_fin = canvas.getHeight() - (canvas.getHeight())/10;

        Resources res = getResources();
        switch (ModerArtUI.juego_colores){
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
            case 0:
                azul = res.getColor(R.color.azul_7);
                gris = res.getColor(R.color.gris_7);
                naranja = res.getColor(R.color.naranja_7);
                verde = res.getColor(R.color.verde_7);
                rojo = res.getColor(R.color.rojo_7);
                break;
        }

        Paint pincel1 = new Paint();

        pincel1.setStyle(Paint.Style.FILL);
        pincel1.setColor(azul);
        canvas.drawRect(0,largo_ini,ancho/2,largo_fin/2,pincel1);
        pincel1.setColor(gris);
        canvas.drawRect(0,largo_fin/2,ancho/2,largo_fin,pincel1);
        pincel1.setColor(naranja);
        canvas.drawRect(ancho/2,largo_ini,ancho,largo_fin/3,pincel1);
        pincel1.setColor(rojo);
        canvas.drawRect(ancho/2,largo_fin/3,ancho,2*(largo_fin/3),pincel1);
        pincel1.setColor(verde);
        canvas.drawRect(ancho/2,2*(largo_fin/3),ancho,largo_fin,pincel1);

        pincel1.setColor(Color.BLACK);
        pincel1.setStrokeWidth(10);
        pincel1.setStyle(Paint.Style.STROKE);
        canvas.drawRect(0,largo_ini,ancho/2,largo_fin/2,pincel1);
        canvas.drawRect(0,largo_fin/2,ancho/2,largo_fin,pincel1);
        canvas.drawRect(ancho/2,largo_ini,ancho,largo_fin/3,pincel1);
        canvas.drawRect(ancho/2,largo_fin/3,ancho,2*(largo_fin/3),pincel1);
        canvas.drawRect(ancho/2,2*(largo_fin/3),ancho,largo_fin,pincel1);
    }
}
