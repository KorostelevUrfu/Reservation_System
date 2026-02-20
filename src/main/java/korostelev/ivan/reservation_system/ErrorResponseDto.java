package korostelev.ivan.reservation_system;

import java.time.LocalDateTime;

public class ErrorResponseDto {
    private String message;
    private String detailedMessage;
    private LocalDateTime errorTime;

    public ErrorResponseDto(String message, String detailedMessage){
        this.message = message;
        this.detailedMessage = detailedMessage;
        this.errorTime = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public String getDetailedMessage() {
        return detailedMessage;
    }

    public LocalDateTime getErrorTime() {
        return errorTime;
    }
}
