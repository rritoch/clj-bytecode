package com.vnetpublishing.java.asm.bytecode;

import java.io.IOException;
import java.io.InputStream;

public class T_U1 extends Number implements IReader {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2424862085779037325L;

	byte bval[];
	private long lvalue;
	
	public T_U1() {
		bval = new byte[1];
		bval[0] = 0;
		lvalue = 0;
	}
	
	private T_U1(byte[] bval_in) {
		
		bval = bval_in;
		lvalue = 0;
		// BE 
		for (int i = 0; i < bval.length; i++)
		{
		   lvalue = (lvalue << 8) + (bval[i] & 0xff);
		}
	}
	
	@Override
	public T_U1 set(InputStream is) throws IOException {
		byte[] nbval = new byte[1];
		int r = 0;
		while(r == 0) {
			int i = is.read(nbval, r, 1);
			if (i < 0) {
				r = i;
			} else {
				r += i;
			}
		}
		
		if (r < 0) {
			throw new IOException("U1 Data incomplete");
		}
		
		// LE
		/*
		for (int i = 0; i < bval.length; i++)
		{
		   lvalue += ((long) bval[i] & 0xffL) << (8 * i);
		}
		*/
		

		return new T_U1(nbval);
		
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
	
	public long inc() {
		if (lvalue == 255) {
			throw new ArithmeticException("Overflow error");
		}
		bval[0] = (byte) (bval[0] + 1);
		lvalue++;
		return lvalue;
	}
	
	public long dec() {
		if (lvalue == 0) {
			throw new ArithmeticException("Underflow error");
		}
		bval[0] = (byte) (bval[0] - 1);
		lvalue--;
		return lvalue;
	}
	
	public long add(long val) {
		if (lvalue + val > 255) {
			throw new ArithmeticException("Overflow error");
		}
		
		if (lvalue + val < 0) {
			throw new ArithmeticException("Underflow error");
		}
		
		bval[0] = (byte) (bval[0] + val);
		lvalue += val;
		return lvalue;
	}
	
	public boolean equals(Number n) {
		return lvalue == n.longValue();
	}
	
	public int write(byte d[]) {
		d[0] = bval[0];
		return 1;
	}
	
	public String toString() {
		return String.format("0x%2x", lvalue).replace(' ', '0');
	}
	
	public byte[] getBytesBE() {
	  byte[] r = new byte[1];
	  r[0] = bval[0];
	  return r;
	}
	
}
