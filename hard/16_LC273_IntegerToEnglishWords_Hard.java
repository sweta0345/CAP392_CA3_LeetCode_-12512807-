class Solution {

    private String[] belowTwenty = {
        "", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen",
        "Fourteen", "Fifteen", "Sixteen",
        "Seventeen", "Eighteen", "Nineteen"
    };

    private String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty",
        "Ninety"
    };

    private String[] thousands = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        String result = "";
        int index = 0;

        while (num > 0) {

            int part = num % 1000;

            if (part != 0) {

                String words = convert(part);

                result = words
                       + (thousands[index].isEmpty()
                          ? "" : " " + thousands[index])
                       + (result.isEmpty() ? "" : " " + result);
            }

            num = num / 1000;
            index++;
        }

        return result.trim();
    }

    private String convert(int num) {

        if (num == 0) {
            return "";
        }

        if (num < 20) {
            return belowTwenty[num];
        }

        if (num < 100) {
            return tens[num / 10]
                   + (num % 10 == 0
                      ? "" : " " + belowTwenty[num % 10]);
        }

        return belowTwenty[num / 100]
               + " Hundred"
               + (num % 100 == 0
                  ? "" : " " + convert(num % 100));
    }
}
