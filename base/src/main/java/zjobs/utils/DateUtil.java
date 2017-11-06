package zjobs.utils;

import org.apache.commons.lang.StringUtils;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2015/6/12.
 */
public class DateUtil {
    /**
     * 获取日期
     *
     * @param format 日期格式
     * @param op     +1 加1  -1 减1
     * @return String
     */
    public static String get(String format, int op) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, op);
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取日期
     *
     * @param format 日期格式
     * @return String
     * @throws ParseException
     */
    public static String formatDateStr(String format, String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        Date date = sdf.parse(dateStr);
        calendar.setTime(date);
        return sdf.format(calendar.getTime());
    }

    public static String datetrans(XMLGregorianCalendar calendar) {
        DateFormat d = new SimpleDateFormat("yyyyMMddHHmmss");
        return d.format(calendar.toGregorianCalendar().getTime());

    }


    public static String datetrans1(XMLGregorianCalendar calendar) {
        DateFormat d = new SimpleDateFormat("yyyy年MM月dd日HH点mm分");
        return d.format(calendar.toGregorianCalendar().getTime());

    }

    /**
     * 计算时间
     *
     * @param oprTime   操作时间 yyyy-MM-dd HH:ss:mm
     * @param spaceTime 间隔小时
     * @return
     * @throws Exception
     */
    public static String calcTime(String oprTime, int spaceTime) throws Exception {
        if (StringUtils.isNotBlank(oprTime)) {
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
            Calendar calendar = Calendar.getInstance();
            try {
                Date oprDate = sdf.parse(oprTime);
                calendar.setTime(oprDate);
                long cTime = calendar.getTimeInMillis();
                cTime = cTime + spaceTime * 60 * 60 * 1000;
                calendar.setTimeInMillis(cTime);
            } catch (ParseException exc) {
                exc.printStackTrace();
                throw new Exception("时间操作错误！");
            }
            return df.format(calendar.getTime());
        } else {
            throw new Exception("操作时间不能为空！");
        }
    }

    public static String getDateFormat(String sdate, String strFormatS, String strFormatE) {
        SimpleDateFormat sdf = new SimpleDateFormat(strFormatS);
        SimpleDateFormat format = new SimpleDateFormat(strFormatE);
        try {
            return (format.format(sdf.parse(sdate)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    //写个两种格式互相转换
    public static void main(String[] args) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = formatter.parse("20150311152010");
            System.out.println(date.toString());
            String d = formatter2.format(date);
            System.out.println(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

