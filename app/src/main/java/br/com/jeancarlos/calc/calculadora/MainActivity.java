package br.com.jeancarlos.calc.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

@SuppressWarnings({"SpellCheckingInspection", "PointlessBooleanExpression"})
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSum;
    private Button btnSub;
    private Button btnFour;
    private Button btnThree;
    private Button btnTwo;
    private Button btnOne;
    private Button btnResult;
    private Button btnMult;
    private TextView textResult;

    private int result;
    private boolean isSum = false;
    private boolean isSub = false;
    private boolean isMult = false;

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
        btnMult = (Button) findViewById(R.id.button_mult);
        btnResult = (Button) findViewById(R.id.button_result);

        // Coloca o evento de clique para cada botão
        textResult.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnSum.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Pega o texto atual do resultado
        String currentText = textResult.getText().toString();
        int buttonId = v.getId();

        switch (buttonId) {
            case R.id.button_one:
                textResult.setText(currentText + "1");
                break;

            case R.id.button_two:
                textResult.setText(currentText + "2");
                break;

            case R.id.button_three:
                textResult.setText(currentText + "3");
                break;

            case R.id.button_four:
                textResult.setText(currentText + "4");
                break;

            case R.id.button_result:
                String result = calculate(currentText);
                clear();
                textResult.setText(result);
                break;
        }

        if (temMaisQueUmOperador(currentText) == false) {
            switch (buttonId) {
                case R.id.button_sum:
                    isSum = true;
                    textResult.setText(currentText + "+");
                    break;

                case R.id.button_sub:
                    isSub = true;
                    textResult.setText(currentText + "-");
                    break;

                case R.id.button_mult:
                    isMult = true;
                    textResult.setText(currentText + "*");
                    break;
            }
        }
    }

    /**
     * Calcula o resultado
     *
     * @param currentResult Valor atual do texto de resultado
     * @return Resulta da operação
     */
    private String calculate(String currentResult) {
        int calc;

        if (isSum) {
            String[] numeros = currentResult.split("\\+");
            calc = Integer.parseInt(numeros[0]) + Integer.parseInt(numeros[1]);

        } else if (isSub) {
            String[] numeros = currentResult.split("\\-");
            calc = Integer.parseInt(numeros[0]) - Integer.parseInt(numeros[1]);

        } else {
            String[] numeros = currentResult.split("\\*");
            calc = Integer.parseInt(numeros[0]) * Integer.parseInt(numeros[1]);
        }

        return String.valueOf(calc);
    }


    /**
     * Verifica se existe mais de um operador no resultado
     *
     * @param currentResult Valor atual do texto de resultado
     */
    private boolean temMaisQueUmOperador(String currentResult) {
        int contador = 1;

        if (currentResult.contains("+")) {
            contador = contador + 1;
        }

        if (currentResult.contains("-")) {
            contador = contador + 1;
        }

        if (currentResult.contains("*")) {
            contador = contador + 1;
        }

        if (contador > 1) {
            return true;
        }

        return false;
    }

    /**
     * Limpa o texto do resultado e reseta as variáveis
     */
    private void clear() {
        textResult.setText("");
        isSum = false;
        isSub = false;
        isMult = false;
    }
}
