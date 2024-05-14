package seleniumdesignpattern.factory;

public abstract class GooglePage {

    public abstract void launchSite();
    public abstract void search(String keyword);
    public abstract String getResultCount();

}
