package application;

public class Message {
    final int id;
    final String method;
    final String value;

    public Message(int id, String method, String value) {
        this.id = id;
        this.method = method;
        this.value = value;
    }

    @Override
    public String toString() {
        String str = Integer.toString(id) + " " +
                method + " " +
                value;
        return str;
    }
}
