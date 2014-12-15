package com.vnetpublishing.java.asm.bytecode;

import java.io.IOException;
import java.io.InputStream;

public class T_AttributeInfo implements IReader {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1322676783980325126L;

	public static final int ATTRIBUTE_NAME_INDEX = 1;
	public static final int ATTRIBUTE_LENGTH = 2;
	public static final int INFO = 3;
	
	private T_U2 attribute_name_index;
	//public T_U4 attribute_length;
	private T_U1List info;
	
	
	public T_AttributeInfo() {
		attribute_name_index = null;
		info = new T_U1List();
	}
	
	private T_AttributeInfo(Object item, int t, T_AttributeInfo parent) {
		attribute_name_index = parent.getAttributeNameIndex();
		info = parent.getInfo();
		
		switch(t) {
			case ATTRIBUTE_NAME_INDEX:
				attribute_name_index = (T_U2)item;
				break;
			case INFO:
				info = (T_U1List)item;
				break;
			default:
				throw new UnsupportedOperationException();
		}
	}
	
	public T_U2 getAttributeNameIndex() {
		return attribute_name_index;
	}
	
	public T_U4 getAttributeLength() {
		return (new T_U4()).add(info.size());
	}
	
	public T_U1List getInfo() {
		return info;
	}
	
	@Override
	public T_AttributeInfo set(InputStream is) throws IOException {
		T_AttributeInfo r = new T_AttributeInfo();
		r  = new T_AttributeInfo((new T_U2()).set(is),ATTRIBUTE_NAME_INDEX,r);
		T_U4 attribute_length = (new T_U4()).set(is);
		return new T_AttributeInfo((new T_U1List()).set(is, attribute_length.longValue()),INFO,r);
	}

}
