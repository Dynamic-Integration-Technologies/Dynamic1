package com.dynamicintegration.Dynamic1;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Dynamic1Controller {
    private static D1ReaderController d1ReaderController = D1ReaderController.getInstance();

    @RequestMapping(method= RequestMethod.GET, value="/")
    public String homepage() {
        return "HELLO WORLD";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/startReading")
    public void startRead(@RequestHeader Map<String, String> headers){
        //validate request
        String name = headers.get("rname");
        D1Reader d1Reader = d1ReaderController.getReader(name);
        d1Reader.startReading();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/stopReading")
    public void stopRead(@RequestHeader Map<String, String> headers){
        //validate request
        String name = headers.get("rname");
        D1Reader d1Reader = d1ReaderController.getReader(name);
        d1Reader.stopReading();
    }
}
