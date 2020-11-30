package cn.org.cycle.csv.read;

import cn.org.cycle.csv.CsvReader;
import cn.org.cycle.csv.metadata.ReadCsv;

import java.io.File;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020/11/30
 */
public class CsvReaderBuilder {

    private ReadCsv readCsv;

    public CsvReaderBuilder() {
        this.readCsv = new ReadCsv();
    }

    public CsvReader build() {
        CsvReader csvReader = new CsvReader(readCsv);
        return csvReader;
    }

    public void head(Class head) {
        this.readCsv.setHead(head);
    }

    public void file(String pathName) {
        this.file(new File(pathName));
    }

    public void file(File outputFile) {
        this.readCsv.setFile(outputFile);
    }

}
