package scut.toothpick.lazycampus.entity;

/**
 * Created by dgliang on 2018/7/2.
 */

public class StateType {
    int id;
    String state;

    public StateType(int id, String state) {
        this.id = id;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
