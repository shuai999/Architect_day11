package cn.novate.architect_day11.simple1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.novate.architect_day11.R;
import cn.novate.architect_day11.simple1.TeacherEat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 一般写法：new对象，调用方法
        TeacherEat teacherEat = new TeacherEat() ;
        teacherEat.eat();

        // 装饰设计模式怎样写？ 一般都是把类对象作为构造参数传递
    }
}
