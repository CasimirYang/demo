package com.webservice.base;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by yjh on 16/9/28.
 */
public class StartService {


    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:6556/ns?wsdl");
            QName sname = new QName("lili", "bilibili");
            Service service = Service.create(url,sname);
            MyService ms = service.getPort(MyService.class);
            System.out.println(ms.add(12,33));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}
