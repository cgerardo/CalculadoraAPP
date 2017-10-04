package mx.edu.utng.pcamacho.calculadoraap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    EditText txtN1,txtN2, txtRes;
    Button btnSumar, btnRestar, btnMultiplicar, btnDividir, btnFactorial, btnLimpiar;
    Spinner cmbCal;
    private int tipo;
    private double n1,n2,res;
    private int n;
    private boolean banCN=false;
    private boolean banCC=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtN1=(EditText)findViewById(R.id.txt_n1);
        txtN2=(EditText)findViewById(R.id.txt_n2);
        txtRes=(EditText)findViewById(R.id.txt_res);
        cmbCal=(Spinner)findViewById(R.id.spn_calculadoras);
        btnSumar=(Button)findViewById(R.id.btn_sumar);
        btnRestar=(Button)findViewById(R.id.btn_restar);
        btnMultiplicar=(Button)findViewById(R.id.btn_multiplicar);
        btnDividir=(Button)findViewById(R.id.btn_dividir);
        btnFactorial=(Button)findViewById(R.id.btn_factorial);
        btnLimpiar=(Button)findViewById(R.id.btn_limpiar);

        btnSumar.setOnClickListener(this);
        btnRestar.setOnClickListener(this);
        btnDividir.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnFactorial.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
        cmbCal.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId()==R.id.spn_calculadoras) {
            tipo = (int) cmbCal.getSelectedItemId();
            switch (tipo) {
                case 1:
                    banCN=true;
                    banCC=false;
                    break;
                case 2:
                    banCC=true;
                    banCN=false;
                    break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onClick(View v) {
        CalculadoraNormal cn = new CalculadoraNormal();
        CalculadoraCientifica cc = new CalculadoraCientifica();
        n=Integer.parseInt(txtN1.getText().toString());
        n1=Double.parseDouble(txtN1.getText().toString());
        n2=Double.parseDouble(txtN2.getText().toString());
        switch (v.getId()){
            case R.id.btn_sumar:
                if (banCN){
                    txtRes.setText(""+cn.sumar(n1,n2));
                }else if (banCC){
                    txtRes.setText(""+cc.sumar(n1,n2));

                }
                break;
            case R.id.btn_restar:
                if (banCN){
                    txtRes.setText(""+cn.restar(n1,n2));
                }else if (banCC){
                    txtRes.setText(""+cc.restar(n1,n2));

                }
                break;
            case R.id.btn_multiplicar:
                if (banCN){
                    txtRes.setText(""+cn.multiplicar(n1,n2));
                }
                break;
            case R.id.btn_dividir:
                if (banCN){
                    txtRes.setText(""+cn.dividir(n1,n2));
                }
                break;
            case R.id.btn_factorial:
                if (banCC){
                    txtRes.setText(""+ cc.factoria(n));
                }
                break;
            case R.id.btn_limpiar:
                txtN1.setText("");
                txtN2.setText("");
                txtRes.setText("");
        }
    }
}

