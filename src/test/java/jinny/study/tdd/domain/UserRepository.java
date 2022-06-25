package jinny.study.tdd.domain;

import jinny.study.tdd.doubletest.MemoryUserRepository;

public interface UserRepository {

    void save (User jinny);

    User findById (String id);
}
