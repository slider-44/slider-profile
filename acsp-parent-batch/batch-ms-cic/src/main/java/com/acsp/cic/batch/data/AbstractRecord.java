package com.acsp.cic.batch.data;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.jooq.Configuration;
import org.jooq.Converter;
import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Record11;
import org.jooq.Record12;
import org.jooq.Record13;
import org.jooq.Record14;
import org.jooq.Record15;
import org.jooq.Record16;
import org.jooq.Record17;
import org.jooq.Record18;
import org.jooq.Record19;
import org.jooq.Record2;
import org.jooq.Record20;
import org.jooq.Record21;
import org.jooq.Record22;
import org.jooq.Record3;
import org.jooq.Record4;
import org.jooq.Record5;
import org.jooq.Record6;
import org.jooq.Record7;
import org.jooq.Record8;
import org.jooq.Record9;
import org.jooq.RecordMapper;
import org.jooq.Row;
import org.jooq.Table;
import org.jooq.exception.DataTypeException;
import org.jooq.exception.MappingException;

/**
 * Created by elaguardia on 03/22/2016.
 */
public abstract class AbstractRecord implements Record {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8110417486823253703L;

	@Override
	public void attach(Configuration configuration) {
		// TODO Auto-generated method stub

	}

	@Override
	public void detach() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean changed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changed(Field<?> field) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changed(int fieldIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changed(String fieldName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changed(Name fieldName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void changed(boolean changed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changed(Field<?> field, boolean changed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changed(int fieldIndex, boolean changed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changed(String fieldName, boolean changed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changed(Name fieldName, boolean changed) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareTo(Record record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> Field<T> field(Field<T> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<?> field(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<?> field(Name name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<?> field(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<?>[] fields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<?>[] fields(Field<?>... fields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<?>[] fields(String... fieldNames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<?>[] fields(Name... fieldNames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<?>[] fields(int... fieldIndexes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Row fieldsRow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void from(Object source) throws MappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void from(Object source, Field<?>... fields) throws MappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void from(Object source, String... fieldNames) throws MappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void from(Object source, Name... fieldNames) throws MappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void from(Object source, int... fieldIndexes) throws MappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void fromArray(Object... array) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fromArray(Object[] array, Field<?>... fields) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fromArray(Object[] array, String... fieldNames) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fromArray(Object[] array, Name... fieldNames) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fromArray(Object[] array, int... fieldIndexes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fromMap(Map<String, ?> map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fromMap(Map<String, ?> map, Field<?>... fields) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fromMap(Map<String, ?> map, String... fieldNames) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fromMap(Map<String, ?> map, Name... fieldNames) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fromMap(Map<String, ?> map, int... fieldIndexes) {
		// TODO Auto-generated method stub

	}



	@Override
	public <T> T getValue(Field<T> field) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getValue(String fieldName) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getValue(Name fieldName) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getValue(int index) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getValue(Field<T> field, T defaultValue) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getValue(Field<?> field, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T, U> U getValue(Field<T> field, Converter<? super T, U> converter)
			throws IllegalArgumentException, DataTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getValue(String fieldName, Object defaultValue) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getValue(String fieldName, Class<? extends T> type)
			throws IllegalArgumentException, DataTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U> U getValue(String fieldName, Converter<?, U> converter)
			throws IllegalArgumentException, DataTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getValue(Name fieldName, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U> U getValue(Name fieldName, Converter<?, U> converter)
			throws IllegalArgumentException, DataTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getValue(int index, Object defaultValue) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getValue(int index, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U> U getValue(int index, Converter<?, U> converter) throws IllegalArgumentException, DataTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getValue(Field<?> field, Class<? extends T> type, T defaultValue)
			throws IllegalArgumentException, DataTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T, U> U getValue(Field<T> field, Converter<? super T, U> converter, U defaultValue)
			throws IllegalArgumentException, DataTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getValue(String fieldName, Class<? extends T> type, T defaultValue)
			throws IllegalArgumentException, DataTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U> U getValue(String fieldName, Converter<?, U> converter, U defaultValue)
			throws IllegalArgumentException, DataTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getValue(int index, Class<? extends T> type, T defaultValue)
			throws IllegalArgumentException, DataTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U> U getValue(int index, Converter<?, U> converter, U defaultValue)
			throws IllegalArgumentException, DataTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Record into(Field<?>... fields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1> Record1<T1> into(Field<T1> name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <E> E into(Class<? extends E> type) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <E> E into(E object) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <R extends Record> R into(Table<R> table) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2> Record2<T1, T2> into(Field<T1> arg0, Field<T2> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3> Record3<T1, T2, T3> into(Field<T1> arg0, Field<T2> arg1, Field<T3> arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4> Record4<T1, T2, T3, T4> into(Field<T1> arg0, Field<T2> arg1, Field<T3> arg2,
			Field<T4> arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4, T5> Record5<T1, T2, T3, T4, T5> into(Field<T1> arg0, Field<T2> arg1, Field<T3> arg2,
			Field<T4> arg3, Field<T5> arg4) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4, T5, T6> Record6<T1, T2, T3, T4, T5, T6> into(Field<T1> arg0, Field<T2> arg1, Field<T3> arg2,
			Field<T4> arg3, Field<T5> arg4, Field<T6> arg5) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7> Record7<T1, T2, T3, T4, T5, T6, T7> into(Field<T1> arg0, Field<T2> arg1,
			Field<T3> arg2, Field<T4> arg3, Field<T5> arg4, Field<T6> arg5, Field<T7> arg6) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8> Record8<T1, T2, T3, T4, T5, T6, T7, T8> into(Field<T1> arg0, Field<T2> arg1,
			Field<T3> arg2, Field<T4> arg3, Field<T5> arg4, Field<T6> arg5, Field<T7> arg6, Field<T8> arg7) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9> Record9<T1, T2, T3, T4, T5, T6, T7, T8, T9> into(Field<T1> arg0,
			Field<T2> arg1, Field<T3> arg2, Field<T4> arg3, Field<T5> arg4, Field<T6> arg5, Field<T7> arg6,
			Field<T8> arg7, Field<T9> arg8) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Record10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> into(
			Field<T1> arg0, Field<T2> arg1, Field<T3> arg2, Field<T4> arg3, Field<T5> arg4, Field<T6> arg5,
			Field<T7> arg6, Field<T8> arg7, Field<T9> arg8, Field<T10> arg9) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> Record11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> into(
			Field<T1> arg0, Field<T2> arg1, Field<T3> arg2, Field<T4> arg3, Field<T5> arg4, Field<T6> arg5,
			Field<T7> arg6, Field<T8> arg7, Field<T9> arg8, Field<T10> arg9, Field<T11> arg10) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> Record12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> into(
			Field<T1> arg0, Field<T2> arg1, Field<T3> arg2, Field<T4> arg3, Field<T5> arg4, Field<T6> arg5,
			Field<T7> arg6, Field<T8> arg7, Field<T9> arg8, Field<T10> arg9, Field<T11> arg10, Field<T12> arg11) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> Record13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> into(
			Field<T1> arg0, Field<T2> arg1, Field<T3> arg2, Field<T4> arg3, Field<T5> arg4, Field<T6> arg5,
			Field<T7> arg6, Field<T8> arg7, Field<T9> arg8, Field<T10> arg9, Field<T11> arg10, Field<T12> arg11,
			Field<T13> arg12) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> Record14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> into(
			Field<T1> arg0, Field<T2> arg1, Field<T3> arg2, Field<T4> arg3, Field<T5> arg4, Field<T6> arg5,
			Field<T7> arg6, Field<T8> arg7, Field<T9> arg8, Field<T10> arg9, Field<T11> arg10, Field<T12> arg11,
			Field<T13> arg12, Field<T14> arg13) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> Record15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> into(
			Field<T1> arg0, Field<T2> arg1, Field<T3> arg2, Field<T4> arg3, Field<T5> arg4, Field<T6> arg5,
			Field<T7> arg6, Field<T8> arg7, Field<T9> arg8, Field<T10> arg9, Field<T11> arg10, Field<T12> arg11,
			Field<T13> arg12, Field<T14> arg13, Field<T15> arg14) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> Record16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> into(
			Field<T1> arg0, Field<T2> arg1, Field<T3> arg2, Field<T4> arg3, Field<T5> arg4, Field<T6> arg5,
			Field<T7> arg6, Field<T8> arg7, Field<T9> arg8, Field<T10> arg9, Field<T11> arg10, Field<T12> arg11,
			Field<T13> arg12, Field<T14> arg13, Field<T15> arg14, Field<T16> arg15) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> Record17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> into(
			Field<T1> arg0, Field<T2> arg1, Field<T3> arg2, Field<T4> arg3, Field<T5> arg4, Field<T6> arg5,
			Field<T7> arg6, Field<T8> arg7, Field<T9> arg8, Field<T10> arg9, Field<T11> arg10, Field<T12> arg11,
			Field<T13> arg12, Field<T14> arg13, Field<T15> arg14, Field<T16> arg15, Field<T17> arg16) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> Record18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> into(
			Field<T1> arg0, Field<T2> arg1, Field<T3> arg2, Field<T4> arg3, Field<T5> arg4, Field<T6> arg5,
			Field<T7> arg6, Field<T8> arg7, Field<T9> arg8, Field<T10> arg9, Field<T11> arg10, Field<T12> arg11,
			Field<T13> arg12, Field<T14> arg13, Field<T15> arg14, Field<T16> arg15, Field<T17> arg16,
			Field<T18> arg17) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> Record19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> into(
			Field<T1> arg0, Field<T2> arg1, Field<T3> arg2, Field<T4> arg3, Field<T5> arg4, Field<T6> arg5,
			Field<T7> arg6, Field<T8> arg7, Field<T9> arg8, Field<T10> arg9, Field<T11> arg10, Field<T12> arg11,
			Field<T13> arg12, Field<T14> arg13, Field<T15> arg14, Field<T16> arg15, Field<T17> arg16, Field<T18> arg17,
			Field<T19> arg18) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> Record20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> into(
			Field<T1> arg0, Field<T2> arg1, Field<T3> arg2, Field<T4> arg3, Field<T5> arg4, Field<T6> arg5,
			Field<T7> arg6, Field<T8> arg7, Field<T9> arg8, Field<T10> arg9, Field<T11> arg10, Field<T12> arg11,
			Field<T13> arg12, Field<T14> arg13, Field<T15> arg14, Field<T16> arg15, Field<T17> arg16, Field<T18> arg17,
			Field<T19> arg18, Field<T20> arg19) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> Record21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> into(
			Field<T1> arg0, Field<T2> arg1, Field<T3> arg2, Field<T4> arg3, Field<T5> arg4, Field<T6> arg5,
			Field<T7> arg6, Field<T8> arg7, Field<T9> arg8, Field<T10> arg9, Field<T11> arg10, Field<T12> arg11,
			Field<T13> arg12, Field<T14> arg13, Field<T15> arg14, Field<T16> arg15, Field<T17> arg16, Field<T18> arg17,
			Field<T19> arg18, Field<T20> arg19, Field<T21> arg20) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> Record22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> into(
			Field<T1> arg0, Field<T2> arg1, Field<T3> arg2, Field<T4> arg3, Field<T5> arg4, Field<T6> arg5,
			Field<T7> arg6, Field<T8> arg7, Field<T9> arg8, Field<T10> arg9, Field<T11> arg10, Field<T12> arg11,
			Field<T13> arg12, Field<T14> arg13, Field<T15> arg14, Field<T16> arg15, Field<T17> arg16, Field<T18> arg17,
			Field<T19> arg18, Field<T20> arg19, Field<T21> arg20, Field<T22> arg21) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] intoArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> intoList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> intoMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet intoResultSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <E> E map(RecordMapper<Record, E> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Record original() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T original(Field<T> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object original(int fieldIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object original(String fieldName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object original(Name fieldName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public void reset(Field<?> field) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reset(int fieldIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reset(String fieldName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reset(Name fieldName) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void setValue(Field<T> field, T value) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T, U> void setValue(Field<T> field, U value, Converter<T, ? super U> converter) {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Row valuesRow() {
		// TODO Auto-generated method stub
		return null;
	}

}
