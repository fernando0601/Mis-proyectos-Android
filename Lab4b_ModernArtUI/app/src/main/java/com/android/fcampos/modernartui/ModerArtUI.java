package com.android.fcampos.modernartui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class ModerArtUI extends Activity {
    public static int juego_colores;
    private DialogFragment mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moder_art_ui);

        final RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.relLayout);
        final Lienzo fondo = new Lienzo(this);
        final TextView textoGaleria = (TextView) layout1.findViewById(R.id.galeria);
        //This variable allows change between color sets (7 of them).
        juego_colores=0;
        //Display in which gallery is the visitor.
        textoGaleria.setText("Galeria " + (juego_colores+1));
        layout1.addView(fondo);

        //Create the seekbar from 0 to 6
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {
            @Override
            //On every change remove the view to display new colors, add the new view and change the tittle
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
        // Inflate the menu; this adds items to the action bar.
        getMenuInflater().inflate(R.menu.menu_moder_art_ui, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //When a menu is selected
        switch (item.getItemId()) {
            case R.id.more_info:
                //Create and show dialog
                mDialog = AlertDialogFragment.newInstance();
                mDialog.show(getFragmentManager(), "Museum of modern art");
                return true;
            default:
                return false;
        }
    }


    public static class AlertDialogFragment extends DialogFragment {
        public static AlertDialogFragment newInstance() {
            return new AlertDialogFragment();
        }
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            //Create the dialog
            return new AlertDialog.Builder(getActivity())
                    .setMessage("¿Quieres ir a MOMA.org?")
                    .setCancelable(false)
                    .setNegativeButton("No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    ((ModerArtUI) getActivity())
                                            .quitar(true);
                                }
                            })
                    .setPositiveButton("Si",
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        final DialogInterface dialog, int id) {
                                    ((ModerArtUI) getActivity())
                                            .quitar(false);
                                }
                            }).create();
        }
    }

    //This function opens the web browser or continues without the dialog
    private void quitar (boolean continua) {
        if (!continua) {
            //The web page is correct, but is displayed as CONNECTION ERROR
            setContentView(R.layout.web);
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("http://www.moma.org/");
        } else {
            mDialog.dismiss();
        }
    }
}


