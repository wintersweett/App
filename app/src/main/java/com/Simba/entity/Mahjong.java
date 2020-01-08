package com.Simba.entity;
//https://www.jianshu.com/writer#/notebooks/35732481/notes/52591522/writing

//麻将

public class Mahjong {
    public int suit;//筒 万 锁
    public int rank;//点数
    public Mahjong(int suit,int rank) {
        this.suit=suit;
        this.rank=rank;
    }

    @Override
    public String toString() {
        return this.suit+" "+this.rank;
    }
}
