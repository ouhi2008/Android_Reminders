package com.apress.gerber.reminders;

/**
 * Created by fwang5 on 2/16/2016.
 */
public class Reminder {
    private int mId;
    private String mContent;
    private int mImportant;

    public Reminder(int id, String content, int important) {
        mId = id;
        mContent = content;
        mImportant = important;
    }

    public String getContent() {

        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public int getImportant() {
        return mImportant;
    }

    public void setImportant(int important) {
        mImportant = important;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }
}
