package com.dynamicintegration.Dynamic1;

import org.springframework.web.bind.annotation.*;
@RestController
public class Dynamic1Controller {

    @RequestMapping(method= RequestMethod.GET, value="/")
    public String homepage() {
        return "HELLO WORLD";
    }
}
