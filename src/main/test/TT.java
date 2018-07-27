import org.junit.Test;

/**
 * @author xuhongda on 2018/7/27
 * PACKAGE_NAME
 * javase-practice
 */
public class TT {
    @Test
    public void test(){
        String s = "29.000000000003";
        int i =s.indexOf(".");
        System.out.println(i);
        System.out.println(s.substring(0, i + 3));
    }
}
