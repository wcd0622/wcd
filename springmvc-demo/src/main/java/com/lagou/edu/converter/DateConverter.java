package com.lagou.edu.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *S:source:源头类型
 * T：target：目标类型
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        //完成字符串向日期的转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse(s);
            return parse;
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return null;
    }
}
