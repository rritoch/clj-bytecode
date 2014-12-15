package com.vnetpublishing.java.asm.bytecode.constants;

import java.io.IOException;
import java.io.InputStream;
import com.vnetpublishing.java.asm.bytecode.T_CPInfo;
import com.vnetpublishing.java.asm.bytecode.T_U1;
import com.vnetpublishing.java.asm.bytecode.T_U1List;
import com.vnetpublishing.java.asm.bytecode.T_U2;
import com.vnetpublishing.java.asm.bytecode.T_U4;

public class T_CONSTANT_Float_info extends T_CPInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8287502344990358855L;
	/**
	 * 
	 */
	
	private T_U4 bytes;

	
	public T_CONSTANT_Float_info() {
		tag = (new T_U1()).add(4);
		bytes = new T_U4();
	}
	
	private T_CONSTANT_Float_info(T_U4 v) {
		tag = (new T_U1()).add(4);
		bytes = v;
		
		info = new T_U1List();
		
		T_U2 h = v.getHigh();
		T_U2 l = v.getLow();
		
		info = info.cons(h.getHigh());
		info = info.cons(h.getLow());
		info = info.cons(l.getHigh());
		info = info.cons(l.getLow());
	}
	
	public T_U4 getBytes() {
		return bytes;
	}
	
	@Override
	public T_CPInfo set(InputStream is) throws IOException {
		T_U4 v = (new T_U4()).set(is);
		return new T_CONSTANT_Float_info(v);
	}
	
	public String toString() {
		return bytes.toString();
	}
}
