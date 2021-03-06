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

   // private List<DrivingFingerprintIndexMatch> dataList;


   // private IovCarInfo carInfo;

    private String deviceId;

    private String contractStartDate;

    private String engineNumber;

    private String objId;
    /**
     *  是否绑定
     */
    private Integer operationStatus;
    /**
     *  服务年薪
     */
    private Integer  donateServicePeriod;

    private List<String> dataList;
}
