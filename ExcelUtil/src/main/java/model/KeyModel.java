package model;

import java.util.List;

public class KeyModel {
    public String keyHeader;
    public List<String> attributes;

    public String getKeyHeader() {
        return this.keyHeader;
    }

    public void setKeyHeader(String keyHeader) {
        this.keyHeader = keyHeader;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }
}
