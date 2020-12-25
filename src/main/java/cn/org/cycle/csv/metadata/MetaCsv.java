package cn.org.cycle.csv.metadata;

import java.io.File;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020/11/30
 */
public class MetaCsv {

    private File file;

    private Class<?> head;

    /**
     * 默认编码格式
     */
    private String charset = "UTF-8";

    /**
     * 默认前缀
     */
    private String prefix = "`";

    /**
     * 默认换行符
     */
    private String row = "\r\n";

    /**
     * 默认分割符
     */
    private String split = ",";

    /**
     * 默认书写/读取标题行
     */
    private Boolean titled = true;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Class<?> getHead() {
        return head;
    }

    public void setHead(Class<?> head) {
        this.head = head;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getSplit() {
        return split;
    }

    public void setSplit(String split) {
        this.split = split;
    }

    public Boolean getTitled() {
        return titled;
    }

    public void setTitled(Boolean titled) {
        this.titled = titled;
    }
}
