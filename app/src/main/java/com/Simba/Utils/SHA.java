package com.Simba.Utils;

/**
 * SHA算法
 */
public class SHA {
    //1准备工作
    public static final int[]abcde={
            0x67452301,
    0xEFCDAB89,
            0x98BADCFE,
            0x10325476,
            0xC3D2E1F0
    };
    //摘要数据存储用的数组（存放密文的）
    public static int[] h=new int[5];
    //计算过程中需要用到的临时数据存储数组
    public static int[] m=new int[80];

    //定义辅助方法
    //将字符转换为十六进行制字符串
    public static String byteToHexString(byte b) {
        char[]digit={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        char[] ob=new char[2];

        ob[0]=digit[(b>>>4)&0x0F];//拿到高位
        ob[1]=digit[b&0x0f];//取低位

        String s=new String(ob);
        return s;

    }

    //将字节数组转换为十六进制字符串
    public static String byteArrayToHexString(byte[] byteArray) {
        String strDigest="";
        for (int i=0;i<byteArray.length;i++) {
            strDigest+=byteToHexString(byteArray[i]);
        }
        return strDigest;

    }

    //4字节数组转换为int
    public static int byteArrayToInt(byte[] byteData,int i) {
        return ((byteData[i]&0xff)<<24)|((byteData[i+1]&0xff)<<16)|((byteData[i+2]&0xff)<<8)|((byteData[i+3]&0xff));
    }
    //整数转换为4字节数组
    public static void intToByteArray(int value,byte[]byteData,int i) {
        byteData[i]=(byte)((value>>>24)&0xff);
        byteData[i+1]=(byte)((value>>>16)&0xff);
        byteData[i+2]=(byte)((value>>>8)&0xff);
        byteData[i+3]=(byte)(value&0xff);
    }

    public static int f1(int x,int y,int z) {
        return (x^y)|(~x&z);
    }

    public static int f2(int x,int y,int z) {
        return x^y^z;
    }

    public static int f3(int x,int y,int z) {
        return (x&y)|(x&z)|(y&z);
    }
    public static int f4(int x,int y,int z) {
        return x^y^z;
    }

    //进行对原始数据的补位
    public static byte[]byteArrayFormatData(byte[] byteData) {
        int fill=0;
        int size=0;
        int srcLength=byteData.length;
        int m=srcLength%64;
        if (m < 56) {
            fill=55-m;
            size=64;
        } else if (m == 56) {
            fill = 63;
            size = srcLength + 8 + 64;
        } else {
            fill=63-m+56;
            size=(srcLength+64)-m+64;
        }
        //补位后生成的新数组的内容
        byte[]newbyte=new byte[size];
        System.arraycopy(byteData,0,newbyte,0,srcLength);

        //补1
        int startLocation=srcLength;
        newbyte[startLocation++]=(byte)0x80;

        //补0
        for (int i=0;i<fill;i++) {
            newbyte[startLocation++]=0x00;
        }
        //处理长度的位置 字节*8=？位
        long n=(long)srcLength*8;
        byte h8= (byte) (n&0xff);
        byte h7= (byte) ((n>>8)&0xff);
        byte h6= (byte) ((n>>16)&0xff);
        byte h5= (byte) ((n>>24)&0xff);
        byte h4= (byte) ((n>>32)&0xff);
        byte h3= (byte) ((n>>40)&0xff);
        byte h2= (byte) ((n>>48)&0xff);
        byte h1= (byte) ((n>>56)&0xff);
        newbyte[startLocation++]=h1;
        newbyte[startLocation++]=h2;
        newbyte[startLocation++]=h3;
        newbyte[startLocation++]=h4;
        newbyte[startLocation++]=h5;
        newbyte[startLocation++]=h6;
        newbyte[startLocation++]=h7;
        newbyte[startLocation++]=h8;

        return newbyte;
    }

    //开始计算密文 算摘要
    public static int process_input_bytes(byte[]byteData) {
        System.arraycopy(abcde,0,h,0,abcde.length);
        //格式化数据
        byte[] newbyte=byteArrayFormatData(byteData);
        //计算有多少个大块
        int mCount=newbyte.length/64;

        //循环计算每一块的内容
        for (int pos=0;pos<mCount;pos++) {
          //对每一块进行加密计算

            for (int i=0;i<16;i++) {
                m[i]=byteArrayToInt(newbyte,(pos*64)+(i*4));

            }

        }
        return 20;

        //n是一个整数 且0<=n<=32 sn(x)=(x<<n)OR(x>>32-n)
        public static int s(int x ,int i){
            return x<<i |(x>>>(32-i));

        }



    }


}
