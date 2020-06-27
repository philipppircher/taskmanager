package cc.phil.tasks;

public class TaskVO {
    // Membervariables
    //
    private int id;
    private String name;

    // Constructor
    //
    public TaskVO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter/Setter
    //
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
