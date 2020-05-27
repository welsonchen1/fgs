package fgsweb;

import java.io.Serializable;

public class Document
	implements Serializable, Comparable<Document> {

    private String name;
    private String size;
    private String type;

    public Document(String name, String size, String type) {
	this.name = name;
	this.size = size;
	this.type = type;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getSize() {
	return size;
    }

    public void setSize(String size) {
	this.size = size;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    @Override
    public int compareTo(Document arg0) {
	// TODO Auto-generated method stub
	return 0;
    }
}
