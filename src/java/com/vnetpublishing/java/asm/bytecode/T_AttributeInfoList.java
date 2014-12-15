package com.vnetpublishing.java.asm.bytecode;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class T_AttributeInfoList implements IListReader<T_AttributeInfo>, List<T_AttributeInfo> {

	
	ArrayList<T_AttributeInfo> value;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8772480534054266127L;

	
	public T_AttributeInfoList() {
		value = new ArrayList<T_AttributeInfo>();
	}

	private T_AttributeInfoList(T_AttributeInfo item,
			T_AttributeInfoList parent) {
		T_AttributeInfo[] store = new T_AttributeInfo[parent.size()];
		value = new ArrayList<T_AttributeInfo>(Arrays.asList(parent.toArray(store)));
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
	public Iterator<T_AttributeInfo> iterator() {
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
	public boolean add(T_AttributeInfo e) {
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
	public boolean addAll(Collection<? extends T_AttributeInfo> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends T_AttributeInfo> c) {
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
	public T_AttributeInfo get(int index) {
		return value.get(index);
	}

	@Override
	public T_AttributeInfo set(int index, T_AttributeInfo element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, T_AttributeInfo element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T_AttributeInfo remove(int index) {
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
	public ListIterator<T_AttributeInfo> listIterator() {
		return value.listIterator();
	}

	@Override
	public ListIterator<T_AttributeInfo> listIterator(int index) {
		return value.listIterator(index);
	}

	@Override
	public List<T_AttributeInfo> subList(int fromIndex, int toIndex) {
		return value.subList(fromIndex, toIndex);
	}

	public T_AttributeInfoList cons(T_AttributeInfo item) {
		return new T_AttributeInfoList(item,this);
	}
	
	@Override
	public T_AttributeInfoList set(InputStream is, long count) throws IOException {
		T_AttributeInfoList r = new T_AttributeInfoList();
		for(long i=0; i<count;i++) {
			r = r.cons((new T_AttributeInfo()).set(is));
		}
		return r;
	}
	
}
