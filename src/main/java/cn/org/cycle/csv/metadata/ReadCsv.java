package cn.org.cycle.csv.metadata;

import java.io.File;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020/11/30
 */
public class ReadCsv {

    public ReadCsv() {
        this.charset = "UTF-8";
    }

    private File file;

    private Class head;

    private String charset;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Class getHead() {
        return head;
    }

    public void setHead(Class head) {
        this.head = head;
    }


    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }
}
