package queryparser;

import java.util.List;

public class FilterForColum {

    private List<FilterType> filterTypes;
    private List<Object> values;

    public List<FilterType> getFilterTypes() {
        return filterTypes;
    }

    public void setFilterTypes(List<FilterType> filterTypes) {
        this.filterTypes = filterTypes;
    }

    public List<Object> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }
}


enum FilterType {

    LESSTHAN, GREATERTHAN, EQUALTO, LIKE, GROUPBY

}
