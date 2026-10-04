class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        StringBuilder suffix = new StringBuilder("a");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char first = word.charAt(0);

            if (isVowel(first)) {
                result.append(word);
            } else {
                result.append(word.substring(1)).append(first);
            }

            result.append("ma").append(suffix);
            if (i < words.length - 1) {
                result.append(" ");
            }
            suffix.append("a");
        }

        return result.toString();
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}