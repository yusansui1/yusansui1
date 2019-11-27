package com.example.mobileshop.fragment;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;

import com.example.mobileshop.R;
import com.example.mobileshop.common.BaseFragment;



public class NavigationFragment extends BaseFragment implements View.OnClickListener {
    private ImageButton mIbHome;
    private ImageButton mIbCategory;
    private ImageButton mIbCart;
    private ImageButton mIbPersonal;
    private HomeFragment homeFragment;
    private CategroyFragment categroyFragment;
    private CartFragment cartFragment;
    private PersonalFragment personalFrament;
    public int getContentViewId(){
        return R.layout.fragment_navigation;
    }
    protected  void initView(View view){
        super.initView(view);
        mIbHome=view.findViewById(R.id.ib_home);
        mIbCategory=view.findViewById(R.id.ib_category);
        mIbCart=view.findViewById(R.id.ib_cart);
        mIbPersonal=view.findViewById(R.id.ib_personal);
        mIbHome.setOnClickListener(this);
        mIbCategory.setOnClickListener(this);
        mIbCart.setOnClickListener(this);
        mIbPersonal.setOnClickListener(this);
        select(mIbHome);
    }
    private void select(View v){
        mIbHome.setImageResource(R.drawable.tab_item_home_normal);
        mIbPersonal.setImageResource(R.drawable.tab_item_personal_normal);
        mIbCart.setImageResource(R.drawable.tab_item_cart_normal);
        mIbCategory.setImageResource(R.drawable.tab_item_category_normal);
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        if (homeFragment!=null){
            fragmentTransaction.hide(homeFragment);
        }
        if(categroyFragment!=null){
            fragmentTransaction.hide(categroyFragment);
        }
        if (cartFragment!=null){
            fragmentTransaction.hide(cartFragment);
        }
        if (personalFrament!=null){
            fragmentTransaction.hide(personalFrament);
        }
        switch (v.getId()){
            case R.id.ib_home:
                mIbHome.setImageResource(R.drawable.tab_item_home_focus);
                if (homeFragment==null){
                      homeFragment=new HomeFragment();
                      fragmentTransaction.add(R.id.f1_main_navigation,homeFragment);
                  }else {
                     fragmentTransaction.show(homeFragment);
                        }
                  break;
            case R.id.ib_category:
                mIbCategory.setImageResource(R.drawable.tab_item_category_focus);
                if(categroyFragment==null){
                    categroyFragment=new CategroyFragment();
                    fragmentTransaction.add(R.id.f1_main_navigation,categroyFragment);
                }else{
                    fragmentTransaction.show(categroyFragment);
                }
                break;
            case R.id.ib_cart:
                mIbCart.setImageResource(R.drawable.tab_item_cart_focus);
                if (cartFragment==null){
                    cartFragment=new CartFragment();
                    fragmentTransaction.add(R.id.f1_main_navigation,cartFragment);
                }else {
                    fragmentTransaction.show(cartFragment);
                }
                break;
            case R.id.ib_personal:
                mIbPersonal.setImageResource(R.drawable.tab_item_personal_focus);
                if(personalFrament==null){
                    personalFrament=new PersonalFragment();
                    fragmentTransaction.add(R.id.f1_main_navigation,personalFrament);
                }else {
                    fragmentTransaction.show(personalFrament);
                }
                break;
        }
        fragmentTransaction.commit();
    }
    public void onClick(View v){
        select(v);
    }
}
