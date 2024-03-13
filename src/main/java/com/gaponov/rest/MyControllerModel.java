package com.gaponov.rest;

import javax.xml.bind.annotation.*;
@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class MyControllerModel {

    @XmlElement(name = "value")
    private String message;

    public MyControllerModel() {
    }

    public MyControllerModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}