package com.vnetpublishing.java.asm.bytecode.constants;

import java.io.IOException;
import java.io.InputStream;
import com.vnetpublishing.java.asm.bytecode.T_CPInfo;
import com.vnetpublishing.java.asm.bytecode.T_U1;
import com.vnetpublishing.java.asm.bytecode.T_U1List;
import com.vnetpublishing.java.asm.bytecode.T_U2;

public class T_CONSTANT_InvokeDynamic_info extends T_CPInfo {

	private static final long serialVersionUID = -3801698598725572022L;
	public static final int BOOTSTRAP_METHOD_ATTR_INDEX = 1;
	public static final int NAME_AND_TYPE_INDEX = 2;
	
	private T_U2 bootstrap_method_attr_index;
	private T_U2 name_and_type_index;

	
	
	public T_CONSTANT_InvokeDynamic_info() {
		tag = (new T_U1()).add(7);
		bootstrap_method_attr_index = new T_U2();
		name_and_type_index = new T_U2();
	}
	
	private T_CONSTANT_InvokeDynamic_info(T_U2 v,int t, T_CONSTANT_InvokeDynamic_info p) {
		tag = (new T_U1()).add(7);
		
		bootstrap_method_attr_index = p.getBootstrapMethodAttrIndex();
		name_and_type_index = p.getNameAndTypeIndex();
		
		switch (t) {
			case BOOTSTRAP_METHOD_ATTR_INDEX:
				bootstrap_method_attr_index = v;
				break;
			case NAME_AND_TYPE_INDEX:
				name_and_type_index = v;
				break;
		}
		info = new T_U1List();
		info = info.cons(bootstrap_method_attr_index.getHigh());
		info = info.cons(bootstrap_method_attr_index.getLow());
		info = info.cons(name_and_type_index.getHigh());
		info = info.cons(name_and_type_index.getLow());
	}
	
	public T_U2 getBootstrapMethodAttrIndex() {
		return bootstrap_method_attr_index;
	}
	
	public T_U2 getNameAndTypeIndex() {
		return name_and_type_index;
	}
	
	@Override
	public T_CPInfo set(InputStream is) throws IOException {
		T_CONSTANT_InvokeDynamic_info r= new T_CONSTANT_InvokeDynamic_info((new T_U2()).set(is),BOOTSTRAP_METHOD_ATTR_INDEX,this);
		return new T_CONSTANT_InvokeDynamic_info((new T_U2()).set(is),NAME_AND_TYPE_INDEX,r);
	}
}
