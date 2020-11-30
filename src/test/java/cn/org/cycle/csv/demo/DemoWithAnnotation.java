package cn.org.cycle.csv.demo;

import cn.org.cycle.csv.annotation.CsvProperty;

import java.util.StringJoiner;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020/11/27
 */
public class DemoWithAnnotation {

    public DemoWithAnnotation() {
    }

    public DemoWithAnnotation(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @CsvProperty(value = "字段一")
    private String a;
    @CsvProperty(value = "字段二")
    private String b;
    @CsvProperty(value = "字段三")
    private String c;

    private String height;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", DemoWithAnnotation.class.getSimpleName() + "[", "]")
                .add("a='" + a + "'")
                .add("b='" + b + "'")
                .add("c='" + c + "'")
                .add("height='" + height + "'")
                .toString();
    }
}
