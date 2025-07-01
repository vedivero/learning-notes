package lang.clazz;

import java.lang.reflect.Field;

public class ClassMetaMain {
    public static void main(String[] args) throws Exception {

        //클래스 조회
        //Class clazz = String.class; //1. 클래스에서 조회
        //Class clazz = new String().getClass();//2. 인스턴스에서 조회
        Class clazz = Class.forName("java.lang.String");//3. 문자열로 조회

        //모든 필드 출력
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }

        System.out.println("=================================================");

        //모든 필드 출력
        Field[] fields2 = clazz.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println("field = " + field.getType() + " " + field.getName());
        }

        //상위 클래스 정보 출력
        System.out.println("Superclass : " + clazz.getSuperclass().getName());

        //인터페이스 정보 출력
        Class[] interfaces = clazz.getInterfaces();
        for (Class i : interfaces) {
            System.out.println("interface : " + i.getName());
        }
    }
}
