package JavaBase.demo;

import JavaBase.mainUtil.CMUtility;

/**
 * 客户信息展示  项目二
 */
public class CustomerTest {

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.enterMainMenu();
    }
    /**
     * 工具类
     */
    static class Menu{
        CustomerService customerService = new CustomerService(10);
        /**
         * 用户界面
         */
        public void enterMainMenu(){

            boolean isFlage = true;
            while (isFlage) {
                System.out.println("\n----------客户信息管理---------");
                System.out.println("1、添加客户");
                System.out.println("2、修改客户");
                System.out.println("3、删除客户");
                System.out.println("4、客户列表");
                System.out.println("5、退出\n");
                System.out.println("   请选择（1-5）：");
            char menu = CMUtility.readMenuSelection();
            switch (menu){
                case '1':
                    addNewCustomer();
                    listAllCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.println("确认是否要推出（Y/N）");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y'){
                        isFlage = false;
                    }

                    break;

            }
            }
        }
        //添加客户
        public void addNewCustomer(){
            System.out.println("添加用户");
            System.out.println("姓名：");
            String name = CMUtility.readString(10);
            System.out.println("年龄：");
            int age = CMUtility.readInt(0);

            Customer customer = new Customer(name, age);
            boolean isSuccess = customerService.addCustomer(customer);
            if (isSuccess){
                System.out.println("添加成功");
            }else{
                System.out.println("客户目录已满，添加失败");
            }
        }
        //修改客户
        public void modifyCustomer(){
            System.out.println("修改客户");
            Customer cust;
            int number;
            for ( ; ; ){
                System.out.println("请选择用户编号（-1）退出：");
                number = CMUtility.readInt();
                if (number == -1){
                    return;
                }

                cust = customerService.getCustomer(number - 1);
                if (cust == null){
                    System.out.println("没有该用户！");
                }else{
                    break;
                }
            }

            //修改操作
            System.out.println("姓名（"+cust.getName()+");");
            String name = CMUtility.readString(10, cust.getName());
            System.out.println("年龄（"+cust.getAge()+");");
            int age = CMUtility.readInt(cust.getAge());

            Customer newCust = new Customer(name, age);
            boolean isReplace = customerService.replaceCustomer(number - 1, newCust);
            if (isReplace){
                System.out.println("修改完成");
            }else{
                System.out.println("修改失败");
            }
        }
        //删除客户
        public void deleteCustomer(){
            System.out.println("删除用户信息");
            int number;
            for (;;){
                System.out.println("请选择待删除客户编号（-1退出）");
                number = CMUtility.readInt();
                if (number == -1 ){
                    return;
                }
                Customer customer = customerService.getCustomer(number - 1);
                if (customer == null){
                    System.out.println("客户不存在");
                }else{
                    break;
                }
            }
            //找到了客户
            System.out.println("确认是否删除（Y/N）");
            char isDelete = CMUtility.readConfirmSelection();
            if (isDelete == 'Y'){
                customerService.deleteCustomer(number - 1);
            }else{
                return;
            }


        }
        //显示客户列表
        public void listAllCustomer(){
            System.out.println("客户列表");
            int total = customerService.getTotal();
            if (total == 0){
                System.out.println("没有客户信息");
            } else {
                System.out.println("编号\t姓名\t性别");
                Customer[] custs = customerService.getAllCustomers();
                for (int i = 0; i < custs.length; i ++){
                    Customer cust = custs[i];
                    System.out.println((i + 1)+"\t"+cust.getName()+"\t"+cust.getAge());
                }
            }
            System.out.println("展示完成！！！！");
        }




    }

    /**
     * 逻辑处理层
     */
    static class CustomerService{
        private Customer[] customers;//客户信息
        private int total = 0; //客户数量

        public CustomerService(int totalCustomer) {
            customers = new Customer[totalCustomer];
        }

        //新增客户
        public boolean addCustomer(Customer customer){
            if (total >= customers.length)
                    return false ;
            customers[total++] = customer;
            return true;
        }

        //替换客户
        public boolean replaceCustomer(int index, Customer customer){
            if (index < 0 || index >= total){
                return false;
            }
            customers[index] = customer;
            return true;
        }

        //删除客户
        public boolean deleteCustomer(int index){
            if (index < 0 || index >= total){
                return false;
            }
            for (int i = index; i < total - 1; i ++){
                customers[i] = customers[i + 1];
            }
            //最后的元素置空
            customers[total - 1] = null;
            total--;
            return true;
        }

        //获取所有客户
        public Customer[] getAllCustomers(){
            Customer[] custs = new Customer[total];
            for (int i = 0 ; i < total; i ++){
                custs[i] = customers[i];
            }
            return custs;
        }

        //获取指定位置客户
        public Customer getCustomer(int index){
            if (index < 0 || index >= total)
                return  null;
            return customers[index];
        }

        //获取客户总数
        public int getTotal(){
            return total;
        }


    }

    /**
     * bean
     */
    static class Customer {
        private String name;
        private char gender;
        private int age;


        public Customer() {
            super();
        }

        public Customer(String name, int age) {
            this.name = name;

            this.age = age;

        }

        public void setName(String name) {
            this.name = name;
        }

        public void setGender(char gender) {
            this.gender = gender;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public char getGender() {
            return gender;
        }

        public int getAge() {
            return age;
        }

    }
}
