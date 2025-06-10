/**
 * Wyjątek zgłaszany, gdy numer miesiąca wykracza poza dozwolony zakres (np. nie mieści się w przedziale 1-12).
 *
 * Dziedziczy po IndexOutOfBoundsException.
 */
public class MonthOutOfRangeException extends IndexOutOfBoundsException {
    /**
     * Tworzy nowy wyjątek z podanym komunikatem.
     *
     * @param message szczegółowy komunikat opisujący błąd
     */
    public MonthOutOfRangeException(String message) {
        super(message);
    }
}
