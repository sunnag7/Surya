package com.sun.surya;

import java.util.Date;

public class MasterFlow implements Comparable<MasterFlow>  {
    private Integer index;
    private int type; //1- article, 2 estaetEstimate, 3- estatesale
    private Date date;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(MasterFlow masterFlow) {
        return getDate().compareTo(masterFlow.getDate());
    }
}
