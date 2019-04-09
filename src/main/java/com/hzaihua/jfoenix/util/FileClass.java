package com.hzaihua.jfoenix.util;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FileClass {
    private static String sourse = "C:\\Users\\hzaihua\\Desktop\\class.txt";
    private static String outAddress = "C:\\Users\\hzaihua\\Desktop\\class_demo2.txt";

    public static void main(String[] args) {
        int m = 0;
        try {
            int count_L = 0;
            int loopCount = 0;
            // 源文件位置，打开它
            FileInputStream fin = new FileInputStream(sourse);
            InputStreamReader isr = new InputStreamReader(fin);
            BufferedReader br = new BufferedReader(isr);
            // 输出文件位置
            FileOutputStream fout = new FileOutputStream(outAddress);
            OutputStreamWriter osw = new OutputStreamWriter(fout);
            BufferedWriter bw = new BufferedWriter(osw);
            // 读一行
            String sp = br.readLine();
            // 只要没有读到文件尾就一直执行
            Set<String> result = new HashSet<String>();
            while (sp != null) {
                // 只读取以"[L"为开头的行
                m++;
                System.out.println(m);
                if (sp.substring(0, 2).equals("[L")&&sp.contains("from D")) {
                    // 以空格来分隔这个行，返回的字符串数组中的第二个就是我们需要的信息
                    String s = sp.substring(sp.lastIndexOf("from D")-1,sp.length()-1);
                    result.add(s);
                }
                // 读行
                sp = br.readLine();
            }
            System.out.println(result);
            // 两个测试输出
            System.out.println(count_L);
            System.out.println(loopCount);
            // 千万要把两个文件关闭！！！
            // 千万要把两个文件关闭！！！
            // 千万要把两个文件关闭！！！
            // 重要的事情说三遍，如果没有关闭，数据可能不能完全输出。
            // 个人认为这个和数据的大小有一定关系。还和输出数据的格式有关系。虽然我说不清楚，但是，一定要关闭，不然就要炸，boom~~
            br.close();
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
