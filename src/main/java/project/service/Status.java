package project.service;

/**
 * 表示员工状态的枚举
 */
public class Status {

    private  final String name;
    private Status(String name) {
        this.name = name;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name ;
    }
}
