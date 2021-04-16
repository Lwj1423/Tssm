package project.service;

import JavaBase.demo.MyException;
import project.domain.*;

import static project.service.Data.EMPLOYEES;

/**
 * 1.负责将Data中的数据封装到Employee[]数组中
 * 2. 提供操作Employee[]的方法
 */
public class NameListService {
    private Employee[] employees;

    /**
     * 给Employees及数组元素进行初始化
     */
    public NameListService() {
        // 1.根据项目提供的Data类构建相应大小的employees数组
        // 2.根据Data类中的数据构造不同的对象,Employee,Programmer
        // 3.将对象存放在数组中
        employees = new Employee[Data.EMPLOYEES.length];
        Equipment equipment;
        double bonus; //奖金
        int stock; //股票

        for (int i = 0; i < employees.length; i++){
            //获取员工的类型
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);

            //获取员工的基本信息  抽取公共部门
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

            switch (type){
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case Data.PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case Data.DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case Data.ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }
    }

    //获取对应Equipment中的数据
    private Equipment createEquipment(int i) {
        int type = Integer.parseInt(Data.EQUIPMENTS[i][0]);

        String model = Data.EQUIPMENTS[i][1];

        //创建员工对应使用设备的对象
        switch (type){
            case Data.PC:
                String display = Data.EQUIPMENTS[i][2];
                return new PC(model,display);
            case Data.NOTEBOOK:
                double price = Double.parseDouble(Data.EQUIPMENTS[i][2]);
                return new NoteBook(model,price);
            case Data.PRINTER:
                return new Printer(model,Data.EQUIPMENTS[i][2]);
        }
        return null;
    }

    //获取所有员工
    public Employee[] getAllEmployess(){
        return employees;
    }

    //获取指定ID的对象
    public Employee getEmployee(int id) throws MyException {
        for (int i = 0; i < employees.length; i++){
            if (employees[i].getId() == id){
                return employees[i];
            }
        }
        throw new MyException("自定义异常:找不到指定员工");
    }
}
