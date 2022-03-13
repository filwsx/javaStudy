package com.filwsx.bean;

/**
 * @author filwsx
 * @date 2022-03-13 17:27
 */
public class Fruit {
    private String fname;
    private double fprice;
    private int fcount;
    private String remark;

    public Fruit() {

    }

    public Fruit(String fname, double fprice, int fcount, String remark) {
        this.fname = fname;
        this.fprice = fprice;
        this.fcount = fcount;
        this.remark = remark;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public double getFprice() {
        return fprice;
    }

    public void setFprice(double fprice) {
        this.fprice = fprice;
    }

    public int getFcount() {
        return fcount;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "fruit{" +
                "fname='" + fname + '\'' +
                ", fprice=" + fprice +
                ", fcount=" + fcount +
                ", remark='" + remark + '\'' +
                '}';
    }
}
