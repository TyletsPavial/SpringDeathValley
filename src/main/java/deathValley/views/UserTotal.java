package deathValley.views;

import deathValley.domain.Account;
import deathValley.domain.User;

import java.util.List;
import java.util.Objects;

public class UserTotal {
    private Integer userId;
    private String name;
    private String sureName;
    private Integer account;


    public UserTotal(User user, Account account) {
        userId = user.getUserId();
        name = user.getName();
        sureName = user.getSureName();
        this.account = account.getAccount();

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }
    public void updateAccount(Integer account) {
        this.account += account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTotal userTotal = (UserTotal) o;
        return userId.equals(userTotal.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "userId=" + userId +
                ", name=" + name +
                ", sureName=" + sureName +
                ", account=" + account;
    }
}
