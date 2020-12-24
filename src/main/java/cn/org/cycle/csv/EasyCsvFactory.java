package cn.org.cycle.csv;

import cn.org.cycle.csv.read.CsvReaderBuilder;
import cn.org.cycle.csv.write.CsvWriterBuilder;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020/11/26
 */
public class EasyCsvFactory {

    public static CsvWriterBuilder write(String pathName) {
        return write(pathName, null);
    }

    public static CsvWriterBuilder write(String pathName, Class<?> head) {
        CsvWriterBuilder writerBuilder = new CsvWriterBuilder();
        writerBuilder.file(pathName);
        if (head != null) {
            writerBuilder.head(head);
        }
        return writerBuilder;
    }


    public static CsvReaderBuilder read(String pathName) {
        return read(pathName, null);
    }

    public static CsvReaderBuilder read(String pathName, Class<?> head) {
        CsvReaderBuilder readerBuilder = new CsvReaderBuilder();
        readerBuilder.file(pathName);
        if (head != null) {
            readerBuilder.head(head);
        }
        return readerBuilder;
    }

}
