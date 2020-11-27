package cn.org.cycle.csv;


import cn.org.cycle.csv.demo.Demo;
import cn.org.cycle.csv.demo.DemoWithAnnotation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WriteTest {


    @Test
    public void simpleWrite() {
        System.out.println("=================================================");
        EasyCsv.write("./test1.csv").build().doWrite(data());
        System.out.println("=================write no head===================");
        EasyCsv.write("./test2.csv", Demo.class).build().doWrite(data());
        System.out.println("================write with head==================");
        EasyCsv.write("./test3.csv", DemoWithAnnotation.class).build().doWrite(dataWithAnnotation());
        System.out.println("=============write with Annotation===============");
    }

    public List data() {
        List data = new ArrayList();
        data.add(new Demo("aa", "bb", "cc"));
        data.add(new Demo("aa", "bb", ""));
        data.add(new Demo("aa", "", ""));
        data.add(new Demo("a", "b", "c"));
        data.add(new Demo("a", "b", ""));
        data.add(new Demo("a", "", ""));
        return data;
    }

    public List dataWithAnnotation() {
        List data = new ArrayList();
        data.add(new DemoWithAnnotation("aa", "bb", "cc"));
        data.add(new DemoWithAnnotation("aa", "bb", ""));
        data.add(new DemoWithAnnotation("aa", "", ""));
        data.add(new DemoWithAnnotation("a", "b", "c"));
        data.add(new DemoWithAnnotation("a", "b", ""));
        data.add(new DemoWithAnnotation("a", "", ""));
        return data;
    }





}
