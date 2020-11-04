package com.dynamicintegration.Dynamic1;

import com.thingmagic.ReadListener;
import com.thingmagic.Reader;
import com.thingmagic.TagReadData;

import java.util.ArrayList;

public class D1ReadListener implements ReadListener {
    private final ArrayList<TagReadData> tagList = new ArrayList<>();

    public D1ReadListener(){}

    @Override
    public void tagRead(Reader reader, TagReadData tagReadData) {
        this.tagList.add(tagReadData);
    }

    public ArrayList<TagReadData> getTags(){
        return this.tagList;
    }

    public void clearTags(){
        tagList.clear();
    }




}
