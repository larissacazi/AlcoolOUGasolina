package zimmermann.larissa.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button checkButton;
    private TextView result;
    private EditText gasPrice;
    private EditText alcoolPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkButton = (Button) findViewById(R.id.checkButtonId);
        result = (TextView) findViewById(R.id.resultTextID);
        gasPrice = (EditText) findViewById(R.id.gasPriceId);
        alcoolPrice = (EditText) findViewById(R.id.alcoolPriceId);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String priceAlcool = alcoolPrice.getText().toString();
                String priceGas = gasPrice.getText().toString();

                if(priceAlcool.isEmpty()) {
                    if(priceGas.isEmpty()) {
                        result.setText("");
                        Toast.makeText(getApplicationContext(), "Entre com os preços do Álcool e da Gasolina.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        result.setText("");
                        Toast.makeText(getApplicationContext(), "Entre com o preço do Álcool.", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(priceGas.isEmpty()) {
                    if(priceAlcool.isEmpty()) {
                        result.setText("");
                        Toast.makeText(getApplicationContext(), "Entre com os preços do Álcool e da Gasolina.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        result.setText("");
                        Toast.makeText(getApplicationContext(), "Entre com o preço da Gasolina.", Toast.LENGTH_SHORT).show();
                    }
                }
                else {

                    double alcool = Double.parseDouble(priceAlcool);
                    double gas = Double.parseDouble(priceGas);
                    double percent = alcool / gas;

                    if(percent >= 0.7) {
                        result.setText("É melhor utilizar a GASOLINA.");
                    }
                    else {
                        result.setText("É melhor utilizar o ÁLCOOL.");
                    }
                }
            }
        });
    }
}
