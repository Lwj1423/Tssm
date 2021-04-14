package JavaBase.demo;

public class ExceptionTest {

    public static void main(String[] args) {
        Student s = new Student();
        try {
            s.regist(-1001);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}

class Student{

    private int id;

    public void regist(int id) throws Exception {
        if (id > 0){
            this.id = id;
        }else{
            throw new MyException("抛出自己编写的异常");
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}