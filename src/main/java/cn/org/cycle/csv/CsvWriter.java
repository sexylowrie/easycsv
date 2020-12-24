package cn.org.cycle.csv;

import cn.org.cycle.csv.annotation.CsvProperty;
import cn.org.cycle.csv.metadata.MetaCsv;
import net.sf.cglib.beans.BeanMap;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
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

    private MetaCsv metaCsv;

    private BufferedWriter fileWriter;

    private Map<Integer, String> headMap;

    public CsvWriter(MetaCsv metaCsv) {
        this.metaCsv = metaCsv;
        try {
            this.fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(metaCsv.getFile()), metaCsv.getCharset()));
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
            if (null != metaCsv.getHead()) {
                headMap = new TreeMap<>();
                writeHead(metaCsv.getHead());
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
                builder.append(metaCsv.getPrefix()).append(field.getName());
            } else {
                builder.append(metaCsv.getPrefix()).append(property.value());
            }
            headMap.put(index, field.getName());
            if (++index != fields.length) {
                builder.append(metaCsv.getSplit());
            }
        }
        builder.append(metaCsv.getRow());
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
                builder.append(metaCsv.getPrefix());
                if (!beanMap.containsKey(name)) {
                    continue;
                }
                Object value = beanMap.get(name);
                if (null != value) {
                    builder.append(value);
                }

                if (++index != headMap.size()) {
                    builder.append(metaCsv.getSplit());
                }
            }
        } else {
            Set<Map.Entry> entries = beanMap.entrySet();
            for (Map.Entry entry : entries) {
                Object value = entry.getValue();
                builder.append(metaCsv.getPrefix());
                if (null != value) {
                    builder.append(value);
                }
                if (++index != entries.size()) {
                    builder.append(metaCsv.getSplit());
                }
            }
        }
        builder.append(metaCsv.getRow());
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
