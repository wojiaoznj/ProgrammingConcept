package com.diagens.three;

/**
 * @author ZNJ
 * @create 2019/2/17-22:04
 */
public class ExchangePass extends StringProcessor {
    String srcStr;
    public ExchangePass(String srcStr){
        this.srcStr=srcStr;
    }

    @Override
    public String process(Object input) {
        String retStr = "";
        char[] srcChr = srcStr.toCharArray();
        for (int i = 0; i < srcChr.length; i = i + 2) {
            retStr = retStr + srcChr[i + 1];
            retStr = retStr + srcChr[i];
        }
        return retStr;
    }
}
