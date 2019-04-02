package com.diagens.five.queues;

/**
 * @author ZNJ
 * @create 2019-03-28 17:27
 */
public class Toast {
    //制作吐司,抹黄油，涂果酱
    public enum Status{DRY,BUTTERED,JAMMED}
    private Status status=Status.DRY;
    private final int id;

    public Toast(int id) {
        this.id = id;
    }
    public void butter(){status=Status.BUTTERED;}
    public void jam(){status=Status.JAMMED;}

    public Status getStatus() {
        return status;
    }
    public int getId(){return id;}

    @Override
    public String toString() {
        return "Toast{" +
                "status=" + status +
                ", id=" + id +
                '}';
    }
}
