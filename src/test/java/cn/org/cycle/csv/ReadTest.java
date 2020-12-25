package cn.org.cycle.csv;


import cn.org.cycle.csv.demo.Demo;
import cn.org.cycle.csv.demo.DemoWithAnnotation;
import cn.org.cycle.csv.demo.SpecifyDemo;
import cn.org.cycle.csv.demo.TitleDemo;
import org.junit.Test;

import java.util.List;

public class ReadTest {


    /**
     * 使用默认参数读取CSV文件
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

    /**
     * 使用默认参数读取GBK编码CSV文件
     */
    @Test
    public void readSpecifyGBK() {
        System.out.println("=================================================");
        List<?> objects = EasyCsv.read("./spe_gbk.csv", Demo.class).charset("GBK").build().doRead();
        for (Object o : objects) {
            System.out.println(o.toString());
        }
        System.out.println("================Read in gbk=================");
    }

    /**
     * 使用默认参数读取指定split格式CSV文件
     */
    @Test
    public void readSpecifySplit() {
        System.out.println("=================================================");
        List<?> objects = EasyCsv.read("./spe_split.csv", Demo.class).split(";").build().doRead();
        for (Object o : objects) {
            System.out.println(o.toString());
        }
        System.out.println("================Read in split=================");
    }

    /**
     * 使用默认参数读取指定换行符CSV文件
     * TODO 此处无明显意义
     */
    @Test
    public void readSpecifyRow() {
        System.out.println("=================================================");
        List<?> objects = EasyCsv.read("./spe_row.csv", Demo.class).row("\n").build().doRead();
        for (Object o : objects) {
            System.out.println(o.toString());
        }
        System.out.println("================Read in row=================");
    }

    /**
     * 使用默认参数读取指定前缀CSV文件
     */
    @Test
    public void readSpecifyPrefix() {
        System.out.println("=================================================");
        List<?> objects = EasyCsv.read("./spe_prefix.csv", Demo.class).prefix("'").build().doRead();
        for (Object o : objects) {
            System.out.println(o.toString());
        }
        System.out.println("================Read in prefix=================");
    }

    /**
     * 使用默认参数读取指定无标题CSV文件
     */
    @Test
    public void readSpecifyTitled() {
        System.out.println("=================================================");
        List<?> objects = EasyCsv.read("./spe_titled.csv", Demo.class).titled(false).build().doRead();
        for (Object o : objects) {
            System.out.println(o.toString());
        }
        System.out.println("================Read in titled=================");
    }

    /**
     * 使用默认参数读取指定注解CSV文件
     */
    @Test
    public void readSpecifyAnnotation() {
        System.out.println("=================================================");
        List<?> objects = EasyCsv.read("./spe_annotation.csv", DemoWithAnnotation.class).build().doRead();
        for (Object o : objects) {
            System.out.println(o.toString());
        }
        System.out.println("================Read in annotation=================");
    }

    /**
     * 使用默认参数读取指定标题格式CSV文件
     * 不包含的不读取
     */
    @Test
    public void readSpecifyHead() {
        System.out.println("=================================================");
        List<?> objects = EasyCsv.read("./spe_annotation.csv", TitleDemo.class).build().doRead();
        for (Object o : objects) {
            System.out.println(o.toString());
        }
        System.out.println("================Read in head=================");
    }

    /**
     * 使用默认参数读取指定标题格式CSV文件
     * 不包含的不读取
     */
    @Test
    public void readSpecify() {
        System.out.println("=================================================");
        List<?> objects = EasyCsv.read("./spe_annotation.csv", SpecifyDemo.class).build().doRead();
        for (Object o : objects) {
            System.out.println(o.toString());
        }
        System.out.println("================Read in specify=================");
    }


}
