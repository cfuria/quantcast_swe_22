import java.util.*;
import java.io.*;
import java.time.*;

public class ActiveCookie {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(args));
        String fileName = args[0];
        HashMap<String, List<ZonedDateTime>> cookieInstances = readCSV(fileName);
        LocalDate targetDate = LocalDate.parse(args[1]);

        int[] maxFrequency = {0};
        ArrayList<String> mostCommonCookies = new ArrayList<>();
        cookieInstances.forEach((cookie, timeStamps) -> {
            int frequency = 0;
            for (ZonedDateTime time : timeStamps) {
                if (time.toLocalDate().equals(targetDate)) {
                    frequency++;
                }
            }

            if (maxFrequency[0] == frequency && frequency > 0) {
                mostCommonCookies.add(cookie);
            } else if (maxFrequency[0] < frequency) {
                maxFrequency[0] = frequency;
                mostCommonCookies.removeAll(mostCommonCookies);
                mostCommonCookies.add(cookie);
            }
        });
        
        if (mostCommonCookies.size() == 0) {
            System.out.println("No cookies logged on this day.");
        } else {
            for (int i = 0; i < mostCommonCookies.size(); i++) {
                System.out.println(mostCommonCookies.get(i));
            }
        }
    }

    public static HashMap<String, List<ZonedDateTime>> readCSV(String fileName) throws IOException {
        HashMap<String, List<ZonedDateTime>> cookieInstances = new HashMap<>();

        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String cookieInstance;
            while ((cookieInstance = in.readLine()) != null) {
                String[] cookieParams = cookieInstance.split(",");
                if (cookieInstances.containsKey(cookieParams[0])) {
                    cookieInstances.get(cookieParams[0]).add(ZonedDateTime.parse(cookieParams[1]));
                } else {
                    cookieInstances.put(cookieParams[0], new ArrayList<ZonedDateTime>());
                    cookieInstances.get(cookieParams[0]).add(ZonedDateTime.parse(cookieParams[1]));
                }
            }
        }
        return cookieInstances;
    }
}
