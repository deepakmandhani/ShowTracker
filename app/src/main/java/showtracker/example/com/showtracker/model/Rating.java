
package showtracker.example.com.showtracker.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating implements Serializable
{

    @SerializedName("average")
    @Expose
    private Double average;
    private final static long serialVersionUID = -4451995092829068345L;

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

}
