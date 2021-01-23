package gx.dataStructure;

/**
 * 定义HeroNode,每个heroNode 对象就是一个节点
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //创建节点
        HeroNode hero1 = new HeroNode(1,"小一","一一");
        HeroNode hero2 = new HeroNode(2,"小二","一二");
        HeroNode hero3 = new HeroNode(3,"小三","一三");
        HeroNode hero4 = new HeroNode(4,"小四","一四");



        //创建链表
        SingleLinkedList linkedList = new SingleLinkedList();

        //添加数据
        linkedList.add(hero1);
        linkedList.add(hero3);
        linkedList.add(hero2);
        linkedList.add(hero4);

        //遍历数据
        linkedList.list();
    }


}

//02.定义链表
class SingleLinkedList{
    //01.先定义一个头节点,头节点不能动,不存放具体数据
    private HeroNode head = new HeroNode(0,"","");

    //02.添加节点到单向链表
    /**
     * 思路:
     * 1.找到当前链表的最后节点
     * 2.将最后这个节点的next 指向 新的节点
     */
    public void add(HeroNode heroNode){
        //先找到头节点
        HeroNode temp = head;
        //遍历链表,找到最后
        while (true){
            //找到链表最后
            if (temp.next == null){
                break;
            }
            //没有找到最后,将temp向后移
            temp = temp.next;

        }
        //循环结束,temp就指向了链表最后  最后这个temp的next 指向新节点
        temp.next = heroNode;
    }

    //03. 遍历显示链表
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        //因为头节点不能动,需要辅助变量来遍历
        HeroNode temp = head.next;
        while (true){
            //判断是否到链表最后
            if (temp == null){
                break;
            }
            System.out.println(temp);
            //将temp后移   不后移会造成死循环
            temp = temp.next;
        }
    }

}

/**
 * 01.定义HeroNode,每个heroNode 对象就是一个节点
 */
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;  //指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    //为了显示方法,重写toString()
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
    }

}



