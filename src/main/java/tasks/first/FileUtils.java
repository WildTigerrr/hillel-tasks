package tasks.first;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtils {

    public List<String> getDistinctWords(String fileName) throws IOException {
        BufferedReader reader = getFileReader(fileName);
        String line;
        List<String> words = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            words.addAll(getWords(line));
        }
        return words;
    }

    private BufferedReader getFileReader(String fileName) throws FileNotFoundException {
        URL filePath = getClass().getClassLoader().getResource(fileName);
        if (filePath == null) {
            throw new FileNotFoundException();
        }
        File file = new File(filePath.getFile());
        return new BufferedReader(new FileReader(file));
    }

    private List<String> getWords(String line) {
        String ignoredCharacters = "[.,/\\-;:]";
        return Arrays.asList(
                line.replaceAll(ignoredCharacters, "")
                        .toLowerCase()
                        .split("\\s* \\s*")
        );
    }

}
