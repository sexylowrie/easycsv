package cn.org.cycle.csv.write;

import cn.org.cycle.csv.CsvWriter;
import cn.org.cycle.csv.metadata.MetaCsv;

import java.io.File;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020/11/26
 */
public class CsvWriterBuilder {

    private final MetaCsv metaCsv;

    public CsvWriterBuilder() {
        this.metaCsv = new MetaCsv();
    }

    public CsvWriter build() {
        return new CsvWriter(metaCsv);
    }

    public CsvWriterBuilder charset(String charset) {
        this.metaCsv.setCharset(charset);
        return this;
    }

    public CsvWriterBuilder prefix(String prefix) {
        this.metaCsv.setPrefix(prefix);
        return this;
    }

    public CsvWriterBuilder row(String row) {
        this.metaCsv.setRow(row);
        return this;
    }

    public CsvWriterBuilder split(String split) {
        this.metaCsv.setSplit(split);
        return this;
    }

    public CsvWriterBuilder titled(Boolean bool) {
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
