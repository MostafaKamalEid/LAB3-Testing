
import Lab3.DataAnalyzer;
import Lab3.FileHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class DataAnalyzerTest {

    @Test
    public void testGetMin() {
        FileHandler fileHandler = Mockito.mock(FileHandler.class);
        Vector<Integer> data = new Vector<>();
        data.add(1);
        data.add(2);
        data.add(3);
        when(fileHandler.GetData()).thenReturn(data);

        DataAnalyzer dataAnalyzer = new DataAnalyzer(fileHandler);
        assertEquals(1, dataAnalyzer.getMin());
    }

    @Test
    public void testGetMax() {
        FileHandler fileHandler = Mockito.mock(FileHandler.class);
        Vector<Integer> data = new Vector<>();
        data.add(1);
        data.add(2);
        data.add(3);
        when(fileHandler.GetData()).thenReturn(data);

        DataAnalyzer dataAnalyzer = new DataAnalyzer(fileHandler);
        assertEquals(3, dataAnalyzer.getMax());
    }

    @Test
    public void testGetAverage() {
        FileHandler fileHandler = Mockito.mock(FileHandler.class);
        Vector<Integer> data = new Vector<>();
        data.add(1);
        data.add(2);
        data.add(3);
        when(fileHandler.GetData()).thenReturn(data);

        DataAnalyzer dataAnalyzer = new DataAnalyzer(fileHandler);
        assertEquals(2, dataAnalyzer.getAverage());
    }
}