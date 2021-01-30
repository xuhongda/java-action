package pojo;


import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuhongda
 */
@Data
@ToString
public class CommonRequest {
	private String cmd;

	private List<Object[]> list;

	private Map<String, Object> params = new HashMap<>();

	
}
