package com.company.outputs;

public class RomanOutput implements OutputStrategy{
    @Override
    public String output(int exp) {
        if(exp<=0){
            throw new ArithmeticException("Значение не существует");
        }
      return intToRoman(exp);
    }
   private  String intToRoman(int num)
    {

        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
