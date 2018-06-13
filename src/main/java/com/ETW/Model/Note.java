package com.ETW.Model;

public class Note extends AbstractBaseModel {

    private String selectedString;
    private int startIndex;
    private String title;
    private String content;
    private long ownerId;

    public String getSelectedString() {
        return selectedString;
    }

    public void setSelectedString(String selectedString) {
        this.selectedString = selectedString;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Note{" +
                "selectedString='" + selectedString + '\'' +
                ", startIndex=" + startIndex +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", ownerId=" + ownerId +
                '}';
    }
}
