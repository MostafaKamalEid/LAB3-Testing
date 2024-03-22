
import Lab3.FileHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileHandlerTest {

    @TempDir
    Path tempDir;

    @Test
    public void testGetData() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("3\n1\n2\n3\n");
        }


        FileHandler fileHandler = new FileHandler(tempFile.toString());
        Vector<Integer> expectedData = new Vector<>();
        expectedData.add(1);
        expectedData.add(2);
        expectedData.add(3);

        assertEquals(expectedData, fileHandler.GetData());
    }
    @Test
    public void testGetDataWithInvalidData() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("3\n1\n2\na\n");
        }
        FileHandler fileHandler = new FileHandler(tempFile.toString());
        Exception exception = assertThrows(IllegalArgumentException.class, fileHandler::GetData);
        assertEquals("Invalid data: a", exception.getMessage());
    }
    @Test
    public void testGetDataWithInvalidNumberOfElements() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("0\n1\n2\n3\n");
        }
        FileHandler fileHandler = new FileHandler(tempFile.toString());
        Exception exception = assertThrows(IllegalArgumentException.class, fileHandler::GetData);
        assertEquals("Invalid number of elements: 0", exception.getMessage());
    }
    @Test
    public void testGetDataWithInvalidDataSize() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("3\n1\n2\n");
        }
        FileHandler fileHandler = new FileHandler(tempFile.toString());
        Exception exception = assertThrows(IllegalArgumentException.class, fileHandler::GetData);
        assertEquals("Data size does not match the number of elements: 3", exception.getMessage());
    }


    @Test
    public void testGetDataWithNonExistentFile() {
        String nonExistentFilePath = "nonExistentFile.txt";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new FileHandler(nonExistentFilePath));
        assertEquals("File does not exist: " + nonExistentFilePath, exception.getMessage());
    }
    @Test
    public void testGetDataWithIOException() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("3\n1\n2\n3\n");
        }
        FileHandler fileHandler = new FileHandler(tempFile.toString());
        Files.delete(tempFile);
        Exception exception = assertThrows(IllegalArgumentException.class, fileHandler::GetData);
        assertEquals("Error reading file: " + tempFile.toString(), exception.getMessage());
    }
}