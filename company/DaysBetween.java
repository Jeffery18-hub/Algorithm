package company;

import java.time.YearMonth;

public class DaysBetween {
    private static int getDays(int year, int month) {
        YearMonth ymobj = YearMonth.of(year, month);
        int daysInMonth = ymobj.lengthOfMonth();
        return daysInMonth;
    }

    public static int getDaysBetween(int[] date1, int[] date2) {
        int totalDays = 0;
        int y = date1[0];
        int m = date1[1];
        while(y <= date2[0]) {
            totalDays += getDays(y, m);
            if(m == 12) {
                y++;
                m = 1;
                continue;
            }

            if(y == date2[0] && m == date2[1] - 1) {
                break;
            }

            m++;
        }

        totalDays = totalDays - date1[2] + date2[2]; // handle the first month and last month
        return totalDays;
    }
}
 
