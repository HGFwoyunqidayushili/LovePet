package jiyun.com.lovepet.ui.personal.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.BaseActivity;
import jiyun.com.lovepet.utils.ToolBarUtil;

public class ConAddActivity extends BaseActivity {


    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.rv_title)
    TextView rvTitle;
    @Bind(R.id.rv_subtitle)
    TextView rvSubtitle;
    @Bind(R.id.rv_registered)
    TextView rvRegistered;
    @Bind(R.id.tv_city)
    TextView tvCity;
    @Bind(R.id.rl_cons)
    RelativeLayout rlCons;
    @Bind(R.id.et_add_addr)
    EditText etAddAddr;

    @Override
    protected void initView() {
        ToolBarUtil.setTitle(rvTitle, "联系地址", rvRegistered, "提交");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_con_add;
    }

    @OnClick({R.id.tv_back, R.id.rv_registered, R.id.rl_cons})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.rv_registered:

                finish();
                break;
            case R.id.rl_cons:

                break;
        }
    }
}
