package com.dynamicintegration.Dynamic1;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Dynamic1Controller {
    private static D1ReaderController d1ReaderController = D1ReaderController.getInstance();
    private static final String authkey = "securekey";
    private static final String authpswd = "securepswd";


    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String homepage(@RequestHeader Map<String, String> headers) {
        if (authenticate(headers)) {
            return "HELLO secure user";
        } else {
            return "Hello unsecure user";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/startReading")
    public void startRead(@RequestHeader Map<String, String> headers) {
        //validate request
        String name = headers.get("rname");
        D1Reader d1Reader = d1ReaderController.getReader(name);
        d1Reader.startReading();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/stopReading")
    public void stopRead(@RequestHeader Map<String, String> headers) {
        //validate request
        String name = headers.get("rname");
        D1Reader d1Reader = d1ReaderController.getReader(name);
        d1Reader.stopReading();
    }

    private Boolean authenticate(Map<String, String> headers) {
        if (headers.containsKey("authkey") && headers.containsKey("authpswd") && headers.get("authkey").equals(authkey) && headers.get("authpswd").equals(authpswd)) {
            return true;
        } else {
            return false;
        }
    }
}
