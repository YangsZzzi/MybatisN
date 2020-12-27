package com.ys.pojo;
import java.util.HashMap;
import java.util.Map;

public class Main4{
    public static void main(String[] args)
    {
        Main4 solution = new Main4();
        // "0000000000001111,000F"
        System.out.println(solution.changeFormatNumber("15"));
        // "1111111111111111,FFFF"
        System.out.println(solution.changeFormatNumber("-1"));

        int num=(int)Math.pow(2, 15)-1;
        System.out.println(num);
        System.out.println(solution.changeFormatNumber(String.valueOf(num)));

        num=-(int)Math.pow(2, 15);
        System.out.println(num);
        System.out.println(solution.changeFormatNumber(String.valueOf(num)));

        num=(int)Math.pow(2, 15)+3;
        System.out.println(num);
        System.out.println(solution.changeFormatNumber(String.valueOf(num)));

        System.out.println(solution.changeFormatNumber("abc"));
    }
    /**
     * 将输入的十进制数字转换为对应的二进制字符串和十六进制字符串
     * @param number string字符串 十进制数字字符串
     * @return string字符串
     */
    public String changeFormatNumber (String number) {
        try
        {
            char[] chars=new char[16];
            // 先都转为正数 num
            int num = 0;
            boolean isPlus = true;
            if(number.charAt(0)=='-'){
                isPlus=false;
                number=number.substring(1);
            }
            num=Integer.parseInt(number);
            if(isPlus){
                if(num>32767){
                    return "NODATA";
                }
            }else{
                if(num>32768){
                    return "NODATA";
                }
            }
            for(int i=0;i<16;i++){
                int now=num&1;
                if(now==0){
                    chars[15-i]='0';
                }else{
                    chars[15-i]='1';
                }
                num=num>>1;
            }

            String binary = new String(chars);
            if(!isPlus){
                binary=changePlusToMinus(binary);
            }
            return binary+","+getHexByBinaryNumber(binary);
        } catch (Exception e)
        {
            return "INPUTERROR";
        }

    }
    /** 把16位的2进制正数变成16位的2进制负数，也就是对应的补码，即1111111111111111-number+1
     * @param number
     * @return
     */
    public String changePlusToMinus(String number){
        char[] chars=number.toCharArray();
        // 先1111111111111111-number
        for(int i=0;i<16;i++){
            if(chars[i]=='1'){
                chars[i]='0';
            }else{
                chars[i]='1';
            }
        }
        // 再+1  从右向左，找到第一个0，变成1，将右边全部都变成0
        // 即从右向左，1边0,继续    0变1，停止
        for(int i=15;i>=0;i--){
            if(chars[i]=='1'){
                chars[i]='0';
            }else{
                chars[i]='1';
                break;
            }
        }
        return new String(chars);

    }
    public Map<String, String> map=new HashMap<String, String>();
    {
        map.put("0000", "0");
        map.put("0001", "1");
        map.put("0010", "2");
        map.put("0011", "3");
        map.put("0100", "4");
        map.put("0101", "5");
        map.put("0110", "6");
        map.put("0111", "7");
        map.put("1000", "8");
        map.put("1001", "9");
        map.put("1010", "A");
        map.put("1011", "B");
        map.put("1100", "C");
        map.put("1101", "D");
        map.put("1110", "E");
        map.put("1111", "F");
    }
    /** 根据16位的二进制字符串返回4位的十六进制字符串
     * @param binaryNumber
     * @return
     */
    public String getHexByBinaryNumber(String binaryNumber){
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<16;i=i+4){
            builder.append(map.get(binaryNumber.substring(i, i+4)));
        }
        return builder.toString();
    }
}