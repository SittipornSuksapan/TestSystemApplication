package com.chan.revernue.testsystemapplication;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvChan;
    private EditText numEditText;
    private Button btnCoppy;

    private EditText edtText1, edtText2;
    private TextView tvSum;
    private Button btnCalculate;

    private RadioGroup rgOperator;
    private RadioButton rbPlus, rbMinus, rbMultiply, rbDivide;
    private CheckBox checkval;

      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          initInstances();

          Display display = getWindowManager().getDefaultDisplay();
          Point size = new Point();
          display.getSize(size);
          int width = size.x;
          int height = size.y;
          Toast.makeText(MainActivity.this,
                  "Width = " + width + ", Heidht = " + height,
                  Toast.LENGTH_SHORT).show();

      }

    private void initInstances() {
        tvChan = (TextView) findViewById(R.id.tvChan);


        tvChan.setMovementMethod(LinkMovementMethod.getInstance());
        tvChan.setText(Html.fromHtml("<b>He<u>ll</u>o</b> <i>Word</i>"));
//         <font color="#000">La La</forn> <a href="้https://www.youtube.com">https://www.youtube.com</a>

        numEditText = (EditText) findViewById(R.id.edtNum);
        btnCoppy = (Button) findViewById(R.id.btnCoppy);
        btnCoppy.setOnClickListener(this);

        //  ___________________start home_____________________  //

        edtText1 = (EditText) findViewById(R.id.edtText1);
        edtText2 = (EditText) findViewById(R.id.edtText2);
        tvSum = (TextView) findViewById(R.id.tvSum);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

//        rbPlus = (RadioButton) findViewById(R.id.rbPlus);
//        rbMinus = (RadioButton) findViewById(R.id.rbMunus);
//        rbMultiply = (RadioButton) findViewById(R.id.rbMultiply);
//        rbDivide = (RadioButton) findViewById(R.id.rbDivide);
        checkval = (CheckBox) findViewById(R.id.checkval);
        rgOperator = (RadioGroup) findViewById(R.id.rgOperator);


        btnCalculate.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {
        if (view == btnCoppy) {
            tvChan.setText(numEditText.getText());
        } else if (view == btnCalculate) {
            int val1 = 0;
            int val2 = 0;
            int sum = 0;
            try {
                val1 = Integer.parseInt(edtText1.getText().toString());
            } catch (NumberFormatException e) {

            }
            try {
                val2 = Integer.parseInt(edtText2.getText().toString());
            } catch (NumberFormatException e) {

            }
            if (checkval.isChecked()) {
                switch (rgOperator.getCheckedRadioButtonId()) {
                    case R.id.rbPlus:
                        sum = val1 + val2;
                        break;
                    case R.id.rbMinus:
                        sum = val1 - val2;
                        break;
                    case R.id.rbMultiply:
                        sum = val1 * val2;
                        break;
                    case R.id.rbDivide:
                        sum = val1 / val2;
                        break;
                }
//
//                if (rbPlus.isChecked()) {
//                    sum = val1 + val2;
//                } else if (rbMinus.isChecked()) {
//                    sum = val1 - val2;
//                } else if (rbMultiply.isChecked()) {
//                    sum = val1 * val2;
//                } else if (rbDivide.isChecked()) {
//                    sum = val1 / val2;
//                }
            } else {
                sum = val1 + val2;
            }
            tvSum.setText(sum + "");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
//        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}