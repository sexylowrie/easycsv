package cn.org.cycle.csv;

import cn.org.cycle.csv.annotation.CsvProperty;
import cn.org.cycle.csv.metadata.MetaCsv;
import net.sf.cglib.beans.BeanMap;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
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

    private static final String DEFAULT_TITLE = "标题";

    private final MetaCsv metaCsv;

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

    public void doWrite(List<?> data) {
        if (null == fileWriter) {
            throw new RuntimeException("create fileWriter failed!");
        }
        this.writeContent(data);
        this.finish();
    }

    private void writeContent(List<?> data) {
        try {
            writeHead(data);
            for (Object row : data) {
                writeRow(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 支持多维度Heap Map
     *
     * @param data
     * @throws IOException
     */
    private void writeHead(List<?> data) throws IOException {
        headMap = new TreeMap<>();
        Class<?> clazz = metaCsv.getHead();
        if (null != clazz) {
            writeClassHead(clazz);
            return;
        }

        if (null != data && data.size() > 0) {
            writeClassHead(data.get(0).getClass());
        }
    }


    private void writeClassHead(Class<?> head) throws IOException {
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
        if (metaCsv.getTitled()) {
            fileWriter.write(builder.toString());
        }
    }


    private void writeRow(Object row) throws IOException {
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
