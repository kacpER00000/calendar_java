/**
 * Wyjątek zgłaszany, gdy podany dzień miesiąca wykracza poza dopuszczalny zakres dla danego miesiąca i roku.
 *
 * Dziedziczy po RuntimeException
 */
public class DayOutOfRangeException extends RuntimeException {
    /**
     * Tworzy nowy wyjątek z podanym komunikatem.
     *
     * @param message szczegółowy komunikat opisujący błąd
     */
    public DayOutOfRangeException(String message) {
        super(message);
    }
}
