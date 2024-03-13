package RestPackage;

import javax.xml.bind.annotation.*;
@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class MyRestClassModel {

    @XmlElement(name = "value")
    private String message;

    public MyRestClassModel() {
    }

    public MyRestClassModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}