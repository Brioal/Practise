package brioal.test11.practise1_1;

/**
 * Created by brioal on 15-12-16.
 */
public class Reptitle extends Thread {


    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(currentThread().getName() + ":I am crwaling" + i + " step");
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Reptitle reptitle1 = new Reptitle();
        reptitle1.setName("Reptitle1");
        Reptitle reptitle2 = new Reptitle();
        reptitle2.setName("Reptitle2");
        reptitle1.start();
        reptitle2.start();
    }
}
