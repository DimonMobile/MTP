import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        /*ArrayList<Integer> students = new ArrayList<>();

        for(int i = 0 ; i < 50; ++i){
            students.add(i);
        }

        Door door = new Door(students);
        DoorThread doorThread = new DoorThread(door);

        doorThread.start();
        doorThread.join(); */

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(2*5);
        new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 30; ++i) {
                        queue.put(i);
                        System.out.println(i + " посетитель зашел в ресторан");
                    }
                } catch(InterruptedException e) {
                    System.out.println(e);
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    for(int i = 0 ; i < 30; ++i) {
                        Thread.sleep(500);
                        System.out.println(queue.take() + " покинул ресторан");
                    }
                } catch(InterruptedException e) {
                    System.out.println(e);
                }
            }
        }.start();
    }
}
