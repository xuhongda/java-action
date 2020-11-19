package pojo;

import lombok.*;

import java.io.Serializable;

/**
 * @author xuhongda on 2018/11/5
 * pojo
 * javase-practice
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Girl implements Serializable {

    @LoveMe(name = "xuhongda")
    private String name;

    private int age;

    private transient double weight;
}
