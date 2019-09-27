package com.xu.lambda.book;


import com.xu.lambda.self.bean.Apple;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author xuhongda on 2018/7/30
 * com.xu.lambda.book
 * javase-practice
 */
public class StreamTest {

    private List<Apple> apples;
    private List<Integer> numbers;
    @BeforeTest
    public void before() {
        apples = Arrays.asList(new Apple(20, "xx"), new Apple(20, "tt"), new Apple(18, "f"), new Apple(7, "liu"));
        numbers = Arrays.asList(1,23,4,56,6,5,7);
    }

    @Test
    public void test() {
        apples.stream().forEach(System.out::println);
    }

    /**
     * filter
     * filter 是一个惰性求值方法。函数接口为 {@link Predicate},此方法负责对数据进行判断，filter高阶函数负责根据判断结果对流进行过滤。
     */
    @Test
    public void test2() {
        long l = apples.stream().filter(a -> a.getWeight() > 7).distinct().limit(2).count();
        System.out.println(l);
    }

    @Test
    public void test3() {
        List<Apple> apples1 = apples.stream().filter(a -> a.getWeight() > 7).distinct().skip(2).collect(Collectors.toList());
        System.err.println(apples1);
    }

    /**
     * <p>
     *     map
     *      map是一个惰性求值方法。函数接口为{@link java.util.function.Function}函数接口
     *      负责将数据从一个类型转换为另一个类型；高阶函数map的作用就是将数据从一个流转换为另一个流
     * </p>
     *
     * 返回数的平方
     */
    @Test
    public void test4(){
      List<Integer> list = Arrays.asList(1,23,45,6,78);
      List l = list.stream().map(a->a*a).collect(Collectors.toList());
        System.out.println(l);
        list.parallelStream().map(a -> {
            System.out.println(a.intValue());
            return a + 1;
        }).collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void test11() {
        Stream<List<Integer>> inputStream = Stream.of(
                Collections.singletonList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap(Collection::stream);
        List<Integer> collect = outputStream.collect(Collectors.toList());
        System.out.println(collect);

    }

    /**
     * 两个数字列表，返回所有的数对
     * flatMap
     */
    @Test
    public void test5(){
        List<Integer> numbers1 = Arrays.asList(1,22,3);
        List<Integer> numbers2 = Arrays.asList(3,77,99);
        // List<int[]> list = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (Integer i : numbers1){
            for (Integer i2: numbers2){
                //int[] ints = new int[]{i,i2};
                if (i2 > 2) {
                    list.add(i2);
                }
                if (i > 22) {
                    list.add(i);
                }
            }
        }

        List<int[]> l = numbers1.stream().flatMap(a->numbers2.stream().map(j->new int[]{a,j})).collect(Collectors.toList());
        l.forEach(a-> System.out.println(a.length));
    }

    /**
     * 筛选
     */
    @Test
    public void test6(){

        Stream<Apple> stream = apples.stream();
        boolean b = stream.allMatch(a -> a.getWeight() > 7);
        if (b){
            System.out.println("apples 的重量全部大于7");
        }else {
            System.out.println("apples 的重量没有全部全部大于7");
        }
    }

    @Test
    public void test7(){
        Optional<Apple> any = apples.stream().filter(a -> a.getWeight() > 7).findAny();
        System.out.println("any"+any);
        boolean present = any.isPresent();
        System.out.println(present);
    }

    /**
     * reduce
     * 循环来对数字列表中的元素求和
     */
    @Test
    public void test8(){
        Integer reduce = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
    }

    /**
     * 归约操作
     * 最大值
     */
    @Test
    public void test9(){
        Optional<Integer> reduce = numbers.stream().reduce(Integer::max);
        System.out.println(reduce);
    }

    /**
     * 归约操作
     * 最小值
     */
    @Test
    public void test10(){
        Optional<Integer> reduce = numbers.stream().reduce(Integer::min);
        System.out.println(reduce);
    }

}
