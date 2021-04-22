package project01.service;

import JavaBase.java.MyException;
import project01.domain.Architect;
import project01.domain.Designer;
import project01.domain.Employee;
import project01.domain.Programmer;

/**
 * 管理开发团队中成员:添加、删除
 */
public class TeamService {

    private static int counter = 1;//设置memberId
    private final int MAX_MEMBER = 5; //团队最多五人
    private Programmer[] team = new Programmer[MAX_MEMBER]; //保存团队成员
    private int total; //团队实际人数

    /**
     * 获取团队中所有成员
     * @return
     */
    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
       for (int i = 0; i < team.length; i ++){
           team[i] = this.team[i];
       }
        return team;
    }

    public void addMember(Employee e) throws MyException {
        //成员已满，无法添加
        if (total > MAX_MEMBER){
            throw new MyException("成员已满，无法添加");
        }
        //该成员不是开发人员，无法添加
        if (!(e instanceof Programmer)){
            throw new MyException("该成员不是开发人员，无法添加");
        }
        //该员工已在本团队中
        if (isExist(e)){
            throw new MyException("该员工已在本团队中");
        }
        //该员工已经在另一个团队或者正在休假，无法添加
        Programmer p = (Programmer) e;
        /*if ("BUSY".equals(p.getStatus().getName())){
            throw new MyException("该员工已是某团队成员");
        }else if ("VOCATION".equals(p.getStatus().getName())){
            throw new MyException("该员工正在休假，无法添加");
        }*/
        switch (p.getStatus()){
            case BUSY:
                throw new MyException("该员工已是某团队成员");
            case VOCATION:
                throw new MyException("该员工正在休假，无法添加");
        }


        //团队中至多有一个架构师
        //团队中至多有两个设计师
        //团队中至多有三个程序员
        int numOfArch = 0; int numOfDes = 0; int numOfPro = 0;
        for (int i = 0; i < total; i++){
            if (team[i] instanceof Architect){
                numOfArch++;
            }else if (team[i] instanceof Designer){
                numOfDes++;
            }else if (team[i] instanceof Programmer){
                numOfPro++;
            }
        }

        if (p instanceof Architect){
            if (numOfArch >= 1){
                throw new MyException("团队中至多有一个架构师");
            }
        }else if (p instanceof Designer){
            if (numOfDes >= 2){
                throw new MyException("团队中至多有两个设计师");
            }
        }else if (p instanceof Programmer){
            if (numOfPro >= 3){
                throw new MyException("团队中至多有三个程序员");
            }
        }

        //将P 添加到现有team中
        team[total++] = p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);

    }


    private boolean isExist(Employee e) {
        for (int i = 0; i <total; i++){
            return team[i].getId() == e.getId();
        }
        return false;
    }

    //从团队中删除
    public void removeMember(int memberId) throws MyException {
        int i = 0;
        for (; i <total;i++){
            if (team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }

        //未找打指定memberId
        if (i == total){
            throw new MyException("找不到指定员工,删除失败~~~");
        }

        for (int j = i + 1; j < total;j++ ){
            team[j - 1] = team[j];
        }
        //数组最后一个元素设为null
        team[total - 1] =null;
        total --;
    }

}
