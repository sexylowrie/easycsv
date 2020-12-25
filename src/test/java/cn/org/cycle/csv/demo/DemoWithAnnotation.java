package cn.org.cycle.csv.demo;

import cn.org.cycle.csv.annotation.CsvProperty;

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

    public DemoWithAnnotation(String title1, String title2, String title3) {
        this.title1 = title1;
        this.title2 = title2;
        this.title3 = title3;
    }

    public DemoWithAnnotation(String title1, String title2, String title3, String title4) {
        this.title1 = title1;
        this.title2 = title2;
        this.title3 = title3;
        this.title4 = title4;
    }

    @CsvProperty(value = "标题一")
    private String title1;
    @CsvProperty(value = "标题二")
    private String title2;
    @CsvProperty(value = "标题三")
    private String title3;
    private String title4;

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    public String getTitle4() {
        return title4;
    }

    public void setTitle4(String title4) {
        this.title4 = title4;
    }

    @Override
    public String toString() {
        return "DemoWithAnnotation{" +
                "title1='" + title1 + '\'' +
                ", title2='" + title2 + '\'' +
                ", title3='" + title3 + '\'' +
                ", title4='" + title4 + '\'' +
                '}';
    }
}
