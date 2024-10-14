package parkinglot.repositories;

import parkinglot.exceptions.GateNotFoundException;
import parkinglot.models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {

    /*
      Always create these layers regardless of having to store the data in DB or not.

      If you're not storing it in db, then try to mimick the table in the repo layer.

      CRUD -> Create, Retrieve, Update, Delete
     */

    private Map<Long, Gate> gates = new HashMap<>();
    private long previousId = 0;

    public Gate finGateByGateId(Long id) throws GateNotFoundException {
        if (gates.containsKey(id)) {
            return gates.get(id);
        }
        throw new GateNotFoundException();
    }

    public void createGate(Gate gate){
        previousId++;
        gates.put(previousId, gate);
    }


}
