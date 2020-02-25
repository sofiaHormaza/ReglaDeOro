package com.example.m;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView contador;
    private int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contador=findViewById(R.id.contador);

        new Thread(
                ()->{
                    //hilo a ejecutar
                    //dentro del worker

                    while(true){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        c++;
                        //puente para ponerlo en GUI
                        runOnUiThread(
                                ()->{
                                    //cambio del texto lo invoca el hilo
                                    contador.setText(""+c);
                                }
                        );


                    }
                }
        ).start();
    }
}
