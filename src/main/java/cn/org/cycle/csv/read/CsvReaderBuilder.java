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

    private final MetaCsv metaCsv;

    public CsvReaderBuilder() {
        this.metaCsv = new MetaCsv();
    }

    public CsvReader build() {
        return new CsvReader(metaCsv);
    }

    public CsvReaderBuilder charset(String charset) {
        this.metaCsv.setCharset(charset);
        return this;
    }

    public CsvReaderBuilder prefix(String prefix) {
        this.metaCsv.setPrefix(prefix);
        return this;
    }

    public CsvReaderBuilder row(String row) {
        this.metaCsv.setRow(row);
        return this;
    }

    public CsvReaderBuilder split(String split) {
        this.metaCsv.setSplit(split);
        return this;
    }

    public CsvReaderBuilder titled(Boolean bool) {
        this.metaCsv.setTitled(bool);
        return this;
    }

    public void head(Class<?> head) {
        this.metaCsv.setHead(head);
    }

    public void file(String path) {
        this.file(new File(path));
    }

    public void file(File file) {
        this.metaCsv.setFile(file);
    }

}
