package br.com.lojaautopecas.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;
import javax.servlet.http.Cookie;

public class ManageCookies {
    public static String getLoginCookie(HttpServletRequest request){
        Optional<String> cookie = Arrays.stream(request.getCookies()).filter(c ->c.equals("login")).map(Cookie::getValue).findAny();
        if(cookie.isPresent()){
            return cookie.get();
        }
        return "-1";
    }
}
