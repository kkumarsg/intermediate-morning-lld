package splitwise.controllers;

import splitwise.dtos.Transaction;
import splitwise.models.*;
import splitwise.repositories.GroupRepository;
import splitwise.repositories.UserExpenseRepository;
import splitwise.services.UserService;
import splitwise.strategies.HeapSettleUpStrategy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {


    public static void main(String[] args) {

        HeapSettleUpStrategy settleUpStrategy = new HeapSettleUpStrategy();

        Group group = new Group("GOA GUYS");

        User amir = new User("Amir", "1234", "1234");
        User shreyasi = new User("Shreyasi", "1234", "1234");
        User tanay = new User("Tanay", "1234", "1234");
        User shubham = new User("Shubham", "1234", "1234");

        group.setUsers(Arrays.asList(amir, shreyasi, tanay, shubham));

        Expense dinnerExpense = new Expense("Dinner", 5000, ExpenseType.ORIGINAL);

        group.setExpenses(Arrays.asList(dinnerExpense));

        // A : 500, B:500, C:500
        // D : -1500

        UserExpense uE1 = new UserExpense(amir, dinnerExpense, 500, UserExpenseType.PAID_BY);
        UserExpense uE2 = new UserExpense(shreyasi, dinnerExpense, 500, UserExpenseType.PAID_BY);
        UserExpense uE5 = new UserExpense(tanay, dinnerExpense, 500, UserExpenseType.PAID_BY);

        UserExpense uE3 = new UserExpense(amir, dinnerExpense, 0, UserExpenseType.HAD_TO_PAY);
        UserExpense uE4 = new UserExpense(shreyasi, dinnerExpense, 0, UserExpenseType.HAD_TO_PAY);
        UserExpense uE6 = new UserExpense(shubham, dinnerExpense, 1500, UserExpenseType.HAD_TO_PAY);

        Map<String, Group> groupMap = new HashMap<>();
        groupMap.put("GOA GUYS", group);

        GroupRepository groupRepository = new GroupRepository(groupMap);

        UserExpenseRepository userExpenseRepository = new UserExpenseRepository(Arrays.asList(uE1, uE2, uE3, uE4, uE5, uE6));

        UserService userService = new UserService(groupRepository, userExpenseRepository, settleUpStrategy);

        UserController userController = new UserController(userService);
        List<Transaction> transactions = userController.settleUser("tanay", "GOA GUYS");

        for (Transaction transaction: transactions){
            System.out.println(transaction);
        }


    }
}
