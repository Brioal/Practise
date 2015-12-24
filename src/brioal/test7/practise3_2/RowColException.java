package brioal.test7.practise3_2;

/**
 * Created by Null on 2015/10/19.
 */
public class RowColException extends Exception {
    public RowColException(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
