package org.lba.spring4.service;

import org.lba.spring4.db.model.UserInfo;
import org.springframework.security.access.annotation.Secured;

public interface UserService {

	@Secured ({"ROLE_ADMIN"})
	UserInfo getDataByUserName(String userName);
}
