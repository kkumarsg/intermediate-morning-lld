package splitwise.strategies;

import splitwise.dtos.Transaction;
import splitwise.models.User;

import java.util.List;
import java.util.Map;

public interface SettleUpStrategy {

    List<Transaction> settleUser(Map<User, Integer> map);
}
