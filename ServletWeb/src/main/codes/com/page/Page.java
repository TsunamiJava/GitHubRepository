package com.page;

public class Page {
    //页码
    private int index = 1;
    //显示行数
    private int size = 5;
    //总行数
    private int total;

    public Page(int index,int size,int total){
        super();
        this.index=index;
        this.size=size;
        this.total=total;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
