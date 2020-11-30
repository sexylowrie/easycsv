package cn.org.cycle.csv;

import cn.org.cycle.csv.annotation.CsvProperty;
import cn.org.cycle.csv.metadata.ReadCsv;
import net.sf.cglib.beans.BeanMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    private ReadCsv readCsv;

    private BufferedReader fileReader;

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

    private Map<String, String> paramMap;
    private Map<Integer, String> headMap;

    public CsvReader(ReadCsv readCsv) {
        this.readCsv = readCsv;
        try {
            this.fileReader = new BufferedReader(new FileReader(readCsv.getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<?> doRead() {
        if (null == fileReader) {
            throw new RuntimeException("create fileReader failed!");
        }
        List list = this.readContent();
        this.finish();
        return list;
    }

    private List readContent() {
        if (null != readCsv.getHead()) {
            paramMap = new HashMap<>();
            initParamMap(readCsv.getHead());
        }
        List list = new ArrayList();
        String row;
        try {
            int index = 0;
            while (null != (row = fileReader.readLine())) {
                if (index == 0) {
                    headMap = new TreeMap<>();
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

    private void readHead(String row) {
        String[] data = row.split(COMMAR);
        int index = 0;
        for (String param : data) {
            String replace = param.replace(PREFIX, "");
            String name;
            if (null != paramMap && paramMap.size() > 0) {
                name = paramMap.get(replace);
            } else {
                name = replace;
            }
            headMap.put(index, name);
            index++;
        }
    }

    private Object readRow(String row) {
        if (null == headMap || headMap.size() < 1) {
            throw new RuntimeException();
        }
        String[] data = row.split(COMMAR);
        Class head = readCsv.getHead();
        int index = 0;
        if (null != head) {
            try {
                Object instance = head.newInstance();
                for (String param : data) {
                    Field field = head.getDeclaredField(headMap.get(index));
                    //TODO 判断空指针
                    field.setAccessible(true);
                    field.set(instance, param.replace(PREFIX, ""));
                    index++;
                }
                return instance;
            } catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
                e.printStackTrace();
            }

        } else {
            HashMap map = new HashMap();
            for (String param : data) {
                map.put(headMap.get(index), param.replace(PREFIX, ""));
                index++;
            }
            return map;
        }
        return null;
    }

    private void initParamMap(Class<?> head) {
        Field[] fields = head.getDeclaredFields();
        for (Field field : fields) {
            CsvProperty property = field.getAnnotation(CsvProperty.class);
            String name;
            if (property == null) {
                name = field.getName();
            } else {
                name = property.value();
            }
            paramMap.put(name, field.getName());
        }
    }


    private void finish() {
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
