import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    Client client;
    ConsoleEventLogger eventLogger;

    public App(Client client, ConsoleEventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }
    public App() {

    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("springxml.xml");

        App app = (App) ctx.getBean("app");

        app.logEvents("Some event for user 1");
        app.logEvents("Some event for user 2");
    }
    public void logEvents(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(msg);
    }
}
