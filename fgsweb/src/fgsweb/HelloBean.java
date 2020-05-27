package fgsweb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HelloBean
	implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name = "123";
    String message = "Hello Java Server Faces On Eclipse IDE!";

    public String getMessage() {
	return message;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
	message = message + name;
    }
}