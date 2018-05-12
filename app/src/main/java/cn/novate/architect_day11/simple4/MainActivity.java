package cn.novate.architect_day11.simple4;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import cn.novate.architect_day11.R;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/5/12 20:03
 * Version 1.0
 * Params:
 * Description:
*/

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            FileReader fileReader = new FileReader("xxx.file") ;
            // FileReader只能读取单个
            // fileReader.read() ;

            // 使用BufferedReader 把 FileReader包装之后，最终操作还是 FileReader
            BufferedReader br = new BufferedReader(fileReader) ;
            // 包装之后 ，就变得强大了，可以读一行 ，
            br.readLine() ;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
