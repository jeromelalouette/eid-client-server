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

package be.bosa.eid.server.impl.tlv;

/**
 * Interface for a data convertor component.
 *
 * @param <T> the type to which to convert to.
 * @author Frank Cornelis
 */
public interface DataConvertor<T> {

	/**
	 * Convert the given byte array to the data convertor data type.
	 *
	 * @param value the byte array to convert.
	 * @return an object of the data convertor data type type.
	 * @throws DataConvertorException in case the conversion failed.
	 */
	T convert(byte[] value) throws DataConvertorException;
}