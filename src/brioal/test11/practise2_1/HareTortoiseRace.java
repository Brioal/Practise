package brioal.test11.practise2_1;

/**
 * Created by brioal on 15-12-16.
 */
public class HareTortoiseRace {
    public static void main(String[] args) {
        Hare hare;
        Tortoise tortoise;
        hare = new Hare(500, 100);
        tortoise = new Tortoise(100, 100);
        hare.start();
        tortoise.start();

    }
}

class Tortoise extends Thread {
    int sleepTime = 0;
    int targetLength = 100;

    public Tortoise(int sleepTime, int targetLength) {
        this.sleepTime = sleepTime;
        this.targetLength = targetLength;
        setName("Tortoise");
    }

    @Override
    public void run() {
        while (true) {
            targetLength--;
            System.out.printf("T");
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (targetLength <= 0) {
                System.out.println(getName() + "到达目的地!\n");
                stop();
            }

        }
    }

}

class Hare extends Thread {
    int sleepTime = 0, targetLength = 100;

    public Hare(int sleepTime, int targetLength) {
        this.sleepTime = sleepTime;
        this.targetLength = targetLength;
        setName("Hare");
    }

    @Override
    public void run() {
        while (true) {
            targetLength -= 3;
            System.out.printf("*");
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (targetLength <= 0) {
                System.out.println(getName() + "到达目的地\n");
                stop();
            }
        }
    }
}
