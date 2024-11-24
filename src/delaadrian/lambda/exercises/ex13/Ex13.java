package delaadrian.lambda.exercises.ex13;

import java.util.List;
import java.util.Optional;

public class Ex13 {
    public static void main(String[] args) {
        //13. Gestiunea tranzactiilor 2

    }

    public Integer getTransactionSum (List<Account> accounts){
        Optional<Integer> sumOptional =  accounts.stream()
                .filter(account -> account.getBalance()>0)
                .flatMap(account -> account.getTransactions().stream())
                .filter(transaction -> transaction.getState().equals(State.CANCELED))
                .map(transaction -> transaction.getAmount())
                .reduce((sum, transaction)->sum+transaction);
            return sumOptional.orElse(0);
    }
}
