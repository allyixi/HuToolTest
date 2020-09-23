package test;

import java.util.*;

public class test1 {

    private static Map sensitiveWordMap;

    public static void main(String[] args) {
        Set<String> keyWordSet = new HashSet<>();
        keyWordSet.add("维他命");
        keyWordSet.add("维生素");
        addSensitiveWordToHashMap(keyWordSet);
        String str = "今天我吃了维他命";
        int a = 0;
        for (int i = 0; i < str.length(); i++) {
            a = checkSensitiveWord(str, i);
            if (a != 0) {
                System.out.println("存在敏感词:" + str.substring(i, i + a));
                break;
            }
        }
        if (a == 0) {
            System.out.println("没有敏感词");
        }

    }

    private static void addSensitiveWordToHashMap(Set<String> keyWordSet) {
        sensitiveWordMap = new HashMap(keyWordSet.size());
        String key = null;
        Map nowMap = null;
        Map<String, String> newWordMap = null;
        Iterator<String> iterator = keyWordSet.iterator();
        while (iterator.hasNext()) {
            key = iterator.next();
            nowMap = sensitiveWordMap;
            for (int i = 0; i < key.length(); i++) {
                char keyChar = key.charAt(i);
                Object wordMap = nowMap.get(keyChar);
                if (wordMap != null) {
                    nowMap = (Map) wordMap;
                } else {
                    newWordMap = new HashMap<>();
                    newWordMap.put("isEnd", "0");
                    nowMap.put(keyChar, newWordMap);
                    nowMap = newWordMap;
                }
                if (i == key.length() - 1) {
                    nowMap.put("isEnd", "1");
                }
            }
        }
    }

    private static int checkSensitiveWord(String txt, int beginIndex) {
        boolean flag = false;
        int matchFlag = 0;
        char word = 0;
        Map nowMap = sensitiveWordMap;
        for (int i = beginIndex; i < txt.length(); i++) {
            word = txt.charAt(i);
            nowMap = (Map) nowMap.get(word);
            if (nowMap != null) {
                matchFlag++;
                if ("1".equals(nowMap.get("isEnd"))) {
                    flag = true;
                }
            } else {
                break;
            }
        }
        if (matchFlag < 2 || !flag) {
            matchFlag = 0;
        }
        return matchFlag;
    }
}