package com.vnetpublishing.java.asm.bytecode.constants;

import java.io.IOException;
import java.io.InputStream;
import com.vnetpublishing.java.asm.bytecode.T_CPInfo;
import com.vnetpublishing.java.asm.bytecode.T_U1;
import com.vnetpublishing.java.asm.bytecode.T_U1List;
import com.vnetpublishing.java.asm.bytecode.T_U2;
import com.vnetpublishing.java.asm.bytecode.T_U4;

public class T_CONSTANT_Long_info extends T_CPInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6813753062793964122L;
	/**
	 * 
	 */
	
	private T_U4 high_bytes;
	private T_U4 low_bytes;

	
	public T_CONSTANT_Long_info() {
		tag = (new T_U1()).add(5);
		high_bytes = new T_U4();
		low_bytes = new T_U4();
	}
	
	private T_CONSTANT_Long_info(T_U4 vh, T_U4 vl) {
		tag = (new T_U1()).add(5);
		high_bytes = vh;
		low_bytes = vl;
		
		info = new T_U1List();
		
		T_U2 h = vh.getHigh();
		T_U2 l = vh.getLow();
		
		info = info.cons(h.getHigh());
		info = info.cons(h.getLow());
		info = info.cons(l.getHigh());
		info = info.cons(l.getLow());
		
		h = vl.getHigh();
		l = vl.getLow();

		info = info.cons(h.getHigh());
		info = info.cons(h.getLow());
		info = info.cons(l.getHigh());
		info = info.cons(l.getLow());
	}
	
	public T_U4 getHighBytes() {
		return high_bytes;
	}
	
	public T_U4 getLowBytes() {
		return low_bytes;
	}
	
	@Override
	public T_CPInfo set(InputStream is) throws IOException {
		T_U4 vh = (new T_U4()).set(is);
		T_U4 vl = (new T_U4()).set(is);
		return new T_CONSTANT_Long_info(vh,vl);
	}
	
	public String toString() {
		return high_bytes.toString() + " "+ low_bytes.toString();
	}
}
