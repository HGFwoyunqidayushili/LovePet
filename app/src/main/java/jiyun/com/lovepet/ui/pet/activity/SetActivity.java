package jiyun.com.lovepet.ui.pet.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import jiyun.com.lovepet.R;

public class SetActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout suggest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        initView();
    }
    private void initView() {
        suggest = (LinearLayout) findViewById(R.id.suggest);
        suggest.setOnClickListener(this);
        suggest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetActivity.this,PsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
//        Intent intent = new Intent(SetActivity.this,PsActivity.class);
//        startActivity(intent);
    }
}
