package com.vnetpublishing.java.asm.bytecode.constants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
//import java.nio.charset.Charset;

import com.vnetpublishing.java.asm.bytecode.T_CPInfo;
import com.vnetpublishing.java.asm.bytecode.T_U1;
import com.vnetpublishing.java.asm.bytecode.T_U1List;
import com.vnetpublishing.java.asm.bytecode.T_U2;

public class T_CONSTANT_Utf8_info extends T_CPInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6217278064656333454L;
	private T_U1List bytes;
	private String strval;
	
	public T_CONSTANT_Utf8_info() {
		tag = (new T_U1()).add(1);
		bytes = new T_U1List();
		strval = "";
	}
	
	private T_CONSTANT_Utf8_info(T_U1 v,T_CONSTANT_Utf8_info p) {
		tag = (new T_U1()).add(1);
		T_U1List b = p.getBytes();
		
		T_U2 length = new T_U2();
		

		length = length.add(b.size() + 1);
		bytes = b.cons(v);
		
		
		info = new T_U1List();
		info = info.cons(length.getHigh());
		info = info.cons(length.getLow());
		
		Iterator<T_U1> i = bytes.iterator();
		
		while(i.hasNext()) {
			info = info.cons(i.next());
		}
		
		int sz = bytes.size();
		byte[] bs = new byte[sz];
		for (int idx=0;idx<sz;idx++) {
			bytes.get(idx).write(bs,idx);
		}
		strval = new String(bs);
	}
	
	public T_U2 getLength() {
		return (new T_U2()).add(bytes.size());
	}
	
	public T_U1List getBytes() {
		return bytes;
	}
	
	public T_CONSTANT_Utf8_info cons(T_U1 c) {
		return new T_CONSTANT_Utf8_info(c,this);
	}
	
	@Override
	public T_CPInfo set(InputStream is) throws IOException {
		T_CONSTANT_Utf8_info r = new T_CONSTANT_Utf8_info();
		
		T_U2 length = (new T_U2()).set(is);
		long len = length.longValue();
		for(long i =0; i<len; i++) {
			r = r.cons((new T_U1()).set(is));
		}
		
		return r;
	}
	
	public String toString() {
		return strval;
	}
	
}
