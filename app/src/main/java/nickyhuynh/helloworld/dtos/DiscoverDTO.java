package nickyhuynh.helloworld.dtos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by bummy on 7/9/17.
 */

public class DiscoverDTO {
    @SerializedName("discover")
    public ArrayList<CompaniesDTO.Ad> discoveries;
}
