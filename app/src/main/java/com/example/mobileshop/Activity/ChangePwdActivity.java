package com.example.mobileshop.Activity;

import android.widget.TextView;

import com.example.mobileshop.R;
import com.example.mobileshop.common.BaseActivity;

import butterknife.BindView;

public class ChangePwdActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @Override
    public int getContentViewId() {
        return R.layout.activity_change_pwd;
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText("修改密码");
    }
    void close(){finish();}
}
