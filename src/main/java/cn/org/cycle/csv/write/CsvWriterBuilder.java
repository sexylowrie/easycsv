package cn.org.cycle.csv.write;

import cn.org.cycle.csv.CsvWriter;
import cn.org.cycle.csv.metadata.WriteCsv;

import java.io.File;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020/11/26
 */
public class CsvWriterBuilder {

    private WriteCsv writeCsv;

    public CsvWriterBuilder() {
        this.writeCsv = new WriteCsv();
    }

    public CsvWriter build() {
        CsvWriter csvWriter = new CsvWriter(writeCsv);
        return csvWriter;
    }

    public void charset(String charsetName) {
        this.writeCsv.setCharset(charsetName);
    }

    public void head(Class head) {
        this.writeCsv.setHead(head);
    }

    public void file(String pathName) {
        this.file(new File(pathName));
    }

    public void file(File outputFile) {
        this.writeCsv.setFile(outputFile);
    }

}
