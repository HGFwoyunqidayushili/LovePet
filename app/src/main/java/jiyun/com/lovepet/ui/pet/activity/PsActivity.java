package jiyun.com.lovepet.ui.pet.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import jiyun.com.lovepet.R;

//产品建议
public class PsActivity extends AppCompatActivity {

    private EditText scanner_suggest;
    private TextView textjia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ps);
        initView();
    }

    private void initView() {
        scanner_suggest = (EditText) findViewById(R.id.scanner_suggest);
        scanner_suggest.addTextChangedListener(new TextWatcher() {
            public static final int MAX_LENGTH = 0;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String content = scanner_suggest.getText().toString();
                textjia.setText(content.length() + "/"
                        + MAX_LENGTH);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        textjia = (TextView) findViewById(R.id.textjia);
    }


    // TODO validate success, do something


}

