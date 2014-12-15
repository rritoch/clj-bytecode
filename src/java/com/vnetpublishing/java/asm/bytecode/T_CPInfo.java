package com.vnetpublishing.java.asm.bytecode;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

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
	
	private T_U1 tag;
	private T_U1List info;
	
	
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
		T_U1 tv;
		
		// TODO Auto-generated method stub
		T_U1 ntag = (new T_U1()).set(is);
		T_U1List ninfo = new T_U1List();
		int vtag = ntag.intValue();
		
		switch(vtag) {
			case CONSTANT_Utf8:
				
				T_U1 tv_h = (new T_U1()).set(is);
				ninfo = ninfo.cons(tv_h);
				
				T_U1 tv_l = (new T_U1()).set(is);
				ninfo = ninfo.cons(tv_l);
					
				int len = (new T_U2(tv_h,tv_l)).intValue();
				
				byte b[] = new byte[len];
				for (i = 0; i < len; i++) {
					tv = (new T_U1()).set(is);
					b[i] = tv.byteValue();
					ninfo = ninfo.cons(tv);
				}
				System.out.println("Read Utf8 ("+ (new String(b,Charset.forName("UTF-8")))+ ")");
				break;
			case CONSTANT_Integer:
				for (i = 0; i < 4; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				System.out.println("Read Integer");
				break;
			case CONSTANT_Float:
				for (i = 0; i < 4; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				System.out.println("Read Float");
				break;
			case CONSTANT_Long:
				for (i = 0; i < 8; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				System.out.println("Read Long");
				break;
			case CONSTANT_Double:
				for (i = 0; i < 8; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				System.out.println("Read Double");
				break;
			case CONSTANT_Class:
				for (i = 0; i < 2; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				System.out.println("Read Class");
				break;
			case CONSTANT_String:
				for (i = 0; i < 2; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				System.out.println("Read String");
				break;
			case CONSTANT_Fieldref:
				for (i = 0; i < 4; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				System.out.println("Read FieldRef");
				break;
			case CONSTANT_Methodref:
				for (i = 0; i < 4; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				System.out.println("Read MethodRef");
				break;
			case CONSTANT_InterfaceMethodref:
				for (i = 0; i < 4; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				System.out.println("Read InterfaceMethodRef");
				break;
			case CONSTANT_NameAndType:
				for (i = 0; i < 4; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				System.out.println("Read NameAndType");
				break;
			case CONSTANT_MethodHandle:
				for (i = 0; i < 3; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				System.out.println("Read MethodHandle");
				break;
			case CONSTANT_MethodType:
				for (i = 0; i < 2; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				System.out.println("Read MethodType");
				break;
			case CONSTANT_InvokeDynamic:
				for (i = 0; i < 4; i++) {
					ninfo = ninfo.cons((new T_U1()).set(is));
				}
				System.out.println("Read InvokeDynamic");
				break;
			default:
				System.out.println("FAIL!");
				throw new IOException("Unknown CPInfo type (" + vtag + ")");
		}
		
		T_CPInfo r = new T_CPInfo();
		
		r = new T_CPInfo(ntag,TAG,r);
		r = new T_CPInfo(ninfo,INFO,r);
		return r;
		
	}

}
