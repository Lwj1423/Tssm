package gx.dao;

import gx.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoDao {

    @Select("select * from account")
    public List<Account> findAll();

    @Insert("insert into account(name,money) value(#{name},#{money})")
    public void saveAccount(Account account);

}
