package com.example.mobileshop.http.presenter;

import android.util.Log;

import com.example.mobileshop.http.entity.MemberEntity;
import com.example.mobileshop.http.service.HttpMethods;


import rx.Observable;
import rx.Subscriber;

public class MemberPresenter extends HttpMethods{
    public static void register(Subscriber<MemberEntity> subscriber,String username,String email,String password){
        Observable observable=memberService.register(username,password,email)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribe(observable,subscriber);
    }
    public static void login2(Subscriber<MemberEntity> subscriber,String username,String password){
        Log.i("Presenter","输入的账号密码为："+username+password);
        System.out.print("输入的账号密码为："+username+password);
        Observable observable=memberService.login2(username,password)
                .map(new  HttpResultFunc<MemberEntity>());
        toSubscribe(observable,subscriber);
    }
    public static void changePassword(Subscriber subscriber,String memberId,String old_pwd,String new_pwd){
        Observable observable=memberService.changePassword(memberId, old_pwd, new_pwd);
        toSubscribe(observable,subscriber);
    }
}
