package pojo;


import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基本请求(用于json解析)
 * 
 * @author wangqiu
 * @version 1.0
 * @created 2012-10-11 下午4:15:20
 */
@Data
@ToString
public class CommonRequest {
	private String cmd;

	private List<Object[]> list;

	private Map<String, Object> params = new HashMap<>();

	
}
