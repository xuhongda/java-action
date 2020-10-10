import org.junit.Test;

/**
 * @author xuhongda on 2020/3/19
 * PACKAGE_NAME
 * java-action
 */
public class ExcTest {

    public static void main(String[] args) {
        try {
            System.out.println("create a exception");
            int i = 1/0;
        }catch (Exception e){
            System.out.println("catch a exception");
        }


        System.out.println("still run to here");

        a();
    }

    private static Boolean a(){
        boolean b = b();
        System.out.println("2");
        return true;
    }

    private static boolean b() {

        return true;
    }


    @Test
    public void test(){

       try {
           System.out.println("1");
           return;
       }catch (Exception e){

       }finally {
           System.out.println("ok");
       }
    }

    @Test
    public void test002(){

        int i = (int)(7*3.6/100) ;
        System.out.println(i);
    }
}
