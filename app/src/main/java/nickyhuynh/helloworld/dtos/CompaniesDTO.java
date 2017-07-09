package nickyhuynh.helloworld.dtos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bummy on 7/9/17.
 */

public class CompaniesDTO {
    @SerializedName("names")
    public ArrayList<String> names;

    @SerializedName("companies")
    public HashMap<String, ArrayList<Ad>> companies;

    public class Ad {
        @SerializedName("creator")
        public String creator;

        @SerializedName("date")
        public long date;

        @SerializedName("likes")
        public int likes;

        @SerializedName("dislikes")
        public int dislikes;

        @SerializedName("thumbnail")
        public String thumbnail;

        @SerializedName("url")
        public String url;
    }
}
