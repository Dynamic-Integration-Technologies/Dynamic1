package com.dynamicintegration.Dynamic1;

import com.thingmagic.ReadExceptionListener;
import com.thingmagic.Reader;
import com.thingmagic.ReaderException;

import java.util.ArrayList;

public class D1ReadExceptionListener implements ReadExceptionListener {
    private final ArrayList<ReaderException> exceptions = new ArrayList<>();

    public D1ReadExceptionListener(){}

    @Override
    public void tagReadException(Reader reader, ReaderException e) {
        this.exceptions.add(e);
    }

    public ArrayList<ReaderException> getExceptions(){
        return this.exceptions;
    }

    public void clearExceptions(){
        this.exceptions.clear();
    }
}
