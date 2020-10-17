package deathValley.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
    @Id
    @GeneratedValue
    @Column(name="accountid")
    private Integer accountId;
    @Column(name="account")
    private Integer account;
    @Column(name="userid")
    private Integer userId;

    public Account() {
    }

    public Account(Integer account, Integer userId) {
        this.account = account;
        this.userId = userId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "accountId=" + accountId +
                ", account=" + account +
                ", userId=" + userId +
                '}';
    }
}
