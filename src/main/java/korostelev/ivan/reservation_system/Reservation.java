package korostelev.ivan.reservation_system;

import java.time.LocalDate;

public record Reservation(
        Long id,
        Long userId,
        Long roomID,
        LocalDate startDate,
        LocalDate endDate,
        ReservationStatus status
) {

}
