package Lab3;
public class DataAnalyzer {
    private FileHandler fileHandler;
    public DataAnalyzer(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }
    public int getMin() {
        return fileHandler.GetData().stream().min(Integer::compare).orElse(0);
    }
    public int getMax() {
        return fileHandler.GetData().stream().max(Integer::compare).orElse(0);
    }
    public int getAverage() {
        return (int) fileHandler.GetData().stream().mapToInt(Integer::intValue).average().orElse(0);
    }
}
