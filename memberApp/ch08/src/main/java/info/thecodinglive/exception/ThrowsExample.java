package info.thecodinglive.exception;

/**
 * Created by ysj on 2017-09-27.
 */
public class ThrowsExample {
    int division(int a, int b) throws ArithmeticException{
        int t = a/b;
        return t;
    }
    public static void main(String args[]){
        ThrowsExample obj = new ThrowsExample();
        try{
            System.out.println(obj.division(15,0));
        }
        catch(ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");
        }
    }
}
