import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomSortedArray {
    private final int[] array;

    public RandomSortedArray(int size, int bound) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        this.array = new int[size];
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = random.nextInt(bound);
        }
        Arrays.sort(this.array);
    }

    public int[] getArray() {
        return array;
    }
}
