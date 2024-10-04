package queryparser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryExecutor {

    private String PRIMARY_KEY = "";

    Map<String, List<Object>> tableDataInColFormat = new HashMap<>();

    public void parseColumnsAndApplyFilters(QueryInput queryInputFilters){

        // [20, India], [15, Bangla]
        int size = tableDataInColFormat.get(PRIMARY_KEY).size();

        for(int i=0; i<size; i++){
            for(String key: queryInputFilters.getQuery().keySet()){
                FilterForColum filterValues = queryInputFilters.getQuery().get(key);
                for(FilterType filterType : FilterType.values()){
                    if(filterValues.getFilterTypes().contains(filterType)){
                        // apply filter
                    }
                }
            }
        }

    }
}
