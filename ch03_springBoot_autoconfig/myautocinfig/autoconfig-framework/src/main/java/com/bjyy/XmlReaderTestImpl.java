package com.bjyy;

import lombok.Data;

/**
 * @author Aurora
 * @date 2026年01月01日 12:27
 */
@Data
public class XmlReaderTestImpl implements XmlReaderTest {
    private String xml;
    private String path;
    private boolean isFile;
    private int size;

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean file) {
        isFile = file;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "XmlReaderImpl{" +
                "xml='" + xml + '\'' +
                ", path='" + path + '\'' +
                ", isFile=" + isFile +
                ", size=" + size +
                '}';
    }
}
