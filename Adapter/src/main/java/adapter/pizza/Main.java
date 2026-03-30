package adapter.pizza;

public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();

        date.setYear(2024);
        date.setMonth(12);  // December
        date.setDay(29);

        System.out.println("Initial date: " + date); // 2024-12-29

        date.advanceDays(5);
        System.out.println("After advancing 5 days: " + date); // 2025-01-03

        date.advanceDays(31);
        System.out.println("After advancing 31 more days: " + date); // 2025-02-03

        // Lấy từng thành phần
        System.out.println("Year: " + date.getYear());
        System.out.println("Month: " + date.getMonth());
        System.out.println("Date: " + date.getDay());
    }
}