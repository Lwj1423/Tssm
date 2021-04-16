package project.domain;

import project.service.Status;

/**
 * 程序员
 */
public class Programmer extends Employee{

    private int memberId; //团队中id
    private Status status = Status.FREE;  //员工状态
    private Equipment equipment; //使用设备

    public Programmer() {
        super();
    }

    public Programmer(int id, String name, int age, double salary,Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.toString()+"\t\t程序员\t" +status +"\t\t\t\t\t\t\t" + equipment.getDescription();
    }
}
