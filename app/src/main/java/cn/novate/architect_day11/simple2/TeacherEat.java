package cn.novate.architect_day11.simple2;

import android.util.Log;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/5/12 17:03
 * Version 1.0
 * Params:
 * Description:    老师吃饭
*/

public class TeacherEat implements Eat {

    private Eat eat ;

    /**
     * 给老师吃饭传入 人吃饭的构造参数
     */
    public TeacherEat(PersonEat eat){
        this.eat = eat ;
    }


    @Override
    public void eat() {
        Log.e("TAG" , "喝个汤") ;
        Log.e("TAG" , "点个菜") ;
        eat.eat();
        Log.e("TAG" , "盘子不用送") ;
    }
}
