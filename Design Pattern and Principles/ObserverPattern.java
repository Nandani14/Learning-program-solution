// Observer Pattern Example - News agency notifying subscribers

import java.util.*;

// Observer interface
interface Subscriber {
    void update(String news);
}

// Concrete observers
class EmailSubscriber implements Subscriber {
    public void update(String news) {
        System.out.println("Email received: " + news);
    }
}

class MobileSubscriber implements Subscriber {
    public void update(String news) {
        System.out.println("Mobile notification: " + news);
    }
}

// Subject (publisher)
class NewsAgency {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String latestNews;

    public void addSubscriber(Subscriber s) {
        subscribers.add(s);
    }

    public void removeSubscriber(Subscriber s) {
        subscribers.remove(s);
    }

    public void setNews(String news) {
        this.latestNews = news;
        notifyAllSubscribers();
    }

    private void notifyAllSubscribers() {
        for (Subscriber s : subscribers) {
            s.update(latestNews);
        }
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        // Nandani is managing the news agency
        NewsAgency nandaniAgency = new NewsAgency();

        Subscriber emailUser = new EmailSubscriber();
        Subscriber mobileUser = new MobileSubscriber();

        nandaniAgency.addSubscriber(emailUser);
        nandaniAgency.addSubscriber(mobileUser);

        nandaniAgency.setNews("Breaking News: Java is awesome!");
    }
}

