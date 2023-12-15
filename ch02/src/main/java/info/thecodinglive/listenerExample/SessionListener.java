package info.thecodinglive.listenerExample;


import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("session removed");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sessionEvent) {
        System.out.println("세션 ID값" + sessionEvent.getName());
        System.out.println("세션ID의 지정된 값" + sessionEvent.getSession()
        .getAttribute("user"));
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sessionEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        System.out.println("session created " +
                sessionEvent.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        System.out.println("session destroyed"
                + sessionEvent.getSession().getId());
    }
}
