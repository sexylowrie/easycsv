package cn.org.cycle.csv.demo;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020/11/27
 */
public class TitleDemo {

    public TitleDemo() {
    }

    public TitleDemo(String title1, String title2, String title3) {
        this.title1 = title1;
        this.title2 = title2;
        this.title3 = title3;
    }

    private String title1;
    private String title2;
    private String title3;

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

    @Override
    public String toString() {
        return "TitleDemo{" +
                "title1='" + title1 + '\'' +
                ", title2='" + title2 + '\'' +
                ", title3='" + title3 + '\'' +
                '}';
    }
}
