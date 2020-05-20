package com.example.myappproject.Networking.ResponseStructures;

public class Weather {
    private String ts;
    private int tp;
    private int pr;
    private int hu;
    private float ws;
    private int wd;
    private String ic;

    public Weather(String ts, int tp, int pr, int hu, float ws, int wd, String ic) {
        this.ts = ts;
        this.tp = tp;
        this.pr = pr;
        this.hu = hu;
        this.ws = ws;
        this.wd = wd;
        this.ic = ic;
    }

    public String getTs() {
        return ts;
    }

    public int getTp() {
        return tp;
    }

    public int getPr() {
        return pr;
    }

    public int getHu() {
        return hu;
    }

    public float getWs() {
        return ws;
    }

    public int getWd() {
        return wd;
    }

    public String getIc() {
        return ic;
    }
}
