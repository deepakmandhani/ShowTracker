
package showtracker.example.com.showtracker.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Self implements Serializable
{

    @SerializedName("href")
    @Expose
    private String href;
    private final static long serialVersionUID = -583139109414948774L;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
