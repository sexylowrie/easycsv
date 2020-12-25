package cn.org.cycle.csv;

import cn.org.cycle.csv.read.CsvReaderBuilder;
import cn.org.cycle.csv.write.CsvWriterBuilder;

import java.io.File;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020/11/26
 */
public class EasyCsvFactory {

    /**
     * Build csv the write
     *
     * @param path path to write
     * @return Csv writer builder
     */
    public static CsvWriterBuilder write(String path) {
        return write(path, null);
    }

    /**
     * Build csv the write
     *
     * @param file file to write
     * @return Csv writer builder
     */
    public static CsvWriterBuilder write(File file) {
        return write(file, null);
    }


    /**
     * Build csv the write
     *
     * @param path path to write
     * @param head head class
     * @return Csv writer builder
     */
    public static CsvWriterBuilder write(String path, Class<?> head) {
        CsvWriterBuilder writerBuilder = new CsvWriterBuilder();
        writerBuilder.file(path);
        if (head != null) {
            writerBuilder.head(head);
        }
        return writerBuilder;
    }

    /**
     * Build csv the write
     *
     * @param file file to write
     * @param head head class
     * @return Csv writer builder
     */
    public static CsvWriterBuilder write(File file, Class<?> head) {
        CsvWriterBuilder writerBuilder = new CsvWriterBuilder();
        writerBuilder.file(file);
        if (head != null) {
            writerBuilder.head(head);
        }
        return writerBuilder;
    }


    /**
     * Read csv from specify path
     *
     * @param path path to read
     * @param head head class
     * @return Csv reader builder
     */
    public static CsvReaderBuilder read(String path, Class<?> head) {
        CsvReaderBuilder readerBuilder = new CsvReaderBuilder();
        readerBuilder.file(path);
        readerBuilder.head(head);
        return readerBuilder;
    }

}
