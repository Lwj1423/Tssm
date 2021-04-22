package JavaBase.java.Enum;
class SeasonTest{
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}

/**
 * 创建枚举方式一
 */
public class Season {
    //1.声明Season对象属性
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化构造器,并给对象属性赋值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3.提供当前枚举多个对象
    public static final Season SPRING = new Season("春天","111");
    public static final Season SUMMER = new Season("夏天","222");

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
