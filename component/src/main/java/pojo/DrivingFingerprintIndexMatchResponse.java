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
public class DrivingFingerprintIndexMatchResponse implements Serializable{

    private String cmd;

    private Integer result;

    private String resultNote;

    private Integer totalRecordNum;

    private Integer pages;

    private Integer pageNo;

    private Detail detail;

}





