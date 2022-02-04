package com.usu.gridlayout;

public class PhoneButtonData {

    public static enum ButtonType {
        Number,
        Call,
        Clear
    }

    final public String text;
    final public int row;
    final public int col;
    final public int colSpan;
    final public ButtonType type;

    public PhoneButtonData(String text, int row, int col, int colSpan, ButtonType type) {
        this.text = text;
        this.row = row;
        this.col = col;
        this.colSpan = colSpan;
        this.type = type;
    }
}
