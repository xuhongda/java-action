package com.xu.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author xuhongda on 2019/1/20
 * com.xu.date
 * java-action
 */
public class DateTest {
    @Test
    public void test() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        String format = simpleDateFormat.format(calendar.getTime());
        System.out.println(format);

    }

    /**
     * 获取上个月的最后一天
     *
     * @throws Exception
     */
    @Test
    public void getBeforeLastMonthdate() throws Exception {
        for (int i = 1; i <= 12; i++) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            calendar.set(Calendar.MONTH, month - i);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            System.out.println(i + "月最后一天：" + sf.format(calendar.getTime()));
        }

    }
}
