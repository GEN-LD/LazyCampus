package scut.toothpick.lazycampus.bean;

/**
 * Created by dgliang on 2018/6/21.
 */

public class TaskBean {

    /**
     * id : 1
     * type : 1
     * content : 华工一饭天桥边，有两个快递，分别是四号柜和五号柜
     * state : 0
     * publish_id : 201566612138
     * receive_id : 201595279527
     * publish_time : null
     * receive_time : null
     * finish_time : null
     * money : null
     */

    private String id;
    private String type;
    private String content;
    private String state;
    private String publish_id;
    private String receive_id;
    private String publish_time;
    private String receive_time;
    private String finish_time;
    private int money;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPublish_id() {
        return publish_id;
    }

    public void setPublish_id(String publish_id) {
        this.publish_id = publish_id;
    }

    public String getReceive_id() {
        return receive_id;
    }

    public void setReceive_id(String receive_id) {
        this.receive_id = receive_id;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getReceive_time() {
        return receive_time;
    }

    public void setReceive_time(String receive_time) {
        this.receive_time = receive_time;
    }

    public String getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(String finish_time) {
        this.finish_time = finish_time;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
