package pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xuhongda on 2020/8/28
 * com.redantsoft.app.domain
 * iov-vpms
 */
@Data
public class IovCarInfo  {




    private String deviceId;

    private String contractStartDate;

    private String engineNumber;

    private String objId;
    /**
     *  是否绑定
     */
    private Integer operationStatus;
    /**
     *  服务年限
     */
    private Integer  donateServicePeriod;


    private String vin;

    private String licensePlateNo;

    private String operatorDeptId;
}
