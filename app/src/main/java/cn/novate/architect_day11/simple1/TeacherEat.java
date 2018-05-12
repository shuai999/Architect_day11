package cn.novate.architect_day11.simple1;

import android.util.Log;

/**
 * Created by Administrator on 2018/5/12.
 */

public class TeacherEat implements Eat {


    @Override
    public void eat() {
        Log.e("TAG" , "喝个汤") ;
        Log.e("TAG" , "点个菜") ;
        Log.e("TAG" , "人吃饭吃菜") ;
        Log.e("TAG" , "盘子不用送") ;
    }
}
