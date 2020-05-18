package com.example.myappproject.Networking.ResponseStructures;

public class Pollution {

    private String ts;
    private int aqius;
    private String mainus;
    private int aqicn;
    private String maincn;

    public Pollution(String ts, int aqius, String mainus, int aqicn, String maincn) {
        this.ts = ts;
        this.aqius = aqius;
        this.mainus = mainus;
        this.aqicn = aqicn;
        this.maincn = maincn;
    }

    public String getTs() {
        return ts;
    }

    public int getAqius() {
        return aqius;
    }

    public String getMainus() {
        return mainus;
    }

    public int getAqicn() {
        return aqicn;
    }

    public String getMaincn() {
        return maincn;
    }
}
