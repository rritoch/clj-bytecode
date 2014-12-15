package com.vnetpublishing.java.asm.bytecode;

import java.io.IOException;
import java.io.InputStream;

public class T_U2 extends Number implements IReader {

	private static final long serialVersionUID = 2893173395384353397L;

	private byte bval[];
	private long lvalue;
	
	public T_U2() {
		lvalue = 0;
		bval = new byte[2];
		bval[0] = 0;
		bval[1] = 0;
	}
	
	private T_U2(byte[] bval_in) {
		bval = bval_in;
		lvalue = 0;
		// BE 
		for (int i = 0; i < bval.length; i++)
		{
		   lvalue = (lvalue << 8) + (bval[i] & 0xff);
		}
	}
	
	public T_U2(T_U1 hi,T_U1 low) {
		
		bval = new byte[2];
		byte h[] = new byte[1];
		byte l[] = new byte[1];
		
		hi.write(h);
		low.write(l);
		
		bval[0] = h[0];
		bval[1] = l[0];
		lvalue = 0;
		for (int i = 0; i < bval.length; i++)
		{
		   lvalue = (lvalue << 8) + (bval[i] & 0xff);
		}
	}
	
	@Override
	public T_U2 set(InputStream is) throws IOException {
		byte[] nbval = new byte[2];
		int r = 0;
		while(r >= 0 && r < 2) {
			int i = is.read(nbval, r, 2 - r);
			if (i < 0) {
				r = i;
			} else {
				r += i;
			}
		}
		
		if (r < 0) {
			throw new IOException("U2 Data incomplete");
		}
		
		// LE
		/*
		for (int i = 0; i < bval.length; i++)
		{
		   lvalue += ((long) bval[i] & 0xffL) << (8 * i);
		}
		*/
		
		// BE 
		for (int i = 0; i < bval.length; i++)
		{
		   lvalue = (lvalue << 8) + (bval[i] & 0xff);
		}
		
		return new T_U2(nbval);
	}

	@Override
	public int intValue() {
		return (int)(lvalue);
	}

	@Override
	public long longValue() {
		return lvalue;
	}

	@Override
	public float floatValue() {
		return lvalue;
	}

	@Override
	public double doubleValue() {
		return (double)(new Long(lvalue));
	}

	public T_U2 inc() {
		if (lvalue == 65535) {
			throw new ArithmeticException("Overflow error");
		}
		
		byte[] nbval = new byte[2];
		
		if (bval[0] == 255) {
			nbval[0] = 0;
			nbval[1] = (byte) (bval[1] + 1);
		} else {
			nbval[0] = (byte)(bval[0] + 1);
			nbval[1] = bval[1];
		}
		
		return new T_U2(nbval);
	}
	
	public T_U2 dec() {
		if (lvalue == 0) {
			throw new ArithmeticException("Underflow error");
		}
		
		byte[] nbval = new byte[2];
		
		if (bval[0] == 0) {
			nbval[0] = (byte)255;
			nbval[1] = (byte) (bval[1] - 1);
		} else {
			nbval[0] = (byte) (bval[0] - 1);
			nbval[1] = bval[1];
		}
		return new T_U2(nbval);
	}
	
	public T_U2 add(long val) {
		if (lvalue + val > 65535) {
			throw new ArithmeticException("Overflow error");
		}
		
		if (lvalue + val < 0) {
			throw new ArithmeticException("Underflow error");
		}
		
		byte[] nbval = new byte[2];
		
		long nlvalue = lvalue + val;
		
		nbval[0] = (byte) (nlvalue & 255);
		nbval[1] = (byte) ((nlvalue >> 8)& 255);
		
		return new T_U2(nbval);
	}
	
	public byte[] getBytesBE() {
		byte[] r = new byte[2];
		r[0] = bval[0];
		r[1] = bval[1];
		return r;
	}
	
	public String toString() {
		return String.format("0x%4s", Integer.toHexString((int) lvalue)).replace(' ', '0');
	}
}
