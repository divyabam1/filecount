import java.io.File;

public class ExcelFileCounter {

    public static void main(String[] args) {
        // Specify the directory (D drive in this case)
        File directory = new File("D:/"); // Make sure this is the correct drive and directory

        // Check if directory exists
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        // Call the method to count Excel files
        int excelFileCount = countExcelFiles(directory);

        System.out.println("Number of Excel files in D drive: " + excelFileCount);
    }

    // Method to count Excel files
    public static int countExcelFiles(File dir) {
        int count = 0;

        // Get all files and directories in the given directory
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                System.out.println("Checking: " + file.getName()); // Debugging print
                // If it's a directory, recursively count Excel files inside it
                if (file.isDirectory()) {
                    count += countExcelFiles(file);
                }
                // Check if the file is an Excel file (.xls or .xlsx)
                else if (file.isFile() && (file.getName().endsWith(".xls") || file.getName().endsWith(".xlsx"))) {
                    System.out.println("Found Excel file: " + file.getName()); // Debugging print
                    count++;
                }
            }
        } else {
            System.out.println("Could not list files in: " + dir.getAbsolutePath());
        }

        return count;
    }
}
