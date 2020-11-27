package cn.org.cycle.csv.write.builder;

import java.util.List;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020/11/26
 */
public interface CsvBuilder {

    /**
     * Write data to a csv
     *
     * @param data     Data to be written
     */
    void addContent(List data);

    /**
     * Close stream
     */
    void finish();


}
