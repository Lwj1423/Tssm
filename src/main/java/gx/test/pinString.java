package gx.test;

public class pinString {

    public static void main(String[] args) {

        String s1="Hello";
        String s2="World";

        String s3="HelloWorld";
        String s4="Hello"+"World";
        String s5=s1+"World";
        String s6="Hello"+s2;
        String s7=s1+s2;

        System.out.println(s3==s4); //true
        System.out.println(s3==s5); //false
        System.out.println(s3==s6); //false
        System.out.println(s3==s7); //false
        System.out.println(s5==s6); //false
        System.out.println(s5==s7); //false
        System.out.println(s6==s7); //false

        String s8=s5.intern();
        System.out.println(s3==s8); //true
    }
}