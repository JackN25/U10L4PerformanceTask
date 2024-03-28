import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Process {

    private int runtime;
    private String name;
    private String[] subProcesses;

    public Process(String n, int t, String[] subs) {
        runtime = t;
        name = n;
        subProcesses = subs;
    }

    public static int determineRuntime(ArrayList<Process> arrayList, String name) {
        Process pToCheck = null;
        int totalRuntime = 0;
        for (int i = 0; i < arrayList.size(); i ++) {
            if (arrayList.get(i).getName().equals(name)) {
                pToCheck = arrayList.get(i);
                totalRuntime = pToCheck.getRuntime();
            }
        }
        for (String p : pToCheck.getSubProcesses()) {
            totalRuntime += determineRuntime(arrayList, p);
        }
        return totalRuntime;
    }

    public int getRuntime() {
        return runtime;
    }

    public String getName() {
        return name;
    }

    public String[] getSubProcesses() {
        return subProcesses;
    }

    @Override
    public String toString() {
        return name + "\n" + runtime + "\n" + Arrays.toString(subProcesses) + "\n\n\n";
    }
}
