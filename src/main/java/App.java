import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    Client client;
    ConsoleEventLogger eventLogger;
    FileEventLogger fileEventLogger;
    CacheFileEventLogger cacheFileEventLogger;
    Event event;

    public App(Client client,
               ConsoleEventLogger eventLogger,
               FileEventLogger fileEventLogger,
               CacheFileEventLogger cacheFileEventLogger,
               Event event) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.fileEventLogger = fileEventLogger;
        this.cacheFileEventLogger = cacheFileEventLogger;
        this.event = event;
    }
    public App() {
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("springxml.xml");

        App app = (App) ctx.getBean("app");

        app.logEvents("Some event for user 1");
        app.logEvents("Some event for user 2");
        ctx.close();
    }
    public void logEvents(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
        fileEventLogger.logEvent(event);
        cacheFileEventLogger.logEvent(event);
    }
}
