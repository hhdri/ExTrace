package com.hhdri.extrace;

import java.util.Dictionary;
import java.util.Hashtable;

public class EMoney {
    private String moneyName;
    private float buyPrice;
    private float sellPrice;
    private float reserve;
    private int imageReference;

    private Dictionary<String, String> dict= new Hashtable<String, String>();
    private Dictionary<String, Integer> picDict= new Hashtable<String, Integer>();
    public String getMoneyName() {
        return moneyName;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public float getReserve() {
        return reserve;
    }

    public Dictionary<String, String> getDict() {
        return dict;
    }

    public int getImageReference() {
        return imageReference;
    }

    private void fillDict() {
        dict.put("3", "Bitcoin");
        dict.put("7", "Litecoin");
        dict.put("8", "Ethereum");
        dict.put("9", "Dash");
        dict.put("10", "Bitcoin Cash");
        dict.put("11", "ZCash");
        dict.put("12", "Ripple");
        dict.put("13", "Monero");
        dict.put("14", "Bitcoin Gold");
        dict.put("15", "Etehereum Classic");
        dict.put("16", "IOTA");

        picDict.put("Bitcoin", R.drawable.btc);
        picDict.put("Litecoin", R.drawable.ltc);
        picDict.put("Ethereum", R.drawable.eth);
        picDict.put("Dash", R.drawable.dash);
        picDict.put("Bitcoin Cash", R.drawable.bch);
        picDict.put("ZCash", R.drawable.zec);
        picDict.put("Ripple", R.drawable.xrp);
        picDict.put("Monero", R.drawable.xmr);
        picDict.put("Bitcoin Gold", R.drawable.btg);
        picDict.put("Etehereum Classic", R.drawable.etc);
        picDict.put("IOTA", R.drawable.miota);
    }
    public EMoney(String moneyName, String buyPrice, String sellPrice, String reserve) {
        fillDict();
        this.moneyName = dict.get(moneyName);
        this.buyPrice = Float.parseFloat(buyPrice);
        this.sellPrice = Float.parseFloat(sellPrice);
        this.reserve = Float.parseFloat(reserve);
        this.imageReference = picDict.get(this.moneyName);
    }

    public EMoney() {
        fillDict();
    }
}
