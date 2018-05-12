package cn.novate.architect_day11.simple2;

import android.util.Log;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/5/12 16:44
 * Version 1.0
 * Params:
 * Description:    学生吃饭
*/

public class StudentEat implements Eat {

    private Eat eat ;

    /**
     * 给学生吃饭传入 人吃饭的构造参数
     */
    public StudentEat(PersonEat eat){
        this.eat = eat ;
    }
    @Override
    public void eat() {
        Log.e("TAG" , "学生点个菜") ;
        eat.eat();
        Log.e("TAG" , "盘子送回指定的地点") ;
    }
}
