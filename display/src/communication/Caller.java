package communication;

public class Caller {
    private String id;
    private String method;
    private String value;

    public Caller(String id, String method, String value) {
        this.id = id;
        this.method = method;
        this.value = value;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
