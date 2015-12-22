package db.his.domain;

/**
 * Created by lwt on 2015/12/13.
 * 挂号表
 */
public class DoctorSchedule {
    private String id;
    //医生id、
    private String doctor_id;
    //上午或者下午
    private String time;
    //星期几
    private String week;
    //最大预约数
    private int sum;
    //剩余预约数
    private int left_sum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getLeft_sum() {
        return left_sum;
    }

    public void setLeft_sum(int left_sum) {
        this.left_sum = left_sum;
    }
}
