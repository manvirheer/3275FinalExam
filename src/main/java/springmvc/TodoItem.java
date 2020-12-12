package springmvc;

public class TodoItem {

    public int id;
    public String item;
    public String time;
    public String priority;

    public TodoItem(int id, String item, String time, String priority) {
        this.id = id;
        this.item = item;
        this.time = time;
        this.priority = priority;
    }

    public TodoItem(String item, String time, String priority) {
        this.item = item;
        this.time = time;
        this.priority = priority;
    }

    public TodoItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
