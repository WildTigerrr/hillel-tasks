import tasks.first.FileUtils;
import tasks.second.CollectionUtils;
import tasks.third.IncrementSynchronize;
import tasks.third.IncrementSynchronizeFetcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HillelApplication {

    public static void main(String[] args) {
        tryGetDistinctWords();

        tryGetArrayToCollection();

        tryGetSynchronizedIncrement(IncrementSynchronizeFetcher.SynchronizationMethod.KEYWORD);
    }

    private static void tryGetDistinctWords() {
        System.out.println("Task 1");
        try {
            List<String> words = new FileUtils().getDistinctWords("test-words.txt");
            for (String word : words) {
                System.out.println(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("========================");
    }

    private static void tryGetArrayToCollection() {
        System.out.println("Task 2");
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };
        Integer[] array = new Integer[]{4, 5, 6};
        list = (List<Integer>) new CollectionUtils().merge(list, array);
        System.out.println(list);
        System.out.println("========================");
    }

    private static void tryGetSynchronizedIncrement(IncrementSynchronizeFetcher.SynchronizationMethod method) {
        System.out.println("Task 3");
        IncrementSynchronize increment = new IncrementSynchronize();

        IncrementSynchronizeFetcher fetcherFirst = new IncrementSynchronizeFetcher(increment, method);
        IncrementSynchronizeFetcher fetcherSecond = new IncrementSynchronizeFetcher(increment, method);
        IncrementSynchronizeFetcher fetcherThird = new IncrementSynchronizeFetcher(increment, method);

        fetcherFirst.start();
        fetcherSecond.start();
        fetcherThird.start();
    }

}
