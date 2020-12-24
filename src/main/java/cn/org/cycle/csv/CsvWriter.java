package cn.org.cycle.csv;

import cn.org.cycle.csv.annotation.CsvProperty;
import cn.org.cycle.csv.metadata.WriteCsv;
import net.sf.cglib.beans.BeanMap;

import java.io.*;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020/11/26
 */
public class CsvWriter {

    private WriteCsv writeCsv;

    private BufferedWriter fileWriter;

    /**
     * 分隔符
     */
    public static final String COMMAR = ",";
    /**
     * 前缀
     */
    public static final String PREFIX = "`";
    /**
     * 换行
     */
    public static final String ROW = "\r\n";

    private Map<Integer, String> headMap;

    public CsvWriter(WriteCsv writeCsv) {
        this.writeCsv = writeCsv;
        try {
            this.fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writeCsv.getFile()), writeCsv.getCharset()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void doWrite(List data) {
        if (null == fileWriter) {
            throw new RuntimeException("create fileWriter failed!");
        }
        this.writeContent(data);
        this.finish();
    }

    private void writeContent(List data) {
        try {
            if (null != writeCsv.getHead()) {
                headMap = new TreeMap<>();
                writeHead(writeCsv.getHead());
            }
            for (Object row : data) {
                addRow(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeHead(Class head) throws IOException {
        StringBuilder builder = new StringBuilder();
        Field[] fields = head.getDeclaredFields();
        int index = 0;
        for (Field field : fields) {
            CsvProperty property = field.getAnnotation(CsvProperty.class);
            if (property == null) {
                builder.append(PREFIX).append(field.getName());
            } else {
                builder.append(PREFIX).append(property.value());
            }
            headMap.put(index, field.getName());
            if (++index != fields.length) {
                builder.append(COMMAR);
            }
        }
        builder.append(ROW);
        fileWriter.write(builder.toString());
    }


    private void addRow(Object row) throws IOException {
        StringBuilder builder = new StringBuilder();
        BeanMap beanMap = BeanMap.create(row);
        int index = 0;
        if (null != headMap && headMap.size() > 0) {
            Set<Map.Entry<Integer, String>> entries = headMap.entrySet();
            for (Map.Entry<Integer, String> entry : entries) {
                String name = entry.getValue();
                builder.append(PREFIX);
                if (!beanMap.containsKey(name)) {
                    continue;
                }
                Object value = beanMap.get(name);
                if (null != value) {
                    builder.append(value);
                }

                if (++index != headMap.size()) {
                    builder.append(COMMAR);
                }
            }
        } else {
            Set<Map.Entry> entries = beanMap.entrySet();
            for (Map.Entry entry : entries) {
                Object value = entry.getValue();
                builder.append(PREFIX);
                if (null != value) {
                    builder.append(value);
                }
                if (++index != entries.size()) {
                    builder.append(COMMAR);
                }
            }
        }
        builder.append(ROW);
        fileWriter.write(builder.toString());
    }


    private void finish() {
        try {
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
