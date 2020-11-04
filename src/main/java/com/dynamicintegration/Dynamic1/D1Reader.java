package com.dynamicintegration.Dynamic1;

import ch.qos.logback.core.BasicStatusManager;
import com.thingmagic.ReadListener;
import com.thingmagic.Reader;
import com.thingmagic.ReaderException;
import com.thingmagic.TagReadData;

import java.util.ArrayList;

public class D1Reader {
    private Reader reader;
    private final D1ReadListener d1ReadListener = new D1ReadListener();

    public D1Reader(String uri) throws ReaderException {
        this.reader = Reader.create(uri);
        this.reader.addReadListener(d1ReadListener);
    }

    public Boolean connect(){
        try{
            this.reader.connect();
            return true;
        }catch (ReaderException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public ArrayList<TagReadData> getTags(){
        return this.d1ReadListener.getTags();
    }

    public void startReading(){
        this.reader.startReading();
    }

    public void stopReading(){
        this.reader.stopReading();
    }
}
