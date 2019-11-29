package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        HtmlReport report = new HtmlReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);

        JSONReport newReport = new JSONReport();
        String newText = newReport.generate("Report's", "Report's");
        System.out.println(newText);
    }
}