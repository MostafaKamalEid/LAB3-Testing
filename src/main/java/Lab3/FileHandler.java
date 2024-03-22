package Lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;

public class FileHandler {
    private String filePath;

    public FileHandler() {
    }

    public FileHandler(String filePath) {
        setFilePath(filePath);
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
        // check if the file exists
        if (!Files.exists(Paths.get(filePath))) {
            throw new IllegalArgumentException("File does not exist: " + filePath);
        }

    }
    public Vector<Integer> GetData(){
        Vector<Integer> data = new Vector<>();
        // open the file to read
        String line = "";

        try {
            try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
                // get first line which is the number of elements
                line = reader.readLine();
                int n = Integer.parseInt(line);
                if (n <= 0) {
                    throw new IllegalArgumentException("Invalid number of elements: " + n);
                }
                // read the rest of the lines
                for (int i = 0; i < n; i++) {
                    line = reader.readLine();
                    if (line == null || line.isEmpty()) {
                        continue;
                    }
                    data.add(Integer.parseInt(line));
                }
                if (data.size() != n) {
                    throw new IllegalArgumentException("Data size does not match the number of elements: " + n);
                }
                return data;
            }
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid data: " + line);
        }
        catch (IOException e) {
            throw new IllegalArgumentException("Error reading file: " + filePath);
        }
    }
}
