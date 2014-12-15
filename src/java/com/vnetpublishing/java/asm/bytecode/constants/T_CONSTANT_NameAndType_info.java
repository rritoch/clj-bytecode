package com.vnetpublishing.java.asm.bytecode.constants;

import java.io.IOException;
import java.io.InputStream;
import com.vnetpublishing.java.asm.bytecode.T_CPInfo;
import com.vnetpublishing.java.asm.bytecode.T_U1;
import com.vnetpublishing.java.asm.bytecode.T_U1List;
import com.vnetpublishing.java.asm.bytecode.T_U2;

public class T_CONSTANT_NameAndType_info extends T_CPInfo {


	private static final long serialVersionUID = -6008888047966902091L;
	/**
	 * 
	 */
	
	
	public static final int CLASS_INDEX = 1;
	public static final int DESCRIPTOR_INDEX = 2;
	
	private T_U2 class_index;
	private T_U2 descriptor_index;

	
	
	public T_CONSTANT_NameAndType_info() {
		tag = (new T_U1()).add(7);
		class_index = new T_U2();
		descriptor_index = new T_U2();
	}
	
	private T_CONSTANT_NameAndType_info(T_U2 v,int t, T_CONSTANT_NameAndType_info p) {
		tag = (new T_U1()).add(7);
		
		class_index = p.getClassIndex();
		descriptor_index = p.getDescriptorIndex();
		
		switch (t) {
			case CLASS_INDEX:
				class_index = v;
				break;
			case DESCRIPTOR_INDEX:
				descriptor_index = v;
				break;
		}
		info = new T_U1List();
		info = info.cons(class_index.getHigh());
		info = info.cons(class_index.getLow());
		info = info.cons(descriptor_index.getHigh());
		info = info.cons(descriptor_index.getLow());
	}
	
	public T_U2 getClassIndex() {
		return class_index;
	}
	
	public T_U2 getDescriptorIndex() {
		return descriptor_index;
	}
	
	@Override
	public T_CPInfo set(InputStream is) throws IOException {
		T_CONSTANT_NameAndType_info r= new T_CONSTANT_NameAndType_info((new T_U2()).set(is),CLASS_INDEX,this);
		return new T_CONSTANT_NameAndType_info((new T_U2()).set(is),DESCRIPTOR_INDEX,r);
	}
}
