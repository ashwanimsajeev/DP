import java.util.List;
import java.util.ArrayList;

// Observer Interface
interface Observer 
{
    void update(String message);
}

// Subject Interface
interface Subject 
{
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}

// Concrete Subject
class NewsAgency implements Subject 
{
    private List<Observer> observers = new ArrayList<>();
    private String news;
    public void attach(Observer o) 
   {
        observers.add(o);
    }
    public void detach(Observer o)
   {
        observers.remove(o);
    }
    public void setNews(String news) 
    {
        this.news = news;
        notifyObservers();
    }
    public void notifyObservers() 
    {
        for (Observer o : observers) 
        {
            o.update(news);
        }
    }
}

// Concrete Observer
class Subscriber implements Observer 
{
    private String name;

    public Subscriber(String name) 
    {
        this.name = name;
    }

    public void update(String news) 
    {
        System.out.println(name + " received update: " + news);
    }
}

public class ObserverPatternDemo
{
    public static void main(String[] args) 
    {
        NewsAgency agency = new NewsAgency();

        Subscriber s1 = new Subscriber("Alice");
        Subscriber s2 = new Subscriber("Bob");

        agency.attach(s1);
        agency.attach(s2);

        agency.setNews("Observer Pattern Launched!");
        agency.setNews("More Updates Available!");
    }
}





