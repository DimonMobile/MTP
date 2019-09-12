public class DoorThread extends Thread {
    private Door door;

    public DoorThread(Door door) {
        this.door = door;
    }

    @Override
    public void run() {
        try {
            while (door.enter()) {}
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }
}
