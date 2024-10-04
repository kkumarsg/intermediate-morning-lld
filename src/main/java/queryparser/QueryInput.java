package queryparser;

import java.util.Map;

public class QueryInput {

    private Map<String, FilterForColum> query;

    public Map<String, FilterForColum> getQuery() {
        return query;
    }

    public void setQuery(Map<String, FilterForColum> query) {
        this.query = query;
    }
}
