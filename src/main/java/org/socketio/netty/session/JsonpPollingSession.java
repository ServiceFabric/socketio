/**
 * Copyright 2012 Ronen Hamias, Anton Kharenko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.socketio.netty.session;

import org.jboss.netty.channel.Channel;
import org.socketio.netty.TransportType;
import org.socketio.netty.packets.IPacket;

public class JsonpPollingSession extends AbstractPollingSession {
	
	private final String jsonpIndexParam;
	
	public JsonpPollingSession(
			Channel channel, 
			String sessionId,
			String origin, 
			ISessionDisconnectHandler disconnectHandler,
			TransportType upgradedFromTransportType, 
			int localPort,
			String jsonpIndexParam) {
		super(channel, sessionId, origin, disconnectHandler, upgradedFromTransportType,	localPort);
		this.jsonpIndexParam =jsonpIndexParam;  
	}

	@Override
	public TransportType getTransportType() {
		return TransportType.JSONP_POLLING;
	}

	@Override
	protected void fillPacketHeaders(IPacket packet) {
		super.fillPacketHeaders(packet);
		packet.setJsonpIndexParam(jsonpIndexParam);
	}

}
