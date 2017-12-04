import java.io.IOException;

public interface EventLogger {
  public abstract void logEvent(Event event) throws IOException;

}
