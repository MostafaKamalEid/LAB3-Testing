package Lab3;

public class Main {
    public static void main(String[] args) {
        // create a new instance of FileHandler and pass the file path to the constructor from args[0]
        FileHandler fileHandler = new FileHandler(args[0]);
        // create a new instance of DataAnalyzer and pass the fileHandler to the constructor
        DataAnalyzer dataAnalyzer = new DataAnalyzer(fileHandler);
        // print the minimum value
        System.out.println("Min: " + dataAnalyzer.getMin());
        // print the maximum value
        System.out.println("Max: " + dataAnalyzer.getMax());
        // print the average value
        System.out.println("Average: " + dataAnalyzer.getAverage());

    }
}