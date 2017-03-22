package com.example.windows10.checksystem.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.presenter.ForgetPasswordPresenter;
import com.example.windows10.checksystem.view.ForgetPasswordView;

public class ForgetPasswordActivity extends BaseActivity implements ForgetPasswordView {

    private ForgetPasswordPresenter mPresenter;
    private EditText et_forget_login_name;
    private Button btn_forget_send_vcode;
    private EditText et_forget_login_password;
    private Button btn_forget_login;
    private TextView tv_forget_now_regist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        initView();
        mPresenter = new ForgetPasswordPresenter(this);

    }

    private void initView() {
        et_forget_login_name = (EditText)findViewById(R.id.et_forget_login_name);
        btn_forget_send_vcode = (Button)findViewById(R.id.btn_forget_send_vcode);
        et_forget_login_password = (EditText)findViewById(R.id.et_forget_login_password);
        btn_forget_login = (Button)findViewById(R.id.btn_forget_login);
        tv_forget_now_regist = (TextView)findViewById(R.id.tv_forget_now_regist);
    }
}
