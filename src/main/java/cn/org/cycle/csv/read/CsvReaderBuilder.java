package cn.org.cycle.csv.read;

import cn.org.cycle.csv.CsvReader;
import cn.org.cycle.csv.metadata.MetaCsv;

import java.io.File;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020/11/30
 */
public class CsvReaderBuilder {

    private final MetaCsv readCsv;

    public CsvReaderBuilder() {
        this.readCsv = new MetaCsv();
    }

    public CsvReader build() {
        return new CsvReader(readCsv);
    }

    public void charset(String charset) {
        this.readCsv.setCharset(charset);
    }

    public void head(Class<?> head) {
        this.readCsv.setHead(head);
    }

    public void file(String path) {
        this.file(new File(path));
    }

    public void file(File file) {
        this.readCsv.setFile(file);
    }

}
