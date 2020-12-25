package cn.org.cycle.csv;


import cn.org.cycle.csv.demo.Demo;
import cn.org.cycle.csv.demo.DemoWithAnnotation;
import cn.org.cycle.csv.demo.TitleDemo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Write Csv Test
 *
 * @author lowrie
 * @date 2020-12-25
 */
public class WriteTest {


    /**
     * 使用默认参数输出CSV文件
     */
    @Test
    public void writeSpecifyDefault() {
        System.out.println("=================================================");
        EasyCsv.write("./spe_default.csv").build().doWrite(data());
        System.out.println("================Write in default=================");
    }

    /**
     * 指定编码GBK输出CSV文件
     */
    @Test
    public void writeSpecifyGBK() {
        System.out.println("=================================================");
        EasyCsv.write("./spe_gbk.csv").charset("GBK").build().doWrite(data());
        System.out.println("================Write in GBK=================");
    }

    /**
     * 指定分隔符输出CSV文件
     */
    @Test
    public void writeSpecifySplit() {
        System.out.println("=================================================");
        EasyCsv.write("./spe_split.csv").split(";").build().doWrite(data());
        System.out.println("================Write in split ;=================");
    }

    /**
     * 指定换行符输出CSV文件
     */
    @Test
    public void writeSpecifyRow() {
        System.out.println("=================================================");
        EasyCsv.write("./spe_row.csv").row("\n").build().doWrite(data());
        System.out.println("==================Write in row===================");
    }

    /**
     * 指定前缀输出CSV文件
     */
    @Test
    public void writeSpecifyPrefix() {
        System.out.println("=================================================");
        EasyCsv.write("./spe_prefix.csv").prefix("'").build().doWrite(data());
        System.out.println("================Write in prefix==================");
    }

    /**
     * 指定输出CSV文件不包含标题行
     */
    @Test
    public void writeSpecifyTitled() {
        System.out.println("=================================================");
        EasyCsv.write("./spe_titled.csv").titled(false).build().doWrite(data());
        System.out.println("================Write in titled==================");
    }

    /**
     * 指定注解文件输出CSV文件
     */
    @Test
    public void writeSpecifyAnnotation() {
        System.out.println("=================================================");
        EasyCsv.write("./spe_annotation.csv").build().doWrite(dataWithAnnotation());
        System.out.println("===============Write in annotation================");
    }


    /**
     * 指定列标题输出CSV文件
     * 不在指定列标题范围，不会输出
     */
    @Test
    public void writeSpecifyHead() {
        System.out.println("=================================================");
        EasyCsv.write("./spe_head.csv", TitleDemo.class).build().doWrite(dataWithAnnotation());
        System.out.println("===============Write in demo================");
    }

    public List<Demo> data() {
        List<Demo> data = new ArrayList<>();
        data.add(new Demo("数据1.1", "数据1.2", "数据1.3"));
        data.add(new Demo("数据2.1", "数据2.2", null));
        data.add(new Demo("数据3.1", null, null));
        data.add(new Demo("数据4.1", "数据4.2", null));
        data.add(new Demo("数据5.1", "数据5.2", "数据5.3"));
        return data;
    }

    public List<DemoWithAnnotation> dataWithAnnotation() {
        List<DemoWithAnnotation> data = new ArrayList<>();
        data.add(new DemoWithAnnotation("数据1.1", "数据1.2", "数据1.3", "数据1.4"));
        data.add(new DemoWithAnnotation("数据2.1", "数据2.2", "数据2.3"));
        data.add(new DemoWithAnnotation("数据3.1", "数据3.2", null));
        data.add(new DemoWithAnnotation("数据4.1", null, null));
        data.add(new DemoWithAnnotation("数据5.1", "数据5.2", null));
        data.add(new DemoWithAnnotation("数据6.1", "数据6.2", "数据6.3"));
        data.add(new DemoWithAnnotation("数据7.1", "数据7.2", "数据7.3", "数据7.4"));
        return data;
    }


}
