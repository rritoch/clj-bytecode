package com.vnetpublishing.java.asm.bytecode;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class T_U1List implements IListReader<T_U1>, List<T_U1> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5487236917387846592L;

	
	ArrayList<T_U1> value;
	
	public T_U1List() {
		value = new ArrayList<T_U1>();
	}
	
	
	private T_U1List(T_U1 item,T_U1List parent) {
		T_U1 store[] = new T_U1[parent.size()];
		value = new ArrayList<T_U1>(Arrays.asList(parent.toArray(store)));
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
	public Iterator<T_U1> iterator() {
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
	public boolean add(T_U1 e) {
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
	public boolean addAll(Collection<? extends T_U1> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends T_U1> c) {
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
	public T_U1 get(int index) {
		return value.get(index);
	}

	@Override
	public T_U1 set(int index, T_U1 element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, T_U1 element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T_U1 remove(int index) {
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
	public ListIterator<T_U1> listIterator() {
		return value.listIterator();
	}

	@Override
	public ListIterator<T_U1> listIterator(int index) {
		return value.listIterator(index);
	}

	@Override
	public List<T_U1> subList(int fromIndex, int toIndex) {
		return value.subList(fromIndex, toIndex);
	}

	public T_U1List cons(T_U1 item) {
		return new T_U1List (item,this);
	}
	
	@Override
	public T_U1List set(InputStream is, long count) throws IOException {
		T_U1List r = new T_U1List();
		
		for(int i=0; i<count;i++) {
			r = r.cons((new T_U1()).set(is));
		}
		return r;
	}

}
