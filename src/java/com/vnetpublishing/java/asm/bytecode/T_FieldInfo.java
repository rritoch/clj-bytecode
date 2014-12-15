package com.vnetpublishing.java.asm.bytecode;

import java.io.IOException;
import java.io.InputStream;

public class T_FieldInfo implements IReader {

	public final int ACCESS_FLAGS = 1;
	public final int NAME_INDEX = 2;
	public final int DESCRIPTOR_INDEX = 3;
	public final int ATTRIBUTES_COUNT = 4;
	public final int ATTRIBUTES = 5; 
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6304183122755309345L;

	
	
	private T_U2 access_flags;
	private T_U2 name_index;
	private T_U2 descriptor_index;
	//private T_U2 attributes_count;
	private T_AttributeInfoList attributes;
	
	
	public T_FieldInfo() {
		access_flags = null;
		name_index = null;
		descriptor_index = null;
		attributes = new T_AttributeInfoList();
	}
	
	private T_FieldInfo(Object item, int t, T_FieldInfo parent) {
		
		access_flags = parent.getAccessFlags();
		name_index = parent.getNameIndex();
		descriptor_index = parent.getDescriptorIndex();
		attributes = parent.getAttributes();
		
		switch(t) {
			case ACCESS_FLAGS:
				access_flags = (T_U2)item;
				break;
			case NAME_INDEX:
				name_index = (T_U2)item;
				break;
			case DESCRIPTOR_INDEX:
				descriptor_index = (T_U2)item;
				break;
			case ATTRIBUTES:
				attributes = (T_AttributeInfoList)item;
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
	public T_FieldInfo set(InputStream is) throws IOException {
		T_FieldInfo r = new T_FieldInfo();
		r = new T_FieldInfo((new T_U2()).set(is),ACCESS_FLAGS,r);
		r = new T_FieldInfo((new T_U2()).set(is),NAME_INDEX,r);
		r = new T_FieldInfo((new T_U2()).set(is),DESCRIPTOR_INDEX,r);
		T_U2 attributes_count = (new T_U2()).set(is);
		
		return new T_FieldInfo((new T_AttributeInfoList()).set(is,attributes_count.longValue()),ATTRIBUTES,r); 
	}
}
