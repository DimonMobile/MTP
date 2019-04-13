import java.util.ArrayList;

public class Door {
    private ArrayList<Integer> students;

    public Door(ArrayList<Integer> students) {
        this.students = students;
    }

    public synchronized boolean enter() throws InterruptedException {
        if (students.size() > 0) {
            int studentId = students.get(0);
            students.remove(0);
            Thread.sleep(500);
            System.out.println("Student " + studentId + " entered");
            return true;
        }
        return false;
    }
}
