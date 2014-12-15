package com.vnetpublishing.java.asm.bytecode;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public interface IListReader<T> extends Serializable {
	IListReader<?> set(InputStream is, long count) throws IOException;
	IListReader<?> cons(T i);
}
