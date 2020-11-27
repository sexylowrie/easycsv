package cn.org.cycle.csv.write.builder;

import cn.org.cycle.csv.context.WriteContext;
import cn.org.cycle.csv.context.WriteContextImpl;
import cn.org.cycle.csv.metadata.WriteCsv;

import java.util.List;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020/11/26
 */
public class CsvBuilderImpl implements CsvBuilder {

    private WriteContext writeContext;

    public CsvBuilderImpl(WriteCsv writeCsv) {
        writeContext = new WriteContextImpl(writeCsv);
    }

    @Override
    public void addContent(List data) {
//        writeContext
    }

    @Override
    public void finish() {
        writeContext.finish();
    }
}
