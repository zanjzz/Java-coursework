package week_12;

public class NotificationService {

    public static void main(String[] args) {

        // Choose notification channel 
        Notification channel = new Email();

        // Inject channel into processor 
        NotificationProcessor service = new NotificationProcessor(channel);

        service.sendOrderConfirmation();
        service.sendPasswordReset();
    }
}

// Handles notification logic without caring about delivery method
class NotificationProcessor {
    private Notification channel;

    NotificationProcessor(Notification channel) {
        this.channel = channel;
    }

    void sendOrderConfirmation() {
        channel.sendNotification("Your order has been confirmed!");
    }

    void sendPasswordReset() {
        channel.sendNotification("Click here to reset your password.");
    }
}

// Base contract for all notification types
interface Notification {
    void sendNotification(String message);
}

// Sends notification via email
class Email implements Notification {
    public void sendNotification(String message) {
        System.out.println("Email: " + message);
    }
}

// Sends notification via SMS
class SMS implements Notification {
    public void sendNotification(String message) {
        System.out.println("SMS: " + message);
    }
}

// Sends push notification
class Push implements Notification {
    public void sendNotification(String message) {
        System.out.println("Push: " + message);
    }
}