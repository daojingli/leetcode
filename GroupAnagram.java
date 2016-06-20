/**
 * Given an array of strings, group anagrams together.
 *
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 *
 * Return: 
 * [
 *  ["ate", "eat","tea"],
 *  ["nat","tan"],
 *  ["bat"]
 * ]
 */
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String keys = String.valueOf(arr);
            if (!map.containsKey(keys)) map.put(keys, new ArrayList<String>());
            map.get(keys).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}