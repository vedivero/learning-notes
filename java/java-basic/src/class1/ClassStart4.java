package class1;

public class ClassStart4 {
    public static void main(String[] args) {

        Student student1 = new Student();
        student1.name = "장원영";
        student1.age = 15;
        student1.grade = 90;

        Student student2 = new Student();
        student2.name = "유나";
        student2.age = 19;
        student2.grade = 80;

        Student[] students = new Student[2];

        students[0] = student1;
        students[1] = student2;

        System.out.println("이름 : " + students[0].name + ", 나이 : " + students[0].age + ", 성적 : " + students[0].grade);
        System.out.println("이름 : " + students[1].name + ", 나이 : " + students[1].age + ", 성적 : " + students[1].grade);
    }
}
