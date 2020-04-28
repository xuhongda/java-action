import com.xu.lambda.self.bean.Girl;

/**
 * @author xuhongda on 2020/4/21
 * PACKAGE_NAME
 * java-action
 */
public class NullTest {


    public static void main(String[] args) {
        Girl girl = new Girl();

        girl.setName(null);
        girl.setAge(null);

        m(girl.getName(),girl.getAge());
    }

    static void  m(String name,Integer age){
        for (int i=0;i<10;i++){
            Girl girl = new Girl();
            girl.setName(name);
            girl.age =age;
            System.out.println(age);
        }

    }
}
