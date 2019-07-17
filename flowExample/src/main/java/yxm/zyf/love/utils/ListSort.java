package yxm.zyf.love.utils;
import java.util.ArrayList;
import java.util.List;
 
class Student {
     
    private String name;
     
    private double age;
 
    public Student(String name, double age) {
        this.name = name;
        this.age = age;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public double getAge() {
        return age;
    }
 
    public void setAge(double age) {
        this.age = age;
    }
 
    @Override
    public String toString() {
        return "Perosn [name=" + name + ", age=" + age + "]";
    }
}
 
public class ListSort {
  
    public static void main(String[] args) {
         
        List<Student> students = new ArrayList<>();
         
        students.add(new Student("abc", 12.124));
        students.add(new Student("bcd", 20.214));
        students.add(new Student("cde", 17.321));
        students.add(new Student("def", 25.145));
        students.add(new Student("efg", 15.145));
        //需要jdk1.8以上
        students.sort((x, y) -> Double.compare(x.getAge(), y.getAge()));
         
        for (Student stu : students) {
            System.out.println(stu);
        }
    }
}