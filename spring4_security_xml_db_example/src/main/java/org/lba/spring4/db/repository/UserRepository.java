package org.lba.spring4.db.repository;

import org.lba.spring4.db.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserInfo, Long>{

	@Query("SELECT u FROM UserInfo u WHERE u.userName=?1 and u.enabled=?2")
	UserInfo getActiveUser(String userName, Integer enabled);
}
