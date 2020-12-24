package cn.org.cycle.csv;


import cn.org.cycle.csv.demo.Demo;
import cn.org.cycle.csv.demo.DemoWithAnnotation;
import cn.org.cycle.csv.read.CsvReaderBuilder;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ReadTest {


    @Test
    public void simpleRead() {
        System.out.println("=================================================");
        List<?> data1 = EasyCsv.read("./test1.csv").build().doRead();
        System.out.println("result:" + data1);
        System.out.println("====================No Head======================");
        List<?> data2 = EasyCsv.read("./test2.csv", Demo.class).build().doRead();
        System.out.println("result:" + data2);
        System.out.println("====================With Head======================");
        List<?> data3 = EasyCsv.read("./test3.csv", DemoWithAnnotation.class).build().doRead();
        System.out.println("result:" + data3);
        System.out.println("====================With Annotation======================");
        List<?> data4 = EasyCsv.read("./test5.csv", DemoWithAnnotation.class).build().doRead();
        System.out.println("result:" + data4);
        System.out.println("====================With Annotation======================");
    }


    @Test
    public void simpleRead2() throws IOException {
        System.out.println("=================================================");
        CsvReaderBuilder readerBuilder = EasyCsv.read("./20201223.csv");
        readerBuilder.charset("GBK");
        List<?> data1 = readerBuilder.build().doRead();
        System.out.println("result:" + data1);
    }

}