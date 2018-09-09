package com.umbrella.financialteaching.model;

/**
 * Created by chenjun on 18/9/9.
 */

public class Notice {
    public int mType;
    public Object mContent;

    public Notice() {

    }

    public Notice(int type) {
        this.mType = type;
    }

    public Notice(int type, Object content) {
        this.mType = type;
        this.mContent = content;
    }
}
