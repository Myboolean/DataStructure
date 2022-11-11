package learnjava.thread;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/29
 * Time: 17:56
 */

public class CreateThread {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println("ddd");
            }
        };
        t.start();
        t.setName("ddd");
        Thread t2 = new Thread(()-> System.out.println("dddd"));
        t2.setName("dddd");
        t2.start();


    }
}
