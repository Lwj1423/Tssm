package gx.test;

import gx.domain.Menu;

import java.util.ArrayList;
import java.util.List;

public class testMenu {
    public static void main(String[] args) {
        createData();
        for (Menu array:dataList
             ) {
            System.out.println(array.toString());
        }

    }
    //保存数据
    public static List<Menu> dataList=new ArrayList();
    //创建数据
    public static  void  createData(){
        dataList.add(new Menu.Builder().id(0).menuName("根节点").parId(-2).type(0).url("").build());
        for (int i = 1; i <20 ; i++) {
            if (i<11) {
                dataList.add(new Menu.Builder().id(i).menuName("1级节点"+i).parId(0).type(0).url("").build());
            }else {
                dataList.add(new Menu.Builder().id(i).menuName(((i/10)+1)+"级节点"+i).parId(i-10).type(0).url("").build());
            }
        }
    }
}
