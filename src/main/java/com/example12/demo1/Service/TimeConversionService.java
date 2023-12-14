package com.example12.demo1.Service;

import com.example12.demo1.Exceptions.TimeConversionException;
import org.springframework.stereotype.Service;

@Service
public class TimeConversionService {
    private static final String[] HOURS_WORDS = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve"
    };

    private static final String[] MINUTES_WORDS = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"
    };

    private static final String[] TENS_WORDS = {
            "", "", "twenty", "thirty", "forty", "fifty"
    };

    public String convertToWords(String time) throws TimeConversionException {
        try {
            String[] timeParts = time.split(":");
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);

            if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
                throw new TimeConversionException("Invalid time format");
            }

            StringBuilder result = new StringBuilder("It's");

            // Convert hours to words
            if (hours == 0) {
                result.append(" twelve");
            } else if (hours <= 12) {
                result.append(" ").append(HOURS_WORDS[hours]);
            } else {
                result.append(" ").append(HOURS_WORDS[hours - 12]);
            }

            // Convert minutes to words
            if (minutes > 0) {
                if (minutes <= 19) {
                    result.append(" ").append(MINUTES_WORDS[minutes]);
                } else {
                    result.append(" ").append(TENS_WORDS[minutes / 10]);
                    if (minutes % 10 > 0) {
                        result.append(" ").append(MINUTES_WORDS[minutes % 10]);
                    }
                }
            }

            return result.toString().trim();

        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new TimeConversionException("Invalid time format");
        }
    }
}
