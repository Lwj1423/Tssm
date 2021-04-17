package project.view;

import JavaBase.demo.MyException;
import JavaBase.mainUtil.CMUtility;
import project.domain.Employee;
import project.domain.Programmer;
import project.service.NameListService;
import project.service.TeamService;

/**
 * 项目展示页面
 */
public class TeamView {

        private NameListService listService = new NameListService();
        private TeamService teamService = new TeamService();

        public void enterMainMenu(){
            boolean isFlage = true;
            char menu = 0;
            while (isFlage) {
                if (menu != '1') {
                    listAllEmployees();
                };
                System.out.print("1、团队列表2、添加团队成员3、删除团队成员4、退出请选择（1-4）：");
                menu = TSUtility.readMenuSelection();
                switch (menu){
                    case '1':
                        getTeam();
                        break;
                    case '2':
                        addMember();
                        break;
                    case '3':
                        deleteMember();
                        break;
                    case '4':
                        System.out.println("确认是否要推出（Y/N）");
                        char isExit = TSUtility.readConfirmSelection();
                        if (isExit == 'Y'){
                            isFlage = false;
                        }

                        break;

                }
            }
        }
        //显示所有员工信息
        public void listAllEmployees(){
            System.out.println("所有员工信息~~~~~~~~~~~~~");
            Employee[] employess = listService.getAllEmployess();
            if (employess == null || employess.length == 0){
                System.out.println("没有员工信息");
            }else{
                System.out.println("ID\t姓名\t年龄\t工资\t\t职位\t状态\t奖金\t股票\t\t\t设备" );
                for (Employee employee :
                        employess) {
                    System.out.println(employee);
                }
            }
        }

        //显示团队情况
        public void getTeam(){
            System.out.println("团队成员____________________");
            Programmer[] teams = teamService.getTeam();
            if (teams == null || teams.length == 0){
                System.out.println("没有员工信息");
            }else{
                System.out.println("TID/ID\t姓名\t年龄\t工资\t\t职位\t奖金\t股票\n" );
                for (Programmer team :
                        teams) {
                    System.out.println(team.getDetailsForTeam());
                }
            }
            System.out.println("________完成____________");
        }

        //添加团队成员
        public void addMember(){
            System.out.println("添加团队成员~~~~~~~~~~");
            System.out.print("请输入要添加的员工ID：");
            int id = TSUtility.readInt();
            try {
                Employee employee = listService.getEmployee(id);
                teamService.addMember(employee);
                System.out.println("添加成功");
            } catch (MyException e) {
                System.out.println("添加失败，原因：" + e.getMessage());
            }
            //按回车键继续...
            TSUtility.readReturn();
        }

        //删除团队成员
        public void deleteMember(){
            System.out.println("删除团队成员~~~~~~~~~");
            System.out.println("请输入要删除的员工TID: ");
            int memberId = TSUtility.readInt();
            System.out.println("确认要删除（Y/N）");
            char isDelete = TSUtility.readConfirmSelection();
            if (isDelete == 'N'){
                return;
            }

            try {
                teamService.removeMember(memberId);
            } catch (MyException e) {
                System.out.println("删除失败，原因：" + e.getMessage());
            }
            //按回车键继续...
            TSUtility.readReturn();

        }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }
}
