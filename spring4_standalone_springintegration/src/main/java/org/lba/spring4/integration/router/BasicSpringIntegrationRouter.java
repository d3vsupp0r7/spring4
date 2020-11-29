package org.lba.spring4.integration.router;

import org.lba.spring4.integration.payload.EmployeeComplexPayload;
import org.springframework.integration.annotation.Router;

public class BasicSpringIntegrationRouter {

	@Router
	public String route(EmployeeComplexPayload item) {
		String channelId = item.getCustomMetadata().getChannelName();
		return channelId;
	}
}
