package com.asi.addtorecyclerviewatruntime;

/**
 * Created by ASI on 18/07/2016.
 */
public class FeedItem {
    private String NAME;
    private String MAIL;
    FeedItem(String NAME,String MAIL)
    {
        this.MAIL=MAIL;
        this.NAME=NAME;
    }
    public String getNAME()
    {
        return NAME;
    }
    public void setNAME (String NAME)
    {
        this.NAME=NAME;
    }
    public String getMAIL()
    {
        return MAIL;
    }
    public void setMAIL(String MAIL)
    {
        this.MAIL=MAIL;
    }
}