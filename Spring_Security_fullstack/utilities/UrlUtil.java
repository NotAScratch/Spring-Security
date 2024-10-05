package com.example.fullstack.utilities;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

public class UrlUtil {
        public  static  String getApplicationUrl(HttpServletRequest request){
         String appUrl = request.getRequestURL().toString();
         return  appUrl.replace(request.getServletPath(),"");


        }

}
