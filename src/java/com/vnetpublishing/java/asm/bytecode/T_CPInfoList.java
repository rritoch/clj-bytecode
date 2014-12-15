package com.vnetpublishing.java.asm.bytecode;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class T_CPInfoList  implements IListReader<T_CPInfo>, List<T_CPInfo> {

	List<T_CPInfo> items;
	
	public T_CPInfoList() {
		items = new ArrayList<T_CPInfo>();
	}
	
	private T_CPInfoList(List<T_CPInfo> items) {
		this.items = items;
	}
	
	private T_CPInfoList (T_CPInfo item, T_CPInfoList parent) {
		T_CPInfo store[] = new T_CPInfo[parent.size()];
		items = new ArrayList<T_CPInfo>(Arrays.asList(parent.toArray(store)));
		items.add(item);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -9005504873625218925L;
	

	
	@Override
	public int size() {
		return items.size();
	}

	@Override
	public boolean isEmpty() {
		return items.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return items.contains(o);
	}

	@Override
	public Iterator<T_CPInfo> iterator() {
		return items.iterator();
	}

	@Override
	public Object[] toArray() {
		return items.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return items.toArray(a);
	}

	@Override
	public boolean add(T_CPInfo e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return items.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T_CPInfo> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends T_CPInfo> c) {
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
	public T_CPInfo get(int index) {
		return items.get(index);
	}

	@Override
	public T_CPInfo set(int index, T_CPInfo element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, T_CPInfo element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T_CPInfo remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int indexOf(Object o) {
		return items.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return items.lastIndexOf(o);
	}

	@Override
	public ListIterator<T_CPInfo> listIterator() {
		return items.listIterator();
	}

	@Override
	public ListIterator<T_CPInfo> listIterator(int index) {
		return items.listIterator(index);
	}

	@Override
	public List<T_CPInfo> subList(int fromIndex, int toIndex) {
		return new T_CPInfoList(items.subList(fromIndex,  toIndex));
	}
	
	public T_CPInfoList cons(T_CPInfo i) {
		return new T_CPInfoList (i, this);
	}
	
	@Override
	public T_CPInfoList set(InputStream is, long count) throws IOException {
		T_CPInfoList r = new T_CPInfoList();
		for (long i = 0; i < count; i++) {
			System.out.println(i+":");
			T_CPInfo item = (new T_CPInfo()).set(is);
			r = r.cons(item);
			
			// CONSTANT_Double_info and CONSTANT_Long_info take 2 constant
			T_U1 tag = item.getTag();
			if ((tag.intValue() == T_CPInfo.CONSTANT_Long) ||
				(tag.intValue() == T_CPInfo.CONSTANT_Double)) {
				r = r.cons(new T_CPInfo());
				i++;
			}
		}
		return r;
	}


}
