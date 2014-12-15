package com.vnetpublishing.java.asm.bytecode;

import java.io.IOException;
import java.io.InputStream;

public class T_U4 extends Number implements IReader {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3780280588370670880L;

	private byte bval[];
	private long lvalue;
	
	
	public T_U4() {
		lvalue = 0;
		bval = new byte[4];
	}
	
	private T_U4(byte[] bval_in) {
		bval = bval_in;
		lvalue = 0;
		// BE 
		for (int i = 0; i < bval.length; i++)
		{
		   lvalue = (lvalue << 8) + (bval[i] & 0xff);
		}
		
	}
	
	public T_U4(T_U2 hi, T_U2 low) {
		
		lvalue = (hi.longValue() << 16) + low.longValue();
		bval = new byte[4];
		
		bval[0] = (byte) (lvalue & 255);
		bval[1] = (byte) ((lvalue >> 8)& 255);
		bval[2] = (byte) ((lvalue >> 16)& 255);
		bval[3] = (byte) ((lvalue >> 24)& 255);
		
	}
	
	
	@Override
	public T_U4 set(InputStream is) throws IOException {
		byte[] nbval = new byte[4];
		
		int r = 0;
		while(r >= 0 && r < 4) {
			int i = is.read(nbval, r, 4-r);
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
		
		return new T_U4(nbval);
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

	/*
	public long inc() {
		if (lvalue == 4294967295L) {
			throw new ArithmeticException("Overflow error");
		}
		
		
		if (bval[0] == 255) {
			bval[0] = 0;
			if (bval[1] == 255) {
				bval[1] = 0;
				
				if (bval[2] == 255) {
					bval[2] = 0;
					bval[3] = (byte) (bval[3] + 1);
				} else {
					bval[2] = (byte) (bval[2] + 1);
				}
			} else {
				bval[1] = (byte) (bval[1] + 1);
			}
		} else {
			bval[0] = (byte)(bval[0] + 1);
		}
		
		lvalue++;
		return lvalue;
	}
	
	public long dec() {
		if (lvalue == 0) {
			throw new ArithmeticException("Underflow error");
		}
		
		if (bval[0] == 0) {
			bval[0] = (byte)255;
			if (bval[1] == 0) {
				bval[1] = (byte) 255;
				if (bval[2] == 0) {
					bval[2] = (byte) 255;
					bval[3] = (byte) (bval[3] - 1);
				} else {
					bval[2] = (byte) (bval[2] - 1);
				}
			} else {
			  bval[1] = (byte) (bval[1] - 1);
			}
		} else {
			bval[0] = (byte) (bval[0] - 1);
		}
		
		lvalue--;
		return lvalue;
	}
	*/
	
	public T_U4 add(long val) {
		
		if (lvalue + val > 4294967295L) {
			throw new ArithmeticException("Overflow error");
		}
		
		if (lvalue + val < 0) {
			throw new ArithmeticException("Underflow error");
		}
		
		long nlvalue = lvalue + val;
		byte[] nbval = new byte[4];
		
		nbval[3] = (byte) (nlvalue & 255);
		nbval[2] = (byte) ((nlvalue >> 8)& 255);
		nbval[1] = (byte) ((nlvalue >> 16)& 255);
		nbval[0] = (byte) ((nlvalue >> 24)& 255);
		
		return new T_U4(nbval);
	}
	
	public byte[] getBytesBE() {
		byte[] r = new byte[4];
		r[0] = bval[0];
		r[1] = bval[1];
		r[2] = bval[2];
		r[3] = bval[3];
		return r;
	}
	
	public String toString() {
		return String.format("0x%8s", Integer.toHexString((int) lvalue)).replace(' ', '0');
	}
}
