package p2_io_obj.model;

import java.io.Serializable;

public class Student implements Serializable {
    private String id;
    private String name;

    public Student() {
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-15s", id, name);
    }
}
