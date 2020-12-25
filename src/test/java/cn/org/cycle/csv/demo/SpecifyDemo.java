package cn.org.cycle.csv.demo;


import cn.org.cycle.csv.annotation.CsvProperty;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020/11/27
 */
public class SpecifyDemo {

    public SpecifyDemo() {
    }

    public SpecifyDemo(String title1, String title3) {
        this.title1 = title1;
        this.title3 = title3;
    }

    @CsvProperty("标题一")
    private String title1;
    @CsvProperty("标题三")
    private String title3;

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }


    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    @Override
    public String toString() {
        return "TitleDemo{" +
                "title1='" + title1 + '\'' +
                ", title3='" + title3 + '\'' +
                '}';
    }
}
