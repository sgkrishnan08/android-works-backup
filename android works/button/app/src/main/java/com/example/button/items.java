package com.example.button;

public class items
{
    private static String sno,noOfPieces,companyName;
    private static String itemName,hsn;
    private static String rate,value,cgst,sgst,amount,discount;
    public items(String noOfPieces,String itemName,String hsn,String rate,String value,
    String cgst,String sgst, String amount, String discount)
    {
        this.noOfPieces = noOfPieces;
        this.itemName = itemName;
        this.hsn = hsn;
        this.rate = rate;
        this.value = value;
        this.cgst =  cgst;
        this.sgst = sgst;
        this.amount = amount;
        this.discount = discount;
    }
    public String getcn()
    {
        return companyName;
    }
    public String getpc()
    {
        return noOfPieces;
    }
    public String getin()
    {
        return itemName;
    }
    public String gethsn()
    {
        return hsn;
    }
    public String getv()
    {
        return value;
    }
    public String getr()
    {
        return rate;
    }
    public String getcgst()
    {
        return cgst;
    }
    public String getsgst()
    {
        return sgst;
    }
    public String getamt()
    {
        return amount;
    }
    public String getdis()
    {
        return discount;
    }
}
