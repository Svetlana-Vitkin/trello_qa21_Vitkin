package com.trello.qa.model;

public class BoardData {
    private  String boardName;
    private  String s;

    public BoardData setBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    public BoardData setS(String s) {
        this.s = s;
        return  this;
    }

    public String getBoardName() {
        return boardName;
    }

    @Override
    public String toString() {
        return "BoardData{" +
                "boardName='" + boardName + '\'' +
                '}';
    }

    public String getS() {
        return s;
    }
// public String getS() {
    // }
}
