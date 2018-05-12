package cn.novate.architect_day11.simple1;

import android.util.Log;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/5/12 16:44
 * Version 1.0
 * Params:
 * Description:
*/

public class StudentEat implements Eat {
    @Override
    public void eat() {
        Log.e("TAG" , "学生点个菜") ;
        Log.e("TAG" , "人吃饭吃菜") ;
        Log.e("TAG" , "盘子送回指定的地点") ;
    }
}
