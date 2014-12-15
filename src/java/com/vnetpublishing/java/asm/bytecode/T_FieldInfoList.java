package com.vnetpublishing.java.asm.bytecode;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class T_FieldInfoList  implements List<T_FieldInfo>, IListReader<T_FieldInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8078103968502668914L;


	ArrayList<T_FieldInfo> value;
	
	public T_FieldInfoList() {
		value = new ArrayList<T_FieldInfo>();
	}
	
	private T_FieldInfoList (T_FieldInfo item, T_FieldInfoList parent) {
		T_FieldInfo store[] = new T_FieldInfo[parent.size()];
		value = new ArrayList<T_FieldInfo>(Arrays.asList(parent.toArray(store)));
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
	public Iterator<T_FieldInfo> iterator() {
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
	public boolean add(T_FieldInfo e) {
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
	public boolean addAll(Collection<? extends T_FieldInfo> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends T_FieldInfo> c) {
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
	public T_FieldInfo get(int index) {
		return value.get(index);
	}

	@Override
	public T_FieldInfo set(int index, T_FieldInfo element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, T_FieldInfo element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T_FieldInfo remove(int index) {
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
	public ListIterator<T_FieldInfo> listIterator() {
		return value.listIterator();
	}

	@Override
	public ListIterator<T_FieldInfo> listIterator(int index) {
		return value.listIterator(index);
	}

	@Override
	public List<T_FieldInfo> subList(int fromIndex, int toIndex) {
		return value.subList(fromIndex, toIndex);
	}

	public T_FieldInfoList cons(T_FieldInfo item) {
		return new T_FieldInfoList (item,this);
	}
	
	@Override
	public T_FieldInfoList set(InputStream is, long count) throws IOException {
		T_FieldInfoList r = new T_FieldInfoList();
		
		for(int i=0; i<count;i++) {
			r = r.cons ((new T_FieldInfo()).set(is));
		}
		return r;
	}

}
