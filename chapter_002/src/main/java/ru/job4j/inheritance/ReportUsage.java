package ru.job4j.inheritance;

public class ReportUsage {

    public static void main(String[] args) {
        JSONReport newReport = new JSONReport();
        String newText = newReport.generate("Report's", "Report's");
        System.out.println(newText);
    }
}