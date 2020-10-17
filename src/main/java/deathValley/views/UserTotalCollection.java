package deathValley.views;

import deathValley.domain.Account;
import deathValley.domain.User;

import java.util.ArrayList;

public class UserTotalCollection {
    private ArrayList<UserTotal> users = new ArrayList<>();

    public UserTotalCollection() {
    }

    public ArrayList<UserTotal> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserTotal> users) {
        this.users = users;
    }

    public void addUser(UserTotal user){
        int index = users.indexOf(user);
        if(index != -1){
            users.get(index).updateAccount(user.getAccount());
        }
        else{
            users.add(user);
        }
    }

    public void completeUserCollection(Iterable<User> users, Iterable<Account> accounts){
        for(User user: users){
            for(Account account: accounts){
                if(user.getUserId() == account.getUserId()){
                    this.addUser(new UserTotal(user,account));
                }

            }
        }
    }
    public ArrayList<UserTotal> getRichestUsers(){
        int maxAccount = 0;
        ArrayList<UserTotal> richestUsers = new ArrayList<>();
        for(UserTotal user: users){
            if(user.getAccount() > maxAccount){
                maxAccount = user.getAccount();
            }
        }
        for(UserTotal user: users){
            if(user.getAccount() == maxAccount){
                richestUsers.add(user);
            }
        }

        return richestUsers;
    }

}
