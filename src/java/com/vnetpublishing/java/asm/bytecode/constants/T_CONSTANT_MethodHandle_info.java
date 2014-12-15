package com.vnetpublishing.java.asm.bytecode.constants;

import java.io.IOException;
import java.io.InputStream;
import com.vnetpublishing.java.asm.bytecode.T_CPInfo;
import com.vnetpublishing.java.asm.bytecode.T_U1;
import com.vnetpublishing.java.asm.bytecode.T_U1List;
import com.vnetpublishing.java.asm.bytecode.T_U2;

public class T_CONSTANT_MethodHandle_info extends T_CPInfo {


	private static final long serialVersionUID = -6008888047966902091L;
	/**
	 * 
	 */
	
	
	public static final int REFERENCE_KIND = 1;
	public static final int REFERENCE_INDEX = 2;
	
	private T_U1 reference_kind;
	private T_U2 reference_index;

	
	
	public T_CONSTANT_MethodHandle_info() {
		tag = (new T_U1()).add(7);
		reference_kind = new T_U1();
		reference_index = new T_U2();
	}
	
	private T_CONSTANT_MethodHandle_info(Object v,int t, T_CONSTANT_MethodHandle_info p) {
		tag = (new T_U1()).add(7);
		
		reference_kind = p.getReferenceKind();
		reference_index = p.getReferenceIndex();
		
		switch (t) {
			case REFERENCE_KIND:
				reference_kind = (T_U1)v;
				break;
			case REFERENCE_INDEX:
				reference_index = (T_U2)v;
				break;
		}
		info = new T_U1List();
		info = info.cons(reference_kind);
		info = info.cons(reference_index.getHigh());
		info = info.cons(reference_index.getLow());
	}
	
	public T_U1 getReferenceKind() {
		return reference_kind;
	}
	
	public T_U2 getReferenceIndex() {
		return reference_index;
	}
	
	@Override
	public T_CPInfo set(InputStream is) throws IOException {
		T_CONSTANT_MethodHandle_info r= new T_CONSTANT_MethodHandle_info((new T_U2()).set(is),REFERENCE_KIND,this);
		return new T_CONSTANT_MethodHandle_info((new T_U2()).set(is),REFERENCE_INDEX,r);
	}
}
