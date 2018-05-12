package cn.novate.architect_day11.simple2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.novate.architect_day11.R;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/5/12 17:06
 * Version 1.0
 * Params:
 * Description:
*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 装饰设计模式怎样写？ 一般都是把 类的对象作为构造的参数 传递
        // new对象 人吃饭
        PersonEat personEat = new PersonEat() ;

        // new具体的老师吃饭，然后把 人吃饭的类对象作为构造的参数 传递，然后调用方法
        TeacherEat teacherEat = new TeacherEat(personEat) ;
        teacherEat.eat();
    }
}
