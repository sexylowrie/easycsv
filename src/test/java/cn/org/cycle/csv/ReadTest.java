package cn.org.cycle.csv;


import cn.org.cycle.csv.demo.Demo;
import cn.org.cycle.csv.demo.DemoWithAnnotation;
import cn.org.cycle.csv.demo.TitleDemo;
import org.junit.Test;

import java.util.List;

public class ReadTest {


    /**
     * 使用默认参数输出CSV文件
     */
    @Test
    public void readSpecifyDefault() {
        System.out.println("=================================================");
        List<?> objects = EasyCsv.read("./spe_default.csv", Demo.class).build().doRead();
        for (Object o : objects) {
            System.out.println(o.toString());
        }
        System.out.println("================Read in default=================");
    }

    @Test
    public void readSpecifyGBK() {
        System.out.println("=================================================");
        List<?> objects = EasyCsv.read("./spe_gbk.csv", Demo.class).charset("GBK").build().doRead();
        for (Object o : objects) {
            System.out.println(o.toString());
        }
        System.out.println("================Read in gbk=================");
    }

    @Test
    public void readSpecifySplit() {
        System.out.println("=================================================");
        List<?> objects = EasyCsv.read("./spe_split.csv", Demo.class).split(";").build().doRead();
        for (Object o : objects) {
            System.out.println(o.toString());
        }
        System.out.println("================Read in split=================");
    }

    @Test
    public void readSpecifyRow() {
        System.out.println("=================================================");
        List<?> objects = EasyCsv.read("./spe_row.csv", Demo.class).row("\n").build().doRead();
        for (Object o : objects) {
            System.out.println(o.toString());
        }
        System.out.println("================Read in row=================");
    }

    @Test
    public void readSpecifyPrefix() {
        System.out.println("=================================================");
        List<?> objects = EasyCsv.read("./spe_prefix.csv", Demo.class).prefix("'").build().doRead();
        for (Object o : objects) {
            System.out.println(o.toString());
        }
        System.out.println("================Read in prefix=================");
    }


    @Test
    public void readSpecifyTitled() {
        System.out.println("=================================================");
        List<?> objects = EasyCsv.read("./spe_titled.csv", Demo.class).titled(false).build().doRead();
        for (Object o : objects) {
            System.out.println(o.toString());
        }
        System.out.println("================Read in titled=================");
    }

    @Test
    public void readSpecifyAnnotation() {
        System.out.println("=================================================");
        List<?> objects = EasyCsv.read("./spe_annotation.csv", DemoWithAnnotation.class).build().doRead();
        for (Object o : objects) {
            System.out.println(o.toString());
        }
        System.out.println("================Read in annotation=================");
    }

    @Test
    public void readSpecifyHead() {
        System.out.println("=================================================");
        List<?> objects = EasyCsv.read("./spe_head_read.csv", TitleDemo.class).build().doRead();
        for (Object o : objects) {
            System.out.println(o.toString());
        }
        System.out.println("================Read in head=================");
    }


}
