package com.example.mobileshop.Activity;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



import com.example.mobileshop.R;
import com.example.mobileshop.common.BaseActivity;
import com.example.mobileshop.http.entity.MemberEntity;
import com.example.mobileshop.http.presenter.MemberPresenter;
import com.example.mobileshop.http.service.ProgressDialogSubscriber;
import com.example.mobileshop.http.utils.SystemConfig;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity{
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_pwd)
    EditText etPwd;

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }
    @OnClick(R.id.iv_back)
    void close(){finish();}
    @OnClick(R.id.bt_login)
    void login(){
        String userName=etUsername.getText().toString().trim();
        String pwd=etPwd.getText().toString().trim();
//        if(TextUtils.isEmpty(userName)){
//            toastShort("请输入用户名");
//            return;
//        }
//        if(TextUtils.isEmpty(pwd)){
//            toastShort("请输入密码");
//            return;
//        }
        Log.i("LoginActivity","账号："+userName+"密码："+pwd);
        System.out.print("账号："+userName+"密码："+pwd);
        MemberPresenter.login2(new ProgressDialogSubscriber<MemberEntity>(this) {

            @Override
            public void onNext(MemberEntity memberEntity) {
                SystemConfig.setLogin(true);
                toastShort("登录成功");
                SystemConfig.setLoginUserName(memberEntity.uname);
                SystemConfig.setLoginUserEmail(memberEntity.email);
                Log.i("LoginActivity","用户头像："+memberEntity.email);
                SystemConfig.setLoginUserHead(memberEntity.image);
                setResult(RESULT_OK);
                finish();
            }
        },userName,pwd);
    }
}
    /*
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG="LoginActivity";
    private EditText et_username;
    private EditText et_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }
    private void initView(){
        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.bt_login).setOnClickListener(this);
        et_username=findViewById(R.id.et_username);
        et_pwd=findViewById(R.id.et_pwd);
        String user_name=getIntent().getStringExtra("user_name");
        Log.d(TAG,"user_name="+user_name);
        et_username.setText(user_name);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.bt_login:
                String user_name = et_username.getText().toString();
                String pwd = et_pwd.getText().toString();
                if (TextUtils.isEmpty(user_name)) {
                    Toast.makeText(LoginActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pwd)) {
                    Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                new AlertDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage("用户名：" + user_name + "密码：" + pwd)
                        .show();
                break;

        }
    }
*/

