package deathValley.repos;

import deathValley.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account,Long> {
}
