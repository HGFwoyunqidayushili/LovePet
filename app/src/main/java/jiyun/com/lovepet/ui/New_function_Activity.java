package jiyun.com.lovepet.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.adapter.MyPagerAdapter;

public class New_function_Activity extends AppCompatActivity {

    private ViewPager mvp;
    private ImageView iv_back;
    private ArrayList<View> lImageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_function_);
        mvp = (ViewPager) findViewById(R.id.vp);
        iv_back = (ImageView) findViewById(R.id.iv_newback);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        lImageViews = new ArrayList<View>();
        ImageView iv1 = new ImageView(New_function_Activity.this);
        iv1.setImageResource(R.drawable.aphoto);
        ImageView iv2 = new ImageView(New_function_Activity.this);
        iv2.setImageResource(R.drawable.b);
        ImageView iv3 = new ImageView(New_function_Activity.this);
        iv3.setImageResource(R.drawable.c);
        lImageViews.add(iv1);
        lImageViews.add(iv2);
        lImageViews.add(iv3);
        MyPagerAdapter mAdapter = new MyPagerAdapter(lImageViews);
        mvp.setAdapter(mAdapter);
    }
}
