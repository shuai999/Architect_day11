package cn.novate.architect_day11.simple1;

import android.util.Log;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/5/12 16:43
 * Version 1.0
 * Params:
 * Description:    人吃饭 - 吃饭是一种行为
*/

public class PersonEat implements Eat {

    @Override
    public void eat() {
        Log.e("TAG" , "人吃饭吃菜") ;
    }
}
