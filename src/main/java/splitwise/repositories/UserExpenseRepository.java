package splitwise.repositories;

import splitwise.models.UserExpense;

import java.util.ArrayList;
import java.util.List;

public class UserExpenseRepository {

    List<UserExpense> userExpenses = new ArrayList<>();

    public UserExpenseRepository(List<UserExpense> userExpenses) {
        this.userExpenses = userExpenses;
    }

    public List<UserExpense> findUserExpenseByExpenseDescription(String description){

        List<UserExpense> userExpenseList = new ArrayList<>();
        for(UserExpense userExpense: userExpenses){

            // if the description is same, we consider it as same expense
            if(userExpense.getExpense().getDescription().equalsIgnoreCase(description)){
                userExpenseList.add(userExpense);
            }
        }
        return userExpenseList;
    }
}
