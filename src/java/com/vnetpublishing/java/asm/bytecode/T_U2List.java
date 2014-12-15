package com.vnetpublishing.java.asm.bytecode;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class T_U2List implements IListReader<T_U2>, List<T_U2> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3721178235998292554L;

	ArrayList<T_U2> value;
	
	public T_U2List() {
		value = new ArrayList<T_U2>();
	}

	
	private T_U2List(T_U2 item,T_U2List parent) {
		T_U2 store[] = new T_U2[parent.size()];
		value = new ArrayList<T_U2>(Arrays.asList(parent.toArray(store)));
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
	public Iterator<T_U2> iterator() {
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
	public boolean add(T_U2 e) {
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
	public boolean addAll(Collection<? extends T_U2> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends T_U2> c) {
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
	public T_U2 get(int index) {
		return value.get(index);
	}

	@Override
	public T_U2 set(int index, T_U2 element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, T_U2 element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T_U2 remove(int index) {
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
	public ListIterator<T_U2> listIterator() {
		return value.listIterator();
	}

	@Override
	public ListIterator<T_U2> listIterator(int index) {
		return value.listIterator(index);
	}

	@Override
	public List<T_U2> subList(int fromIndex, int toIndex) {
		return value.subList(fromIndex, toIndex);
	}

	public T_U2List cons(T_U2 item) {
		return new T_U2List (item,this);
	}
	
	@Override
	public T_U2List set(InputStream is, long count) throws IOException {
		T_U2List r = new T_U2List();
		
		for(long i=0; i<count;i++) {
			r = r.cons((new T_U2()).set(is));
		}
		return r;
	}

}
