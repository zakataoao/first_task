import java.time.LocalDateTime;

public class Alarm {
    private final LocalDateTime time;

    public Alarm(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
