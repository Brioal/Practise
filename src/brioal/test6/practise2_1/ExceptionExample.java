package brioal.test6.practise2_1;

/**
 * Created by brioal on 15-10-6.
 */

class NoLowerLetter extends Exception {
    public void print() {
        System.out.printf("%c",'#');
    }
}

class NoDight extends Exception {
    public void print() {
        System.out.printf("%c", '#');
    }
}

class Test {
    void printLetter(char c) throws  NoLowerLetter {
        if (c < 'a' || c > 'z') {
            NoLowerLetter lowerLetter = new NoLowerLetter();
            throw lowerLetter;
        } else {
            System.out.print(c);
        }
    }
    void printDight(char c) throws NoDight {
        if (c < '1' || c > '9') {
            NoDight dight = new NoDight();
            throw dight;
        } else {
            System.out.print(c);
        }
    }
}
public class ExceptionExample {
    public static void main(String[] args) {
        Test test = new Test();
        for (int i = 0; i < 128; i++) {
            try {
                    test.printLetter((char) i);
            } catch ( NoLowerLetter e) {
                e.print();
            }
        }
        for (int i = 0; i < 128; i++) {
            try {
                test.printDight((char) i);

            } catch (NoDight noDight) {
                noDight.print();
            }
        }
    }

}
