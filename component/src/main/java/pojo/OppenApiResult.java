package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xuhongda on 2020/8/28
 * com.redantsoft.app.domain
 * iov-vpms
 */
@Data
public class OppenApiResult implements Serializable {

    /*{
	"cmd": "queryVpmsDeptDeviceList",
	"result": 0,
	"resultNote": "Success",
	"totalRecordNum": 1,
	"pages": 1,
	"pageNo": 0,
	"detail": {
		"dataList": [{
			"deviceId": "30013502122"
		}, {
			"deviceId": "30013503600"
		}, {
			"deviceId": "30013503621"
		}, {
			"deviceId": "30013503622"
		}, {
			"deviceId": "30013503636"
		}, {
			"deviceId": "30013503638"
		}, {
			"deviceId": "30013503639"
		}, {
			"deviceId": "30013503641"
		}]
	}
}
*/

    private String cmd;

    private Integer result;

    private String resultNote;

    private String totalRecordNum;

    private Integer pages;

    private Integer  pageNo;
    @JsonProperty(value = "detail")
    private Detail detail;

}
