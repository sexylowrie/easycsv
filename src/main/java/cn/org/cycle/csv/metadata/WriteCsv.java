package cn.org.cycle.csv.metadata;

import java.io.File;
import java.io.OutputStream;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020/11/26
 */
public class WriteCsv {

    private File file;

    private OutputStream outputStream;

    private Class head;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public Class getHead() {
        return head;
    }

    public void setHead(Class head) {
        this.head = head;
    }
}
