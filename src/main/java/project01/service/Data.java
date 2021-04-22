package project01.service;

public class Data {

    public static final int EMPLOYEE = 10;//员工
    public static final int PROGRAMMER = 11;//程序员
    public static final int DESIGNER = 12;//工程师
    public static final int ARCHITECT = 13;//架构

    public static final int PC = 21;
    public static final int NOTEBOOK = 22;
    public static final int PRINTER = 23;//打印机

    //10, id,name,age,salary,bonus,stock
    public static final String[][] EMPLOYEES = {
            {"10","1","马云","22","3000"},
            {"13","2","马华腾","32","18000","1500","2000"},
            {"11","3","李严","23","7000"},
            {"11","4","雷人","24","7000"},
            {"12","5","张三","28","18000","5000"},
            {"11","6","王五","22","68000"},
            {"12","7","哈哈","22","10000","5200"},
            {"13","8","三三","22","11000","15000","2000"},
            {"12","9","六六","22","9800","5500"},
            {"11","10","八八","22","6600"},
            {"11","11","九九","22","7100"},
            {"12","12","九九","27","7000","2000"}
    };
    /**
     * 与 employees对应
     * PC:       21,model,display
     * notebook: 22,model,price
     * printer:  23,name,type
     */
    public static final String[][]EQUIPMENTS = {
            {},
            {"22","联想01","6000"},
            {"21","戴尔","nec 17寸"},
            {"21","戴尔","三星 17寸"},
            {"23","佳能29","激光"},
            {"21","华硕","17寸"},
            {"21","华硕","17寸"},
            {"23","华为","真实"},
            {"22","华为01","5800"},
            {"21","戴尔","NEC 17寸"},
            {"21","华硕","17寸"},
            {"22","惠普m6","5800"},
    };


}
