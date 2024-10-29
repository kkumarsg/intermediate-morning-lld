package splitwise.repositories;

import constructorChaining.A;
import splitwise.models.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupRepository {

    Map<String, Group> groups = new HashMap<>();

    public GroupRepository(Map<String, Group> groups) {
        this.groups = groups;
    }

    public Group findGroupByName(String groupName){
        return groups.get(groupName);
    }

    public void saveGroup(String groupName, Group group){
        groups.put(groupName, group);
    }
}
