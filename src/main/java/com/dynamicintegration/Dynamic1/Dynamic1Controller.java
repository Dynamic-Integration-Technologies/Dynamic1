package com.dynamicintegration.Dynamic1;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Dynamic1Controller {
    private static D1ReaderController d1ReaderController = D1ReaderController.getInstance();
    private static final String authkey = "securekey";
    private static final String authpswd = "securepswd";


    @RequestMapping(method = RequestMethod.GET, value = "/")
    public D1Response homepage(@RequestHeader Map<String, String> headers) {
        try {
            if (authenticate(headers)) {
                return new D1Response(true, "Hello secure user");
            }
            return new D1Response(false, "User not authenticated");
        } catch (Exception e) {
            return new D1Response(false, e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/startReading")
    public D1Response startRead(@RequestHeader Map<String, String> headers) {
        try {
            System.out.println(headers.toString());
            if (authenticate(headers)) {
                if(headers.containsKey("readername")){
                    String readerName = headers.get("readername");
                    D1Reader d1Reader = d1ReaderController.getReader(readerName);
                    if (d1Reader != null) {
                        d1Reader.startReading();
                        return new D1Response(true, "Reader " + readerName + " started");
                    } else {
                        return new D1Response(false, "Reader " + readerName + " not found");
                    }
                }else{
                    return new D1Response(false, "Invalid request header");
                }
            }
            return new D1Response(false, "User not authenticated");
        } catch (Exception e) {
            return new D1Response(false, e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/stopReading")
    public D1Response stopRead(@RequestHeader Map<String, String> headers) {
        try {
            if (authenticate(headers)) {
                if(headers.containsKey("readername")){
                    String readerName = headers.get("readername");
                    D1Reader d1Reader = d1ReaderController.getReader(readerName);
                    if (d1Reader != null) {
                        d1Reader.stopReading();
                        return new D1Response(true, "Reader " + readerName + " stopped");
                    } else {
                        return new D1Response(false, "Reader " + readerName + " not found");
                    }
                }else{
                    return new D1Response(false, "Invalid request header");
                }
            }
            return new D1Response(false, "User not authenticated");
        } catch (Exception e) {
            return new D1Response(false, e.getMessage());
        }
    }

    private Boolean authenticate(Map<String, String> headers) {
        if (headers.containsKey("authkey") && headers.containsKey("authpswd") && headers.get("authkey").equals(authkey) && headers.get("authpswd").equals(authpswd)) {
            return true;
        }
        return false;
    }
}
