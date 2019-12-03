package com.xu.inheritance;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author xuhongda 2018/6/27
 * com.xu.inheritance
 * javase-practice
 */
@Slf4j
public class Agirl extends  Manager {

    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }
        if (this == null){
            return false;
        }
        //许多程序员
        //却喜欢使用 instanceof 进行检测：
        //if ( KotherObject instanceof Employee)) return false;
        //这样做不但没有解决 otherObject 是子类的情况，并且还有可能会招致一些麻烦。这就是建议
        //不要使用这种处理方式的原因所在。 Java 语言规范要求 equals 方法具有下面的特性：
        //1 ) 自反性： 对于任何非空引用 x, x.equals(?0 应该返回 truec
        //2 ) 对称性: 对于任何引用 x 和 y, 当且仅当 y.equals(x) 返回 true, x.equals(y) 也应该返
        //回 true。
        //3 ) 传递性： 对于任何引用 x、 y 和 z, 如果 x.equals(y) 返 N true， y.equals(z) 返回 true,
        //x.equals(z) 也应该返回 true。
        //4 ) 一致性： 如果 x 和 y 引用的对象没有发生变化，反复调用 x.eqimIS(y) 应该返回同样
        //的结果。
        //5 ) 对于任意非空引用 x, x.equals(null) 应该返回 false
        if (getClass() != obj.getClass()){
            return false;
        }
        Agirl agirl = (Agirl)obj;

        return agirl.getAge().equals(this.getAge())&&agirl.getBonus()==this.getBonus();
    }

    @Override
    public int hashCode() {
        //重写hashcode 的好方式
        return Objects.hash(getBonus(),getHome());
    }

    public static void main(String[] args) {
        Agirl agirl = new Agirl();
        //对于 protected 要注意
        //在实际应用中，要谨慎使用 protected 属性。假设需要将设计的类提供给其他程序员使
        //用，而在这个类中设置了一些受保护域， 由于其他程序员可以由这个类再派生出新类，并访
        //问其中的受保护域。在这种情况下，如果需要对这个类的实现进行修改， 就必须通知所有使
        //用这个类的程序员。这违背了 OOP 提倡的数据封装原则。
        new Agirl().home= "Beijing";

        boolean equals = agirl.equals(new Agirl());
        log.info("e = {}",equals);
        if (agirl.getClass() == new Manager().getClass()){
            System.out.println("...");
        }
        // instanceof 子类以及本类
        if (agirl instanceof Manager){
            System.out.println("...");
        }
        agirl.setBonus(1);
        System.out.println(agirl.hashCode());
        System.out.println(new Agirl().hashCode());
    }
}
