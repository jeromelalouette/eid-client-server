/*
 * eID Client - Server Project.
 * Copyright (C) 2018 - 2018 BOSA.
 *
 * This is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License version 3.0 as published by
 * the Free Software Foundation.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this software; if not, see https://www.gnu.org/licenses/.
 */

package be.bosa.eid.client_server.shared.message;

import be.bosa.eid.client_server.shared.annotation.HttpBody;
import be.bosa.eid.client_server.shared.annotation.HttpHeader;
import be.bosa.eid.client_server.shared.annotation.MessageDiscriminator;
import be.bosa.eid.client_server.shared.annotation.NotNull;
import be.bosa.eid.client_server.shared.annotation.StateTransition;
import be.bosa.eid.client_server.shared.protocol.ProtocolState;

/**
 * Request message for authentication signature creation. Can be used for the
 * creation of for example WS-Security signatures.
 *
 * @author Frank Cornelis
 */
@StateTransition(ProtocolState.AUTH_SIGN)
public class AuthSignRequestMessage extends AbstractProtocolMessage {

	@HttpHeader(TYPE_HTTP_HEADER)
	@MessageDiscriminator
	public static final String TYPE = AuthSignRequestMessage.class.getSimpleName();

	@HttpHeader(HTTP_HEADER_PREFIX + "DigestAlgo")
	@NotNull
	public String digestAlgo;

	@HttpHeader(HTTP_HEADER_PREFIX + "Message")
	@NotNull
	public String message;

	@HttpHeader(HTTP_HEADER_PREFIX + "Logoff")
	public boolean logoff;

	@HttpBody
	@NotNull
	public byte[] computedDigestValue;

	public AuthSignRequestMessage() {
	}

	public AuthSignRequestMessage(byte[] computedDigestValue, String digestAlgo, String message, boolean logoff) {
		this.computedDigestValue = computedDigestValue;
		this.digestAlgo = digestAlgo;
		this.message = message;
		this.logoff = logoff;
	}
}
