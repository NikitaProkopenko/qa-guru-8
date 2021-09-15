package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String month, String year, String day) {
        String daySelector = ".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)";
        String formatedDaySelector = String.format(daySelector, day);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(formatedDaySelector).click();
    }
}
