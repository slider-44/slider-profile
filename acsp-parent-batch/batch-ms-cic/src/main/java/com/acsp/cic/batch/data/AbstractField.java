package com.acsp.cic.batch.data;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

import org.jooq.BetweenAndStep;
import org.jooq.Binding;
import org.jooq.Comparator;
import org.jooq.Condition;
import org.jooq.Configuration;
import org.jooq.Converter;
import org.jooq.DataType;
import org.jooq.DatePart;
import org.jooq.Field;
import org.jooq.QuantifiedSelect;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.Select;
import org.jooq.SortField;
import org.jooq.SortOrder;
import org.jooq.WindowIgnoreNullsStep;
import org.jooq.WindowPartitionByStep;

/**
 * Created by elaguardia on 03/22/2016.
 */
public abstract class AbstractField implements Field<String> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2670989627923574751L;

	@Override
	public Field<String> abs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> acos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> add(Number value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> add(Field<?> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> as(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> as(Field<?> otherField) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortField<String> asc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<Integer> ascii() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> asin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> atan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> atan2(Number y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> atan2(Field<? extends Number> y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> avg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowPartitionByStep<BigDecimal> avgOver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BetweenAndStep<String> between(String minValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BetweenAndStep<String> between(Field<String> minValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition between(String minValue, String maxValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition between(Field<String> minValue, Field<String> maxValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BetweenAndStep<String> betweenSymmetric(String minValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BetweenAndStep<String> betweenSymmetric(Field<String> minValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition betweenSymmetric(String minValue, String maxValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition betweenSymmetric(Field<String> minValue, Field<String> maxValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> bitAnd(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> bitAnd(Field<String> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<Integer> bitLength() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> bitNand(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> bitNand(Field<String> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> bitNor(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> bitNor(Field<String> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> bitNot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> bitOr(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> bitOr(Field<String> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> bitXNor(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> bitXNor(Field<String> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> bitXor(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> bitXor(Field<String> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <Z> Field<Z> cast(Field<Z> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <Z> Field<Z> cast(DataType<Z> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <Z> Field<Z> cast(Class<Z> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> ceil() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<Integer> charLength() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> coalesce(String option, String... options) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> coalesce(Field<String> option, Field<?>... options) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <Z> Field<Z> coerce(Field<Z> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <Z> Field<Z> coerce(DataType<Z> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <Z> Field<Z> coerce(Class<Z> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition compare(Comparator comparator, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition compare(Comparator comparator, Field<String> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition compare(Comparator comparator, Select<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition compare(Comparator comparator, QuantifiedSelect<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> concat(Field<?>... fields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> concat(String... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition contains(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition contains(Field<String> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> cos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> cosh() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> cot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> coth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<Integer> count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<Integer> countDistinct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowPartitionByStep<Integer> countOver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <Z> Field<Z> decode(String search, Z result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <Z> Field<Z> decode(Field<String> search, Field<Z> result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <Z> Field<Z> decode(String search, Z result, Object... more) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <Z> Field<Z> decode(Field<String> search, Field<Z> result, Field<?>... more) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> deg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortField<String> desc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> div(Number value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> div(Field<? extends Number> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> divide(Number value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> divide(Field<? extends Number> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition endsWith(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition endsWith(Field<String> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition eq(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition eq(Field<String> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition eq(Select<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition eq(QuantifiedSelect<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition equal(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition equal(Field<String> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition equal(Select<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition equal(QuantifiedSelect<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition equalIgnoreCase(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition equalIgnoreCase(Field<String> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> exp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<Integer> extract(DatePart datePart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowIgnoreNullsStep<String> firstValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> floor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition ge(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition ge(Field<String> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition ge(Select<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition ge(QuantifiedSelect<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Binding<?, String> getBinding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Converter<?, String> getConverter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataType<String> getDataType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataType<String> getDataType(Configuration configuration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<String> getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition greaterOrEqual(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition greaterOrEqual(Field<String> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition greaterOrEqual(Select<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition greaterOrEqual(QuantifiedSelect<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition greaterThan(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition greaterThan(Field<String> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition greaterThan(Select<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition greaterThan(QuantifiedSelect<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> greatest(String... others) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> greatest(Field<?>... others) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition gt(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition gt(Field<String> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition gt(Select<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition gt(QuantifiedSelect<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition in(Collection<?> values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition in(Result<? extends Record1<String>> result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition in(String... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition in(Field<?>... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition in(Select<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition isDistinctFrom(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition isDistinctFrom(Field<String> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition isFalse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition isNotDistinctFrom(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition isNotDistinctFrom(Field<String> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition isNotNull() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition isNull() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition isTrue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowIgnoreNullsStep<String> lag() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowIgnoreNullsStep<String> lag(int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowIgnoreNullsStep<String> lag(int offset, String defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowIgnoreNullsStep<String> lag(int offset, Field<String> defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowIgnoreNullsStep<String> lastValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition le(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition le(Field<String> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition le(Select<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition le(QuantifiedSelect<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowIgnoreNullsStep<String> lead() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowIgnoreNullsStep<String> lead(int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowIgnoreNullsStep<String> lead(int offset, String defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowIgnoreNullsStep<String> lead(int offset, Field<String> defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> least(String... others) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> least(Field<?>... others) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<Integer> length() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition lessOrEqual(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition lessOrEqual(Field<String> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition lessOrEqual(Select<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition lessOrEqual(QuantifiedSelect<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition lessThan(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition lessThan(Field<String> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition lessThan(Select<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition lessThan(QuantifiedSelect<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition like(Field<String> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition like(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition like(Field<String> value, char escape) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition like(String value, char escape) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition likeIgnoreCase(Field<String> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition likeIgnoreCase(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition likeIgnoreCase(Field<String> field, char escape) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition likeIgnoreCase(String value, char escape) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition likeRegex(String pattern) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition likeRegex(Field<String> pattern) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> ln() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> log(int base) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> lower() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> lpad(Field<? extends Number> length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> lpad(int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> lpad(Field<? extends Number> length, Field<String> character) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> lpad(int length, char character) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition lt(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition lt(Field<String> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition lt(Select<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition lt(QuantifiedSelect<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> ltrim() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> max() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowPartitionByStep<String> maxOver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> median() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> min() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowPartitionByStep<String> minOver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> minus(Number value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> minus(Field<?> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> mod(Number value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> mod(Field<? extends Number> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> modulo(Number value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> modulo(Field<? extends Number> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> mul(Number value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> mul(Field<? extends Number> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> multiply(Number value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> multiply(Field<? extends Number> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition ne(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition ne(Field<String> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition ne(Select<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition ne(QuantifiedSelect<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> neg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BetweenAndStep<String> notBetween(String minValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BetweenAndStep<String> notBetween(Field<String> minValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notBetween(String minValue, String maxValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notBetween(Field<String> minValue, Field<String> maxValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BetweenAndStep<String> notBetweenSymmetric(String minValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BetweenAndStep<String> notBetweenSymmetric(Field<String> minValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notBetweenSymmetric(String minValue, String maxValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notBetweenSymmetric(Field<String> minValue, Field<String> maxValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notEqual(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notEqual(Field<String> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notEqual(Select<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notEqual(QuantifiedSelect<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notEqualIgnoreCase(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notEqualIgnoreCase(Field<String> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notIn(Collection<?> values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notIn(Result<? extends Record1<String>> result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notIn(String... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notIn(Field<?>... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notIn(Select<? extends Record1<String>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notLike(Field<String> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notLike(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notLike(Field<String> field, char escape) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notLike(String value, char escape) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notLikeIgnoreCase(Field<String> field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notLikeIgnoreCase(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notLikeIgnoreCase(Field<String> field, char escape) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notLikeIgnoreCase(String value, char escape) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notLikeRegex(String pattern) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition notLikeRegex(Field<String> pattern) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> nullif(String other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> nullif(Field<String> other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> nvl(String defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> nvl(Field<String> defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <Z> Field<Z> nvl2(Z valueIfNotNull, Z valueIfNull) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <Z> Field<Z> nvl2(Field<Z> valueIfNotNull, Field<Z> valueIfNull) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<Integer> octetLength() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> plus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> plus(Number value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> plus(Field<?> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<Integer> position(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<Integer> position(Field<String> search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> pow(Number exponent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> power(Number exponent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> rad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> repeat(Number count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> repeat(Field<? extends Number> count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> replace(Field<String> search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> replace(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> replace(Field<String> search, Field<String> replace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> replace(String search, String replace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> round() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> round(int decimals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> rpad(Field<? extends Number> length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> rpad(int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> rpad(Field<? extends Number> length, Field<String> character) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> rpad(int length, char character) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> rtrim() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> shl(Number value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> shl(Field<? extends Number> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> shr(Number value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> shr(Field<? extends Number> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<Integer> sign() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> sin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> sinh() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortField<String> sort(SortOrder order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <Z> SortField<Z> sort(Map<String, Z> sortMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortField<Integer> sortAsc(Collection<String> sortList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortField<Integer> sortAsc(String... sortList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortField<Integer> sortDesc(Collection<String> sortList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortField<Integer> sortDesc(String... sortList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> sqrt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition startsWith(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condition startsWith(Field<String> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> stddevPop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowPartitionByStep<BigDecimal> stddevPopOver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> stddevSamp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowPartitionByStep<BigDecimal> stddevSampOver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> sub(Number value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> sub(Field<?> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> substring(int startingPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> substring(Field<? extends Number> startingPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> substring(int startingPosition, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> substring(Field<? extends Number> startingPosition, Field<? extends Number> length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> subtract(Number value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> subtract(Field<?> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> sum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowPartitionByStep<BigDecimal> sumOver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> tan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> tanh() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> trim() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<String> upper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> varPop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowPartitionByStep<BigDecimal> varPopOver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field<BigDecimal> varSamp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindowPartitionByStep<BigDecimal> varSampOver() {
		// TODO Auto-generated method stub
		return null;
	}

}
