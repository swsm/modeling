package study1.constuction.Flyweight.S3;

import java.util.Hashtable;

public class WebSiteFactory {
    private Hashtable<String , WebSite> flyweights = new Hashtable<String, WebSite>();

    public WebSite getWebSiteCategory(String key) {
        if (!flyweights.contains(key)) {
            this.flyweights.put(key, new ConcreteWebSite(key));
        }
        return this.flyweights.get(key);
    }

    public int getWebSiteCount() {
        return this.flyweights.size();
    }
}
