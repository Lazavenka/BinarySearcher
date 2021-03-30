import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinarySearcher {
    private static final Logger logger = LoggerFactory.getLogger(BinarySearcher.class);

    public static int search(int[] array, int key, int startIndex, int endIndex) {
        logger.debug("Search key = " + key + " in array -> " + partArrayToString(array, startIndex, endIndex));
        logger.debug("Start index = " + startIndex + ", end index = " + endIndex);
        int midIndex = (startIndex + endIndex) / 2;
        logger.debug("MidIndex = " + midIndex);

        if (startIndex > endIndex) {
            logger.debug("StartIndex = " + startIndex + " is more than endIndex = " + endIndex);
            logger.debug("Search failed. Return -" + midIndex);

            return -midIndex;
        } else if (key == array[midIndex]) {
            logger.debug("Voila! Key=" + key + " is equals array[midIndex]=" + array[midIndex] + " at index " + midIndex);
            logger.debug("Search successful! Returned index = " + midIndex);
            return midIndex;
        } else if (key < array[midIndex]) {
            logger.debug("\"Key\" = " + key + " < " + array[midIndex] + " at index = " + midIndex);
            logger.debug("Changed End Index from " + endIndex + " to " + (midIndex - 1));
            endIndex = midIndex - 1;

            logger.debug("Continue to search on the left side.");
            logger.debug("--------- And Recursion! ---------");
            return search(array, key, startIndex, endIndex);
        } else if (key > array[midIndex]) {
            logger.debug("\"Key\" = " + key + " > " + array[midIndex] + " at index + " + midIndex);
            logger.debug("Changed Start Index from " + startIndex + " to " + (midIndex + 1));
            startIndex = midIndex + 1;

            logger.debug("Continue to search on the right side.");
            logger.debug("--------- And Recursion! ---------");
            return search(array, key, startIndex, endIndex);
        }
        return 0;
    }

    private static String partArrayToString(int[] array, int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = start; i < end + 1; i++) {
            if (i != end) {
                sb.append(array[i]).append(' ');
            } else sb.append(array[i]);
        }
        sb.append(']');
        return sb.toString();
    }
}
