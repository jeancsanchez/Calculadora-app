package br.com.jeancarlos.calc.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

@SuppressWarnings("SpellCheckingInspection")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSum;
    private Button btnSub;
    private Button btnFour;
    private Button btnThree;
    private Button btnTwo;
    private Button btnOne;
    private Button btnResult;
    private TextView textResult;

    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = (TextView) findViewById(R.id.text_view_result);
        btnOne = (Button) findViewById(R.id.button_one);
        btnTwo = (Button) findViewById(R.id.button_two);
        btnThree = (Button) findViewById(R.id.button_three);
        btnFour = (Button) findViewById(R.id.button_four);
        btnSum = (Button) findViewById(R.id.button_sum);
        btnSub = (Button) findViewById(R.id.button_sub);
        btnResult = (Button) findViewById(R.id.button_result);

        // Coloca o evento de clique para cada botão
        textResult.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnSum.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Pega o texto atual do resultado
        String currentText = textResult.getText().toString();

        switch (v.getId()) {
            case R.id.button_one:
                result = result + 1;
                textResult.setText(currentText + "1");
                break;
        }
    }
}
