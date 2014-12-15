package com.vnetpublishing.java.asm.bytecode;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class T_MethodInfoList  implements List<T_MethodInfo> , IListReader<T_MethodInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3832331033574790169L;


	ArrayList<T_MethodInfo> value;
	
	public T_MethodInfoList() {
		value = new ArrayList<T_MethodInfo>();
	}
	
	private T_MethodInfoList(T_MethodInfo item,T_MethodInfoList parent) {
		T_MethodInfo store[] = new T_MethodInfo[parent.size()];
		value = new ArrayList<T_MethodInfo>(Arrays.asList(parent.toArray(store)));
		value.add(item);
	}
	
	@Override
	public int size() {
		return value.size();
	}

	@Override
	public boolean isEmpty() {
		return value.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return value.contains(o);
	}

	@Override
	public Iterator<T_MethodInfo> iterator() {
		return value.iterator();
	}

	@Override
	public Object[] toArray() {
		return value.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return value.toArray(a);
	}

	@Override
	public boolean add(T_MethodInfo e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return value.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T_MethodInfo> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends T_MethodInfo> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public T_MethodInfo get(int index) {
		return value.get(index);
	}

	@Override
	public T_MethodInfo set(int index, T_MethodInfo element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, T_MethodInfo element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T_MethodInfo remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int indexOf(Object o) {
		return value.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return value.lastIndexOf(o);
	}

	@Override
	public ListIterator<T_MethodInfo> listIterator() {
		return value.listIterator();
	}

	@Override
	public ListIterator<T_MethodInfo> listIterator(int index) {
		return value.listIterator(index);
	}

	@Override
	public List<T_MethodInfo> subList(int fromIndex, int toIndex) {
		return value.subList(fromIndex, toIndex);
	}
	
	public T_MethodInfoList cons(T_MethodInfo item) {
		return new T_MethodInfoList(item, this);
	}

	@Override
	public T_MethodInfoList set(InputStream is, long count) throws IOException {
		T_MethodInfoList r = new T_MethodInfoList();
		for(int i=0; i<count;i++) {
			r = r.cons((new T_MethodInfo()).set(is));
		}
		return r;
	}


}
