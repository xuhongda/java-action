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
    }
}
