package br.edu.fateczl.numbersplit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText NumInt;
    private TextView txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        NumInt = findViewById(R.id.NumInt);
        NumInt.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        txtRes = findViewById(R.id.txtRes);
        txtRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op -> calc());
    }

    public void calc(){
        int numero = Integer.parseInt(NumInt.getText().toString());
        if (numero <100 || numero >999){
            String res = "Número inválido, digite novamente";
            txtRes.setText(res);
        } else {
            int centena = numero / 100;
            int dezena = (numero / 10) %10;
            int unidade = numero % 10;
            String res = "Centena: " +centena+ "\nDezena: " +dezena+ "\nUnidade: " +unidade;
            txtRes.setText(res);
        }




    }
}