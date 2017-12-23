package jiyun.com.lovepet.ui.personal.activity;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import jiyun.com.lovepet.R;
import jiyun.com.lovepet.manager.UserManager;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.AppUtils;
import jiyun.com.lovepet.utils.CJSON;
import jiyun.com.lovepet.utils.FileUtil;
import jiyun.com.lovepet.utils.TableUtils;
import jiyun.com.lovepet.utils.ToastUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NameActivity extends BaseActivity {


    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.rv_title)
    TextView rvTitle;
    @Bind(R.id.rv_subtitle)
    TextView rvSubtitle;
    @Bind(R.id.rv_registered)
    TextView rvRegistered;
    @Bind(R.id.et_updata_name)
    EditText etUpdataName;

    @Override
    protected void initView() {
        rvTitle.setText("名称");
        rvTitle.setTextSize(18);
        rvTitle.setTextColor(Color.BLACK);

        rvRegistered.setText("提交");
        rvRegistered.setTextSize(13);
        rvRegistered.setTextColor(Color.BLACK);


    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_name;
    }


    @OnClick({R.id.tv_back, R.id.rv_registered})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.rv_registered:
                if (etUpdataName.getText().toString() != null) {
                    //提交到服务器
                    updateName();
                }

                break;
        }
    }


    private void updateName() {


        Map<String, Object> param = new HashMap<>();
        param.put(TableUtils.UserInfo.USERID, UserManager.getIntance().getUserId());
        param.put(TableUtils.UserInfo.USERNAME, etUpdataName.getText()
                .toString().trim());
        // 生成提交服务器的JSON字符串
        String json = CJSON.toJSONMap(param);
        // FileUtil.getToken();


        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        FormBody.Builder builder = new FormBody.Builder();
        builder.add(CJSON.DATA, json);
        builder.build();

        final Request request = new Request.Builder().post(builder.build()).url(AppUtils.REQUESTURL + "user/updateUserInfo.jhtml").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("onFailure: ", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (CJSON.getRET(string)) {
                            AppUtils.userInfo.setUserName(etUpdataName.getText()
                                    .toString());

//                            UserInfo userInfo = new UserInfo();
//                            userInfo.setUserName("");
//                            userInfo.setUserName(etUpdataName.getText().toString());
//                            UserManager.getIntance().saveUser(userInfo);

                            FileUtil.saveUser(AppUtils.userInfo);
                            ToastUtil.show("修改成功!");
                          /*  Intent intent = new Intent(NameActivity.this, PersinalInfoActivity.class);
                            startActivity(intent);*/
                            finish();
                        } else {
                            ToastUtil.show("修改失败");
                        }
                    }
                });

            }
        });


    }
}
