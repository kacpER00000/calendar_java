/**
 * Enum określający tryb wyświetlania daty.
 *
 * Dostępne tryby:
 * <ul>
 *   <li>FULL_DATE - pełna data z nazwą dnia tygodnia</li>
 *   <li>DATE_WITHOUT_WEEKDAY - data bez nazwy dnia tygodnia</li>
 *   <li>DATE_WITH_ROMAN_NUM - data z numerem miesiąca w zapisie rzymskim</li>
 *   <li>SHORT_DATE} - skrócona forma daty z krótką nazwą dnia tygodnia i miesiąca</li>
 * </ul>
 */
public enum DateOutputMode {
    FULL_DATE,
    DATE_WITHOUT_WEEKDAY,
    DATE_WITH_ROMAN_NUM,
    SHORT_DATE
}
