package DesignPatterns;

interface Notification {
    public void notifyUser();
}

class SMSNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("SMS Notification");
    }
}

class EmailNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Email Notification");
    }
}

class PushNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Push Notification");
    }
}
// Creational Design Pattern
class NotificationFactory {
    public Notification createNotification(String channel) {
        if(channel.equalsIgnoreCase("SMS"))
            return new SMSNotification();
        else if(channel.equalsIgnoreCase("EMAIL"))
            return new EmailNotification();
        else
            return new PushNotification();

    }
}

public class FactoryDesignPattern {
    public static void main(String[] args) {
    NotificationFactory factory = new NotificationFactory();
    factory.createNotification("EMAIl").notifyUser();
    }
}

