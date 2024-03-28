import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Process> processArrayList = new ArrayList<Process>();
        File f = new File("data/processData");
        processArrayList = processFile(f, processArrayList);
        System.out.println(Process.determineRuntime(processArrayList, "xaxuyg"));
        //System.out.println(processArrayList.toString());
    }

    private static ArrayList<Process> processFile(File f, ArrayList<Process> array) {
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String currentLine = s.nextLine();
                String name = currentLine.substring(0, currentLine.indexOf(" "));
                int runtime = Integer.parseInt(currentLine.substring(currentLine.indexOf("(") + 1, currentLine.indexOf(")")));
                String[] subprocesses;
                if (currentLine.contains("->")) {
                    currentLine = currentLine.substring(currentLine.indexOf(">") + 2);
                    subprocesses = currentLine.split(", ");
                } else {
                    subprocesses = new String[0];
                }
                Process p = new Process(name, runtime, subprocesses);
                array.add(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Problem while processing file.");
        }
        return array;
    }
}