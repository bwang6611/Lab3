import java.io.IOException;

import java.net.URL;

import java.util.Scanner;

public class Webscraper {

    private static final String ONE_WORD = "prince";

    public static void main(String[] args) {
        System.out.println(oneWordCounter(urlToString("http://erdani.com/tdpl/hamlet.txt")));
    }

    public static int wordCounter(String words) {
        String[] wordArr = words.split("\\s+");
        if (wordArr == null || wordArr.length == 0) {
            return 0;
        }
        return wordArr.length;
    }

    public static int oneWordCounter(String words) {
        String[] wordArr = words.split("\\s+");
        int counter = 0;
        if (wordArr == null || wordArr.length == 0) {
            return 0;
        }
        for (int i = 0; i < wordArr.length; i++) {
            if (wordArr[i].toLowerCase().contains(ONE_WORD.toLowerCase())) {
                counter++;
            }
        }
        return counter;
    }
    /**

     * Retrieve contents from a URL and return them as a string.

     *

     * @param url url to retrieve contents from

     * @return the contents from the url as a string, or an empty string on error

     */

    public static String urlToString(final String url) {

        Scanner urlScanner;

        try {

            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");

        } catch (IOException e) {

            return "";

        }

        String contents = urlScanner.useDelimiter("\\A").next();

        urlScanner.close();

        return contents;

    }
}


