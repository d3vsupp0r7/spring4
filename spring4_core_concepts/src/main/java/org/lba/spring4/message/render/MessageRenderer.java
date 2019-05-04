package org.lba.spring4.message.render;

import org.lba.spring4.message.provider.MessageProvider;

public interface MessageRenderer {
	void render();
	void setMessageProvider(MessageProvider provider);
	MessageProvider getMessageProvider();
}