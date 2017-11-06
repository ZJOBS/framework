package zjobs.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/3/13.
 */
public class DateFormatUtil {
    /**
     * 去时间除特殊字符
     */
    public static String matchSEDate(String sDate) {
        String regEx = "[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？-]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(sDate);
        return m.replaceAll("").replaceAll(" ", "");
    }

    /**
     * 获取当时的时间。
     * 替换字符串中的YYYY、YY、MM、DD、HH、MI、SS为对应的数值，其它字符不变。
     * GETDATETIME（YYMMDD）     040801
     * GETDATETIME（YYYY年MM月）  2004年08月
     *
     * @param str 日期格式
     * @return 时间格式字符串
     */
//    public static String GETDATETIME(String str) {
//        if (StringUtils.isEmpty(args))
//            throw new TdExprException("GETDATETIME");
//        String[] buf1 = {"YYYY", "YY", "MM", "DD", "HH", "MI", "SS"};
//        String[] buf2 = {"yyyy", "yy", "MM", "dd", "HH", "mm", "ss"};
//        String str = args.trim();
//        for (int i = 0; i < buf1.length; i++) {
//            str = StringUtils.replace(str, buf1[i], buf2[i]);
//        }
//        Calendar calendar = Calendar.getInstance();
//        return DateFormatUtils.format(calendar.getTime(), str);
//    }
}
