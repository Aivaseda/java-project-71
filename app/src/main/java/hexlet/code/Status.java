package hexlet.code;

public final class Status {
    private final String status;
    private final Object value1;
    private final Object value2;

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


