package scut.toothpick.lazycampus.bean;

/**
 * Created by dgliang on 2018/6/21.
 */

public class ServiceBean {

    /**
     * id : 1
     * type : 1
     * content : 今天中午12-14点可以帮拿快递，无论多少都接，大件也接，只限二饭马路边的快递
     * state : 2
     * publisher_id : 20156661213
     * receiver_id : 201595279527
     * publish_time : null
     * receive_time : null
     * finish_time : null
     * money : null
     */

    private String id;
    private String type;
    private String content;
    private String state;
    private String publisher_id;
    private String receiver_id;
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

    public String getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(String publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(String receiver_id) {
        this.receiver_id = receiver_id;
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
