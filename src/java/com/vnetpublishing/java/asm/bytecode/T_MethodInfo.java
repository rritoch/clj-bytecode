package com.vnetpublishing.java.asm.bytecode;

import java.io.IOException;
import java.io.InputStream;

public class T_MethodInfo implements IReader {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3223764224729780711L;

	public static final int ACCESS_FLAGS = 1;
	public static final int NAME_INDEX = 2;
	public static final int DESCRIPTOR_INDEX = 3;
	public static final int ATTRIBUTES_COUNT = 4;
	public static final int ATTRIBUTES = 5;
	
	public T_U2 access_flags;
	public T_U2 name_index;
	public T_U2 descriptor_index;
	//public T_U2 attributes_count;
	public T_AttributeInfoList attributes;
	
	public T_MethodInfo() {
		access_flags = null;
		name_index = null;
		descriptor_index = null;
		attributes = new T_AttributeInfoList();
	}
	
	private T_MethodInfo(Object i, int t, T_MethodInfo parent) {
		switch(t) {
			case ACCESS_FLAGS:
				access_flags = (T_U2)i;
				break;
			case NAME_INDEX:
				name_index = (T_U2)i;
				break;
			case DESCRIPTOR_INDEX:
				descriptor_index = (T_U2)i;
				break;
			case ATTRIBUTES:
				attributes = (T_AttributeInfoList)i;
				break;
			default:
				throw new UnsupportedOperationException();
		}
	}
	
	public T_U2 getAccessFlags() {
		return access_flags;
	}
	
	public T_U2 getNameIndex() {
		return name_index;
	}
	
	public T_U2 getDescriptorIndex() {
		return descriptor_index;
	}
	
	public T_U2 getAttributesCount() {
		return (new T_U2()).add(attributes.size());
	}
	
	public T_AttributeInfoList getAttributes() {
		return attributes;
	}
	
	@Override
	public T_MethodInfo set(InputStream is) throws IOException {
		
		T_MethodInfo r = new T_MethodInfo();
		
		r = new T_MethodInfo((new T_U2()).set(is),ACCESS_FLAGS,r);
		r = new T_MethodInfo((new T_U2()).set(is),NAME_INDEX,r);
		r = new T_MethodInfo((new T_U2()).set(is),DESCRIPTOR_INDEX,r);
		
		T_U2 attributes_count = (new T_U2()).set(is);
		
		return new T_MethodInfo((new T_AttributeInfoList()).set(is, attributes_count.longValue()),ATTRIBUTES,r);
	}
}
