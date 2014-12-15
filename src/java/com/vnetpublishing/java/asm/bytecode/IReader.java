package com.vnetpublishing.java.asm.bytecode;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public interface IReader extends Serializable {

	IReader set(InputStream is) throws IOException;
}
