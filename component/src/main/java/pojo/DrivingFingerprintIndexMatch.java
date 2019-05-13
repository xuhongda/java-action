package pojo;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author xuhongda on 2019/5/10
 * com.cpsdna.laso.util.bean
 * saasapi_lfp
 */
@Data
@ToString
public class DrivingFingerprintIndexMatch implements Serializable {

    private String trackId;


    private String objId;

    private String deviceId;

    private Integer mileage;

    private  Integer fuel;

    private Integer speed;

    private Integer trackTime;

    private String startTime;

    private String endTime;

    private Double avgFuel;

    private Integer overspeedNum;

    private Integer accNum;

    private Integer decNum;

    private Integer turnNum;

    private Integer brakesNum;

    private Double fuelScore;

    private Double overspeedScore;

    private Double accScore;

    private Double decScore;

    private Double turnScore;

    private Double brakeScore;

    private Double matchScore;

    private String matchDate;

    private String recordTime;
}
