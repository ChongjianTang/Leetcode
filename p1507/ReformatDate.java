package leetcode.p1507;

public class ReformatDate {
    public static String reformatDate(String date) {
        String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] data = date.split(" ");
        String result = "";
        result += data[2] + '-';
        for (int i = 0; i < months.length; i++) {
            if (data[1].equals(months[i])) {
                if (i < 9) {
                    result += "0" + (i + 1);
                } else {
                    result += "" + (i + 1);
                }
            }
        }
        result += '-';
        if (Character.isDigit(data[0].charAt(1))) {
            result += date.substring(0, 2);
        } else {
            result += "0" + data[0].charAt(0);
        }
        return result;
    }
}
