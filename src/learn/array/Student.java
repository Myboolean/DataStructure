package learn.array;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/19
 * Time: 16:32
 */
public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Array<Student> students = new Array<>(30);
        students.addLast(new Student("nae", 31));
        System.out.println(students);
    }
}
