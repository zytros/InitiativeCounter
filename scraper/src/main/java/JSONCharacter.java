import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class JSONCharacter {
    Map<String, Object> details = new LinkedHashMap<>();

    @JsonAnySetter
    void setDetails(String key, Object value){
        details.put(key, value);
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(Map<String, Object> details) {
        this.details = details;
    }
}
