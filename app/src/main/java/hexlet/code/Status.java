package hexlet.code;

public class Status {
    private String status;
    private Object value1;
    private Object value2;

    public String getStat() {
        return status;
    }
    public Object getValue1() {
        return value1;
    }
    public Object getValue2() {
        return value2;
    }

    public Status(String stat, Object value1, Object value2) {
        this.status = stat;
        this.value1 = value1;
        this.value2 = value2;
    }
}


