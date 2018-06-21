package scut.toothpick.lazycampus.entity;

import java.sql.Time;

/**
 * Created by dgliang on 2018/6/21.
 */

public class Task {
    private int id;
    private int type;
    private String content;
    private int state;
    private long publisherId;
    private long receiverId;
    private Time publishTime;
    private Time receiveTime;
    private Time finishTime;

    public Task(int id,int type,String content,int state,long publisherId,long receiverId,Time publishTime,Time receiveTime,Time finishTime){
        this.id = id;
        this.type = type;
        this.content = content;
        this.state = state;
        this.publisherId = publisherId;
        this.receiverId = receiverId;
        this.publishTime = publishTime;
        this.receiveTime = receiveTime;
        this.finishTime = finishTime;
    }
    public Task(int id,int type,String content,int state,long publisherId,long receiverId){
        this.id = id;
        this.type = type;
        this.content = content;
        this.state = state;
        this.publisherId = publisherId;
        this.receiverId = receiverId;
        publishTime = new Time(12,30,0);
        receiveTime = publishTime;
        finishTime = publishTime;
    }
    public Task(){
        id = 1;
        type = 0;
        content = "一饭天桥边取快递，大件";
        state = 0;
        publisherId = 123456789;
        receiverId = 987654321;
        publishTime = new Time(14,25,15);
        receiveTime = publishTime;
        finishTime = publishTime;
    }
    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public int getState() {
        return state;
    }

    public long getPublisherId() {
        return publisherId;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public Time getPublishTime() {
        return publishTime;
    }

    public Time getReceiveTime() {
        return receiveTime;
    }

    public Time getFinishTime() {
        return finishTime;
    }
}
