package com.vnetpublishing.java.asm.bytecode.constants;

import java.io.IOException;
import java.io.InputStream;
import com.vnetpublishing.java.asm.bytecode.T_CPInfo;
import com.vnetpublishing.java.asm.bytecode.T_U1;
import com.vnetpublishing.java.asm.bytecode.T_U1List;
import com.vnetpublishing.java.asm.bytecode.T_U2;

public class T_CONSTANT_Methodref_info extends T_CPInfo {


	private static final long serialVersionUID = -6008888047966902091L;
	/**
	 * 
	 */
	
	
	public static final int CLASS_INDEX = 1;
	public static final int NAME_AND_TYPE_INDEX = 2;
	
	private T_U2 class_index;
	private T_U2 name_and_type_index;

	
	
	public T_CONSTANT_Methodref_info() {
		tag = (new T_U1()).add(7);
		class_index = new T_U2();
		name_and_type_index = new T_U2();
	}
	
	private T_CONSTANT_Methodref_info(T_U2 v,int t, T_CONSTANT_Methodref_info p) {
		tag = (new T_U1()).add(7);
		
		class_index = p.getClassIndex();
		name_and_type_index = p.getNameAndTypeIndex();
		
		switch (t) {
			case CLASS_INDEX:
				class_index = v;
				break;
			case NAME_AND_TYPE_INDEX:
				name_and_type_index = v;
				break;
		}
		info = new T_U1List();
		info = info.cons(class_index.getHigh());
		info = info.cons(class_index.getLow());
		info = info.cons(name_and_type_index.getHigh());
		info = info.cons(name_and_type_index.getLow());
	}
	
	public T_U2 getClassIndex() {
		return class_index;
	}
	
	public T_U2 getNameAndTypeIndex() {
		return name_and_type_index;
	}
	
	@Override
	public T_CPInfo set(InputStream is) throws IOException {
		T_CONSTANT_Methodref_info r= new T_CONSTANT_Methodref_info((new T_U2()).set(is),CLASS_INDEX,this);
		return new T_CONSTANT_Methodref_info((new T_U2()).set(is),NAME_AND_TYPE_INDEX,r);
	}
}
