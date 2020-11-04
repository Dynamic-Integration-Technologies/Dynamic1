package com.dynamicintegration.Dynamic1;

import com.thingmagic.Reader;
import com.thingmagic.ReaderException;

import java.util.HashMap;

public class D1ReaderController {

    private static D1ReaderController singletonD1ReaderController = null;
    private HashMap<String, D1Reader> d1Readers = new HashMap<>();

    private D1ReaderController(){}

    public static D1ReaderController getInstance(){
        if(singletonD1ReaderController == null){
            singletonD1ReaderController = new D1ReaderController();
        }
        return  singletonD1ReaderController;
    }

    public D1Reader getReader(String name){
        return d1Readers.get(name);
    }

    public Boolean readerExists(String name){
        return  d1Readers.containsKey(name);
    }

    public Boolean addReader(String name, String uri){
        try {
            D1Reader d1Reader = new D1Reader(uri);
            d1Readers.put(name, d1Reader);
            return true;
        }catch(ReaderException e){
            System.out.println(e.getMessage());
            return false;
        }
    }


}
