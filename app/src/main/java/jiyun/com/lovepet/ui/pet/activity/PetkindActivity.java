package jiyun.com.lovepet.ui.pet.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.api.App;
import jiyun.com.lovepet.entity.pet.PetType;
import jiyun.com.lovepet.entity.pet.SortModel;
import jiyun.com.lovepet.entity.pet.adapter.SortListView;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.CJSON;
import jiyun.com.lovepet.utils.CharacterParser;
import jiyun.com.lovepet.utils.CustomTextLayout;
import jiyun.com.lovepet.utils.PinyinComparator;
import jiyun.com.lovepet.utils.TableUtils;
import jiyun.com.lovepet.view.ClearEditText;
import jiyun.com.lovepet.view.SideBar;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PetkindActivity extends BaseActivity {
     private CustomTextLayout App_title;
     private TabLayout tabLayout;
     private ViewPager viewPager;
     private Button pet_type_dog;
     private Button pet_type_cat;
     private Button pet_type_pet;

      private List<String> listType;
       private Map<String,Object> petTypelist;
     private String petCode;

     private CharacterParser characterParser;
    private List<SortModel> SourceDateList;//填充源适配器
    private SideBar sideBar;
    private TextView dialog;
    private String xiaoChong;
    private PinyinComparator pinyinComparator;
    private ListView listView;
    private View v;
    private SortListView sortListView;

     private ClearEditText clearEditText;
    @Override
    protected void initView() {
        listView= (ListView) findViewById(R.id.country_lvcountry);
        App_title= (CustomTextLayout) findViewById(R.id.App_title);
        App_title.setLeftImg(getResources().getDrawable(R.drawable.back_gray));
        App_title.setCenterTv("宠物类型","#353535");
        pet_type_dog= (Button) findViewById(R.id.pet_type_dog);
        pet_type_cat= (Button) findViewById(R.id.pet_type_cat);
        pet_type_pet= (Button) findViewById(R.id.pet_type_pet);
        sideBar= (SideBar) findViewById(R.id.sidrbar);
        dialog= (TextView) findViewById(R.id.dialog);
        petCode=getIntent().getStringExtra(TableUtils.PetInfo.PETCODE);
        listType=new ArrayList<>();
        petTypelist=new HashMap<>();
        listType.add("23c8d60ef10644ee96314c11c4d3f86b");
        listType.add("fe013d906bae4945a468780a94212ff7");
        listType.add("20706e878a7b4625be0c5460371a6c25");
        petTypelist.put("dog",listType);
        petTypelist.put("cat","2aa312a64be44067a4eee43b94c1f9b8");
        petTypelist.put("xiaopet","ffd1209b320c4bb382c5bdac4f722cf4");

        //实例化汉语转拼音
        characterParser= CharacterParser.getInstance();
        pinyinComparator=new PinyinComparator();
         sideBar.setTextView(dialog);
        HashMap<String, Object> map = new HashMap<>();
        map.put(TableUtils.PetType.TYPECODES, petTypelist.get("dog"));
        xiaoChong = petTypelist.get("dog").toString();
        getDatas(map);


        //收缩框
        clearEditText= (ClearEditText) findViewById(R.id.search);
        clearEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filterData(charSequence.toString());
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        pet_type_dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, Object> map = new HashMap<>();

                map.put(TableUtils.PetType.TYPECODES, petTypelist.get("dog"));
                xiaoChong=petTypelist.get("dog").toString();
                getDatas(map);
            }
        });
        pet_type_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, Object> map = new HashMap<>();
                map.put(TableUtils.PetType.PARENTTYPECODE,petTypelist.get("cat"));
                xiaoChong=petTypelist.get("dog").toString();
                getDatas(map);
            }
        });
        pet_type_pet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, Object> map = new HashMap<>();
                map.put(TableUtils.PetType.PARENTTYPECODE,petTypelist.get("xiaopet"));
                xiaoChong=petTypelist.get("dog").toString();
                getDatas(map);
            }
        });
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                if (s.equals("热门")) {
                    listView.setSelectionFromTop(0, 0);
                }
                // 该字母首次出现的位置
                int position = sortListView.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    listView.setSelection(position);
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(PetkindActivity.this,
                        AddPetActivity.class);
                intent.putExtra(TableUtils.PetInfo.PETTYPE,
                        ((SortModel)sortListView.getItem(i)).getPetCode());
                intent.putExtra(TableUtils.PetInfo.PETNAME,
                        ((SortModel) sortListView.getItem(i)).getName());

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

/*
  //过滤数据
 */
    private void filterData(String string) {
        List<SortModel> filterDateList = new ArrayList<SortModel>();

        if (TextUtils.isEmpty(string)) {
            filterDateList = SourceDateList;
        } else {
            filterDateList.clear();
            for (SortModel sortModel : SourceDateList) {
                String name = sortModel.getName();
                if (name.indexOf(string.toString()) != -1
                        || characterParser.getSelling(name).startsWith(
                        string.toString())) {
                    filterDateList.add(sortModel);
                }
            }
        }

        // 根据a-z进行排序
        Collections.sort(filterDateList, pinyinComparator);
        sortListView.updateListView(filterDateList);
    }

    private void getDatas(HashMap<String, Object> map) {
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody.Builder body=new FormBody.Builder();
        String json= CJSON.toJSONMap(map);
        body.add(CJSON.DATA,json);
        Request request=new Request.Builder().url(CJSON.URL_STRING+"petType/getPetTypesByVO.jhtml").post(body.build()).build();
          okHttpClient.newCall(request).enqueue(new Callback() {
              @Override
              public void onFailure(Call call, IOException e) {

              }

              @Override
              public void onResponse(Call call, final Response response) throws IOException {

                  String str = response.body().string();

                  if (CJSON.getRET(str)) {
                      List<PetType> petInfoList = CJSON.parseArray(CJSON.parseObject(str).getString("desc"), PetType.class);
                      SourceDateList = filledData(petInfoList);
                      //拿到数据后进行排序
                      App.baseActivity.runOnUiThread(new Runnable() {
                          @Override
                          public void run() {

                              petType();
                          }
                      });

                  }
              }
          });
//        Collections.sort(SourceDateList, pinyinComparator);
//        sortListView = new SortListView(this, SourceDateList);
//        listView.setAdapter(sortListView);
    }

/*
  //拿到数据后进行排序
 */
    private void petType() {
        if (v != null) {
           listView.removeHeaderView(v);
        }
        Collections.sort(SourceDateList, pinyinComparator);
        sortListView = new SortListView(this, SourceDateList);
        v = LayoutInflater.from(this).inflate(R.layout.item, null);
        // if (hotList != null && hotList.size() > 0) {
        // sortListView.addHeaderView(v);
        //
        // }
        listView.setAdapter(sortListView);
    }
    /**
     * 为ListView填充数据
     *
     * @param date
     * @return
     */
    private List<SortModel> filledData(List<PetType> date) {
              List<SortModel> mSorelist=new ArrayList<>();
               for(int i=0;i<date.size();i++){
                   SortModel sortModel=new SortModel();
                    sortModel.setName(date.get(i).getParentTypeName());
                     sortModel.setPetCode(date.get(i).getTypeCode());
                     String pinyin=characterParser.getSelling(date.get(i).getParentTypeName());
                    String spil=pinyin.substring(0,1).toUpperCase();
                   if(spil.matches("[A-Z]")){
                       sortModel.setSortLetters(spil.toUpperCase());

                   }
                   else {
                       sortModel.setSortLetters("#");
                   }
                   mSorelist.add(sortModel);
               }
        return mSorelist;
    }


    @Override
    public void initData(String s) {

    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_petkind;
    }
}
