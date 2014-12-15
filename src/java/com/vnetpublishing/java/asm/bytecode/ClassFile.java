
package com.vnetpublishing.java.asm.bytecode;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.io.PushbackInputStream;


public class ClassFile {
	
	private URL url;
	
	public ClassFile(URL url) {
		this.url = url;
	}
	
	public ClassFile(URI uri) throws MalformedURLException {
		this.url = uri.toURL();
	}
	
	public ClassFile(String src) throws MalformedURLException {
		this.url = (new File(src)).toURI().toURL();
	}
	
	private T_U4 magic;
	private T_U2 minor_version;
	private T_U2 major_version;
	//public T_U2 constant_pool_count;
	private T_CPInfoList constant_pool_list;
	private T_U2 access_flags;
	private T_U2 this_class;
	private T_U2 super_class;
	//public T_U2 interfaces_count;
	public T_U2List interfaces_list;
	//public T_U2 fields_count;
	public T_FieldInfoList fields;
	//public T_U2 methods_count;
	private T_MethodInfoList methods;
	//public T_U2 attributes_count;
	private T_AttributeInfoList attributes;
	
	public T_U4 getMagic() {
		return magic;
	}
	
	public T_U2 getMinorVersion() {
		return minor_version;
	}
	
	public T_U2 getMajorVersion() {
		return major_version;
	}
	
	public T_U2 getConstantPoolCount() {
		return (new T_U2()).add(constant_pool_list.size()).inc();
	}
	
	public T_CPInfoList getConstantPoolList() {
		return constant_pool_list;
	}
	
	public T_U2 getAccessFlags() {
		return access_flags;
	}
	
	public T_U2 getThisClass() {
		return this_class;
	}
	
	public T_U2 getSuperClass() {
		return super_class;
	}
	
	public T_U2 getInterfacesCount() {
		return (new T_U2()).add(interfaces_list.size());
	}
	
	public T_U2List getInterfacesList() {
		return interfaces_list;
	}
	
	public T_U2 getFieldsCount() {
		return (new T_U2()).add(fields.size());
	}
	
	
	public T_FieldInfoList getFields() {
		return fields;
	}
	
	public T_U2 getMethodsCount() {
		return (new T_U2()).add(methods.size());
	}
	
	public T_MethodInfoList getMethods() {
		return methods;
	}
	
	public T_U2 getAttributesCount() {
		return (new T_U2()).add(attributes.size());
	}
	
	public T_AttributeInfoList getAttributes() {
		return attributes;
	}
	
	public void read() throws IOException {
		InputStream bis = new PushbackInputStream(url.openStream());
		
		try {
		
		magic = (new T_U4()).set(bis);
		minor_version = (new T_U2()).set(bis);
		major_version = (new T_U2()).set(bis);
		T_U2 constant_pool_count = (new T_U2()).set(bis);
		System.out.println("constant_pool_count = " + constant_pool_count);
		constant_pool_list = (new T_CPInfoList()).set(bis,constant_pool_count.intValue()-1);
		access_flags = (new T_U2()).set(bis);
		this_class = (new T_U2()).set(bis);
		super_class = (new T_U2()).set(bis);
		
		T_U2 interfaces_count = (new T_U2()).set(bis);
		interfaces_list = (new T_U2List()).set(bis,interfaces_count.intValue());
		
		T_U2 fields_count = (new T_U2()).set(bis);
		fields = (new T_FieldInfoList()).set(bis,fields_count.intValue());
		
		T_U2 methods_count = (new T_U2()).set(bis);
		methods = (new T_MethodInfoList()).set(bis,methods_count.intValue());
		
		T_U2 attributes_count = (new T_U2()).set(bis);
		attributes = (new T_AttributeInfoList()).set(bis,attributes_count.intValue());
		
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
}