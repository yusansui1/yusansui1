package com.example.mobileshop.Activity;




import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.mobileshop.R;
import com.example.mobileshop.common.BaseActivity;
import com.example.mobileshop.fragment.NavigationFragment;

public class MainActivity extends BaseActivity {
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    protected void initView() {
        super.initView();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.f1_main, new NavigationFragment());
        transaction.commit();
    }
}