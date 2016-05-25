package com.serial;

import java.io.*;

/**
 * 在序列化过程中，虚拟机会试图调用对象类里的 writeObject 和 readObject 方法，
 * 进行用户自定义的序列化和反序列化，如果没有这样的方法，则默认调用是 ObjectOutputStream 的
 * defaultWriteObject 方法以及 ObjectInputStream 的 defaultReadObject 方法。
 * 用户自定义的 writeObject 和 readObject 方法可以允许用户控制序列化的过程，
 * 比如可以在序列化的过程中动态改变序列化的数值。基于这个原理，可以在实际应用中得到使用，
 * 用于敏感字段的加密工作
 */
public class Testserial implements  Serializable{
    private static final long serialVersionUID = 1L;

    private String password = "pass";

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void writeObject(ObjectOutputStream out) {
        try {
            ObjectOutputStream.PutField putFields = out.putFields();
            System.out.println("原密码:" + password);
           // password = "encryption";//模拟加密
            putFields.put("password", password);
            System.out.println("加密后的密码" + password);
            out.writeFields();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream in) {
        try {
            ObjectInputStream.GetField readFields = in.readFields();
            Object object = readFields.get("password", "");
            System.out.println("要解密的字符串:" + object.toString());
            password = "pass";//模拟解密,需要获得本地的密钥
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("result.obj"));
            Testserial testerial = new Testserial();
            out.writeObject(testerial);
           // Testserial testerial2 = new Testserial();
            testerial.setPassword("09");
            out.writeObject(testerial);
            out.close();

            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
                    "result.obj"));
            Testserial t = (Testserial) oin.readObject();
            Testserial t2 = (Testserial) oin.readObject();
            System.out.println("解密后的字符串:" + t.getPassword());
            System.out.println("解密后的字符串:" + t2.getPassword());
            oin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
