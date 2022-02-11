package com.usu.gridlayout;

public class PhoneButtonData {

    public static enum ButtonType {
        Number,
        Call,
        Clear
    }

    final public int textId;
    final public int row;
    final public int col;
    final public int colSpan;
    final public ButtonType type;

    public PhoneButtonData(int textId, int row, int col, int colSpan, ButtonType type) {
        this.textId = textId;
        this.row = row;
        this.col = col;
        this.colSpan = colSpan;
        this.type = type;
    }
}
