package gx.service;

import gx.domain.Account;

import java.util.List;

public interface DemoService {

    // 查询所有账户
    public List<Account> findAll();

    // 保存帐户信息
    public void saveAccount(Account account);
}
