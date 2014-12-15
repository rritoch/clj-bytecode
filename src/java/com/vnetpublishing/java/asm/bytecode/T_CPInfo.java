package com.vnetpublishing.java.asm.bytecode;

import java.io.IOException;
import java.io.InputStream;

import com.vnetpublishing.java.asm.bytecode.constants.T_CONSTANT_Double_info;
import com.vnetpublishing.java.asm.bytecode.constants.T_CONSTANT_Float_info;
import com.vnetpublishing.java.asm.bytecode.constants.T_CONSTANT_Integer_info;
import com.vnetpublishing.java.asm.bytecode.constants.T_CONSTANT_Long_info;
import com.vnetpublishing.java.asm.bytecode.constants.T_CONSTANT_Utf8_info;

public class T_CPInfo implements IReader {

	/**
	 * 
	 */
	private static final long serialVersionUID = 727981655406458420L;

	public static final int TAG = 1;
	public static final int INFO = 2;
	
	static final int CONSTANT_Utf8 = 1;
	// 2
	static final int CONSTANT_Integer = 3;
	static final int CONSTANT_Float = 4;
	static final int CONSTANT_Long = 5;
	static final int CONSTANT_Double = 6;
	static final int CONSTANT_Class = 7;
	static final int CONSTANT_String = 8;
	static final int CONSTANT_Fieldref = 9;
	static final int CONSTANT_Methodref = 10;
	static final int CONSTANT_InterfaceMethodref = 11;
	static final int CONSTANT_NameAndType = 12;
	// 13..14
	static final int CONSTANT_MethodHandle = 15;
	static final int CONSTANT_MethodType = 16;
	// 17
	static final int CONSTANT_InvokeDynamic = 18;
	
	protected T_U1 tag;
	protected T_U1List info;
	
	
	public T_CPInfo() {
		tag = null;
		info = new T_U1List();
	}
	
	public T_CPInfo(Object item, int t, T_CPInfo parent) {
		tag = parent.getTag();
		info = parent.getInfo();
		switch(t) {
			case TAG:
				tag = (T_U1)item;
				break;
			case INFO:
				info = (T_U1List)item;
				break;
			default:
				throw new UnsupportedOperationException();
		}
	}
	
    public T_U1 getTag() {
    	return tag;
    }
    
    public T_U1List getInfo() {
    	return info;
    }
	
	
	@Override
	public T_CPInfo set(InputStream is) throws IOException {
		int i = 0;
		
		// TODO Auto-generated method stub
		T_U1 ntag = (new T_U1()).set(is);
		T_U1List ninfo = new T_U1List();
		int vtag = ntag.intValue();
		T_CPInfo r = null;
		
		switch(vtag) {
			case CONSTANT_Utf8:
				r = (new T_CONSTANT_Utf8_info()).set(is);
			case CONSTANT_Integer:
				r = (new T_CONSTANT_Integer_info()).set(is);
			case CONSTANT_Float:
				r = (new T_CONSTANT_Float_info()).set(is);
			case CONSTANT_Long:
				r = (new T_CONSTANT_Long_info()).set(is);
			case CONSTANT_Double:
				r = (new T_CONSTANT_Double_info()).set(is);
			case CONSTANT_Class:
				for (i = 0; i < 2; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				break;
			case CONSTANT_String:
				for (i = 0; i < 2; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				break;
			case CONSTANT_Fieldref:
				for (i = 0; i < 4; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				break;
			case CONSTANT_Methodref:
				for (i = 0; i < 4; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				break;
			case CONSTANT_InterfaceMethodref:
				for (i = 0; i < 4; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				break;
			case CONSTANT_NameAndType:
				for (i = 0; i < 4; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				break;
			case CONSTANT_MethodHandle:
				for (i = 0; i < 3; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				break;
			case CONSTANT_MethodType:
				for (i = 0; i < 2; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				break;
			case CONSTANT_InvokeDynamic:
				for (i = 0; i < 4; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				break;
			default:
				throw new IOException("Unknown CPInfo type (" + vtag + ")");
		}
		
		if (r == null) {
			r = new T_CPInfo();
			r = new T_CPInfo(ntag,TAG,r);
			r = new T_CPInfo(ninfo,INFO,r);
		}

		return r;
		
	}

}
