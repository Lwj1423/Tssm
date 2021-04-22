package JavaBase.java.Enum;


class SeasonTest02{
    public static void main(String[] args) {
        Season02 spring = Season02.SPRING;

        System.out.println(spring);
        Thread.State blocked = Thread.State.BLOCKED;
        System.out.println(blocked.toString());
        System.out.println(Season02.valueOf("SPRING"));
    }
}

/**
 * 创建枚举方式二
 */
public enum  Season02 {

    //3.提供当前枚举多个对象
    SPRING("春天","111"),
    SUMMER("夏天","222");
    //1.声明Season对象属性
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化构造器,并给对象属性赋值
    private Season02(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }



    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
