
package showtracker.example.com.showtracker.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links implements Serializable
{

    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("previousepisode")
    @Expose
    private Previousepisode previousepisode;
    private final static long serialVersionUID = 2484633589288488431L;

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public Previousepisode getPreviousepisode() {
        return previousepisode;
    }

    public void setPreviousepisode(Previousepisode previousepisode) {
        this.previousepisode = previousepisode;
    }

}
