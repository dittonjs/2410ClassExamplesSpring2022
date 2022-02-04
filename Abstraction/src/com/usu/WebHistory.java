package com.usu;

public class WebHistory {
    private class HistoryNode {
        String url;
        HistoryNode next;
        HistoryNode previous;
    }

    HistoryNode current;

    public void addToHistory(String string) {

    }

    public String goForward() { return ""; }

    public String goBack() {
        current = current.previous;
        return current.url;
    }
}
