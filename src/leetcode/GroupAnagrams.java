package leetcode;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return  new ArrayList<>();

        Map<String, List<String>> anagramsMap = new HashMap<>();
        groups(strs, anagramsMap, 0);

        return new ArrayList<>(anagramsMap.values());
    }

    void groups(String[] strs, Map<String, List<String>> anagramsMap, int i) {
        if (i >= strs.length) return;

        String key = getSortedString(strs[i]);
        List<String> str = anagramsMap.containsKey(key) ? anagramsMap.get(key) : new Stack<>();
        str.add(strs[i]);
        anagramsMap.put(key, str);

        groups(strs, anagramsMap, i+1);
    }

    String getSortedString(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return Arrays.toString(charArr);
    }

    public static void main(String[] args) {
        //String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = new String[]{"cat","rye","aye","cud","cat","old","fop","bra"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();

        System.out.println(groupAnagrams.groupAnagrams(strs));
    }
}

/*
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new Stack<>();
        if (strs == null || strs.length == 0) return result;

        int[] asciiArray = new int[strs.length];

        for (int i = 0; i < strs.length ; i++) {
            String val = strs[i];
            List<String> str = new Stack<>();
            if (asciiArray[i] != 0)
                continue;

            str.add(val);
            int asVal = getAsciiTotal(val);
            asciiArray[i] = asVal;

            for (int j = i + 1; j < strs.length; j++) {
                if (asciiArray[j] != 0) continue;
                String val2 = strs[j];
                int asVal2 = getAsciiTotal(val2);
                if (asVal == asVal2) {
                    asciiArray[j] = asVal;
                    str.add(val2);
                }
            }

            result.add(str);
        }
        return result;
    }

    int getAsciiTotal(String str) {
        int sum = 0, len = str.length();
        int unique = 0;
        String str1 = "";
        for (int i = 0; i < len; i++) {
            char v = str.charAt(i);
            if (!str1.contains(String.valueOf(v))) unique++;
            str1 += String.valueOf(v);
            sum += v;
        }
        return sum == 0 ? 1 : sum + unique + len;
    }



 */
