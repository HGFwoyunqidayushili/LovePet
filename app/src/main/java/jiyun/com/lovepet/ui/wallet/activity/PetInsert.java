package jiyun.com.lovepet.ui.wallet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.adapter.PetInsertAdapter;
import jiyun.com.lovepet.ui.pet.activity.OrderActivity;

public class PetInsert extends AppCompatActivity {

    private ListView insertListView;
    private ArrayList<Student> arrayList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_insert);
        initView();
        initData();
        initAdapter();
        initlInnsert();
    }

    private void initlInnsert() {
        insertListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PetInsert.this, OrderActivity.class);
                intent.putExtra("image",arrayList.get(0).getImage());
                intent.putExtra("name",arrayList.get(1).getName());
                startActivity(intent);
                finish();
            }
        });
    }

    private void initAdapter() {
        PetInsertAdapter petInsertAdapter = new PetInsertAdapter(arrayList, PetInsert.this);
        insertListView.setAdapter(petInsertAdapter);
    }

    private void initData() {
        arrayList.add(new Student(ZooUrl.DOG,"狗"));
        arrayList.add(new Student(ZooUrl.CAT,"猫"));
        arrayList.add(new Student(ZooUrl.TUZI,"兔子"));
        arrayList.add(new Student(ZooUrl.LAOHU,"老虎"));
        arrayList.add(new Student(ZooUrl.JI,"小鸡"));
    }

    private void initView() {
        insertListView = (ListView) findViewById(R.id.insertListView);
    }
}
