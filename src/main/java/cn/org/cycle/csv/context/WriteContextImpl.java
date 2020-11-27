package cn.org.cycle.csv.context;

import cn.org.cycle.csv.annotation.CsvProperty;
import cn.org.cycle.csv.metadata.WriteCsv;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.TreeMap;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020/11/26
 */
public class WriteContextImpl implements WriteContext {

    private WriteCsv writeCsv;

    private Map<Integer, Field> indexFieldMap;

    private Map<Integer, String> headMap;

    public WriteContextImpl(WriteCsv writeCsv) {
        indexFieldMap = new TreeMap<>();
        headMap = new TreeMap<>();
        this.writeCsv = writeCsv;
        initBasic();
    }

    private void initBasic() {
        initHead(writeCsv.getHead());

    }

    private void initHead(Class head) {
        if (head == null) {
            return;
        }
        Field[] fields = head.getDeclaredFields();
        int index = 0;
        for (Field field : fields) {
            CsvProperty csvProperty = field.getAnnotation(CsvProperty.class);
            indexFieldMap.put(index, field);
            headMap.put(index, csvProperty.value());
            index++;
        }

    }

    @Override
    public void finish() {

    }
}
