package com.backend.bakckend.designpattern.waste;


import java.util.Hashtable;

class BigChar{
    private char charname;
    private String fontdata;
    public BigChar(char charname) {
        this.charname = charname;
        try {
            this.fontdata = readFontData(charname);
        } catch (Exception e) {
            this.fontdata = charname + "?";
        }
    }
    private String readFontData(char charname) {
        return "fontdata";
    }
    public void print() {
        System.out.println(fontdata);
    }
}

class BigCharFactory{

    private Hashtable<String,BigChar> pool = new Hashtable<String,BigChar>();
    private static BigCharFactory singleton = new BigCharFactory();
    private BigCharFactory() {
    }

    public static BigCharFactory getInstance() {
        return singleton;
    }

    public synchronized BigChar getBigChar(char charname) {
        BigChar bc = (BigChar) pool.get("" + charname);
        if(bc == null) {
            bc = new BigChar(charname);
            pool.put("" + charname, bc);
        }
        return bc;
    }

}


class BigString{

    private BigChar[] bigchars;
    public BigString(String string) {
        bigchars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    public void print() {
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i].print();
        }
    }

}

public class Flyweight {

    public static void main(String[] args) {
        BigString bs = new BigString("1234567890");
        bs.print();
    }
}
