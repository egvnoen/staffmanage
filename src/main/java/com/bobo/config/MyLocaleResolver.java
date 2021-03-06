package com.bobo.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {

    // 解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {

        // 获取请求中的语言参数
        String language = httpServletRequest.getParameter("l");

        // 如果没有就使用默认的,有就使用国际化参数
        Locale locale = Locale.getDefault();
        if(StringUtils.hasText(language)) {

            // 切分国家和地区
            String[] split = language.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
