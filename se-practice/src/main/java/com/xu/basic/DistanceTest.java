package com.xu.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author xuhongda on 2019/6/3
 * com.xu.math
 * java-action
 */
@Slf4j
public class DistanceTest {
    @Test
    public void  test3(){

        if (getDistance(100,100,100,100) == distance(100d,100d,100d,100d)){
            log.info("true");
            System.out.println("一致");
        }

    }

    private double getDistance(double long1, double lat1, double long2, double lat2) {
        double a, b;
        lat1 = lat1 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;
        a = lat1 - lat2;
        b = (long1 - long2) * Math.PI / 180.0;
        double d;
        double sa2, sb2;
        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        // 地球半径
        final double R = 6378100;
        d = 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
        return d;
    }


    private static double distance(Double _lat1, Double _lon1, Double _lat2, Double _lon2) {
        if (_lat1 == null || _lat2 == null || _lon1 == null || _lon2 == null) {
            return 0;
        }
        //修改纬度的合法判断条件为+-90,经度的合法判断条件为+-180
        boolean b = (_lat1 < -90.00d || _lat1 > 90.00d) || (_lat2 < -90.00d || _lat2 > 90.00d) || (_lon1 < -180.00d || _lon1 > 180.00d)
                || (_lon2 < -180.00d || _lon2 > 180.00d);
        if (b) {
            return 0;
        }

        if (_lat1.equals(_lat2) && _lon1.equals(_lon2)) {
            return 0;
        }
        double lat1 = Math.PI * _lat1;
        double lat2 = Math.PI * _lat2;
        double lon1 = Math.PI * _lon1;
        double lon2 = Math.PI * _lon2;
        // 地球半径
        final double R = 6378100;
        double d = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1)) * R;
        try {
            return d > 0 ? new BigDecimal(d).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue() : 0;
        } catch (Exception e) {
            log.error(_lat1 + "," + _lon1 + ";" + _lat2 + "," + _lon2 + " d:" + d, e);
            return 0;
        }
    }
}
