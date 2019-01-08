package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/**
 * @author xuhongda on 2019/1/8
 * pojo
 * java-action
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private Map<String, Object> map;

    private T data;
}
