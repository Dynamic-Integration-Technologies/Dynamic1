package com.dynamicintegration.Dynamic1;

import com.thingmagic.Reader;
import com.thingmagic.ReaderException;
import com.thingmagic.TagReadData;

import java.util.ArrayList;

public class D1Reader {
    private Reader reader;
    private final D1ReadListener d1ReadListener = new D1ReadListener();
    private final D1ReadExceptionListener d1ReadExceptionListener = new D1ReadExceptionListener();

    public D1Reader(String uri) throws ReaderException {
        this.reader = Reader.create(uri);
        this.reader.addReadListener(d1ReadListener);
        this.reader.addReadExceptionListener(d1ReadExceptionListener);
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

    public ArrayList<ReaderException> getExceptions(){
        return this.d1ReadExceptionListener.getExceptions();
    }

    public void startReading(){
        this.d1ReadListener.clearTags();
        this.d1ReadExceptionListener.clearExceptions();
        this.reader.startReading();
    }

    public void stopReading(){
        this.reader.stopReading();
    }
}
