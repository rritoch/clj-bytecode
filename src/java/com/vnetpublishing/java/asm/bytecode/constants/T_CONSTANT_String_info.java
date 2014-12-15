package com.vnetpublishing.java.asm.bytecode.constants;

import java.io.IOException;
import java.io.InputStream;
import com.vnetpublishing.java.asm.bytecode.T_CPInfo;
import com.vnetpublishing.java.asm.bytecode.T_U1;
import com.vnetpublishing.java.asm.bytecode.T_U1List;
import com.vnetpublishing.java.asm.bytecode.T_U2;

public class T_CONSTANT_String_info extends T_CPInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6813753062793964122L;
	/**
	 * 
	 */
	
	private T_U2 string_index;

	
	public T_CONSTANT_String_info() {
		tag = (new T_U1()).add(7);
		string_index = new T_U2();
	}
	
	private T_CONSTANT_String_info(T_U2 v) {
		tag = (new T_U1()).add(7);
		string_index = v;
		info = new T_U1List();
		info = info.cons(v.getHigh());
		info = info.cons(v.getLow());
	}
	
	public T_U2 getStringIndex() {
		return string_index;
	}
	
	@Override
	public T_CPInfo set(InputStream is) throws IOException {
		T_U2 v = (new T_U2()).set(is);
		return new T_CONSTANT_String_info(v);
	}
}
