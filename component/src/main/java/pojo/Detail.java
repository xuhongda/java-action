package pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author xuhongda on 2019/5/10
 * com.cpsdna.laso.util.bean
 * saasapi_lfp
 */
@ToString
@Data
public class Detail implements Serializable {

    private List<DrivingFingerprintIndexMatch> dataList;

}
