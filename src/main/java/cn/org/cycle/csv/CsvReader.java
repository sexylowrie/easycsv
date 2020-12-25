package cn.org.cycle.csv;

import cn.org.cycle.csv.annotation.CsvProperty;
import cn.org.cycle.csv.metadata.MetaCsv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020/11/26
 */
public class CsvReader {

    private final MetaCsv metaCsv;

    private BufferedReader fileReader;

    private Map<String, String> paramMap;
    private Map<Integer, String> headMap;

    public CsvReader(MetaCsv metaCsv) {
        this.metaCsv = metaCsv;
        try {
            this.fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(metaCsv.getFile()), metaCsv.getCharset()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<?> doRead() {
        if (null == fileReader) {
            throw new RuntimeException("Create fileReader failed!");
        }
        if (null == metaCsv.getHead()) {
            throw new RuntimeException("ReadCsv must Specify Head!");
        }
        List<?> list = this.readContent();
        this.finish();
        return list;
    }

    private List<?> readContent() {
        paramMap = new HashMap<>();
        headMap = new TreeMap<>();
        initParamMap();
        List list = new ArrayList<>();
        String row;
        try {
            int index = 0;
            while (null != (row = fileReader.readLine())) {
                if (index == 0 && metaCsv.getTitled()) {
                    readHead(row);
                } else {
                    list.add(readRow(row));
                }
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void initParamMap() {
        int index = 0;
        Field[] fields = metaCsv.getHead().getDeclaredFields();
        for (Field field : fields) {
            CsvProperty property = field.getAnnotation(CsvProperty.class);
            String name = field.getName();
            paramMap.put(name, field.getName());
            if (null != property) {
                name = property.value();
                paramMap.put(name, field.getName());
            }

            if (!metaCsv.getTitled()) {
                headMap.put(index++, field.getName());
            }
        }
    }


    private void initHeadMap() {
        int index = 0;
        Field[] fields = metaCsv.getHead().getDeclaredFields();
        for (Field field : fields) {
            headMap.put(index++, field.getName());
        }
    }


    private void readHead(String row) {
        String[] data = row.split(metaCsv.getSplit());
        int index = 0;
        for (String param : data) {
            String replace = param.replace(metaCsv.getPrefix(), "").trim();
            String name;
            if (null != paramMap && paramMap.size() > 0) {
                name = paramMap.get(replace);
            } else {
                name = replace;
            }
            if (name != null && !"".equals(name)) {
                headMap.put(index++, name);
            }
        }
        if (null == headMap || headMap.size() == 0) {
            initHeadMap();
        }
    }

    private Object readRow(String row) {
        if (null == headMap || headMap.size() < 1) {
            throw new RuntimeException();
        }
        String[] data = row.split(metaCsv.getSplit());
        Class head = metaCsv.getHead();
        int index = 0;
        try {
            Object instance = head.newInstance();
            for (String param : data) {
                if (index >= headMap.size()) {
                    continue;
                }
                Field field = head.getDeclaredField(headMap.get(index));
                field.setAccessible(true);
                field.set(instance, param.replace(metaCsv.getPrefix(), "").trim());
                index++;
            }
            return instance;
        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void finish() {
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
