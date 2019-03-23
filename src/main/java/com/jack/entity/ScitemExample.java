package com.jack.entity;

import java.util.ArrayList;
import java.util.List;

public class ScitemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScitemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andScitemidIsNull() {
            addCriterion("scitemid is null");
            return (Criteria) this;
        }

        public Criteria andScitemidIsNotNull() {
            addCriterion("scitemid is not null");
            return (Criteria) this;
        }

        public Criteria andScitemidEqualTo(String value) {
            addCriterion("scitemid =", value, "scitemid");
            return (Criteria) this;
        }

        public Criteria andScitemidNotEqualTo(String value) {
            addCriterion("scitemid <>", value, "scitemid");
            return (Criteria) this;
        }

        public Criteria andScitemidGreaterThan(String value) {
            addCriterion("scitemid >", value, "scitemid");
            return (Criteria) this;
        }

        public Criteria andScitemidGreaterThanOrEqualTo(String value) {
            addCriterion("scitemid >=", value, "scitemid");
            return (Criteria) this;
        }

        public Criteria andScitemidLessThan(String value) {
            addCriterion("scitemid <", value, "scitemid");
            return (Criteria) this;
        }

        public Criteria andScitemidLessThanOrEqualTo(String value) {
            addCriterion("scitemid <=", value, "scitemid");
            return (Criteria) this;
        }

        public Criteria andScitemidLike(String value) {
            addCriterion("scitemid like", value, "scitemid");
            return (Criteria) this;
        }

        public Criteria andScitemidNotLike(String value) {
            addCriterion("scitemid not like", value, "scitemid");
            return (Criteria) this;
        }

        public Criteria andScitemidIn(List<String> values) {
            addCriterion("scitemid in", values, "scitemid");
            return (Criteria) this;
        }

        public Criteria andScitemidNotIn(List<String> values) {
            addCriterion("scitemid not in", values, "scitemid");
            return (Criteria) this;
        }

        public Criteria andScitemidBetween(String value1, String value2) {
            addCriterion("scitemid between", value1, value2, "scitemid");
            return (Criteria) this;
        }

        public Criteria andScitemidNotBetween(String value1, String value2) {
            addCriterion("scitemid not between", value1, value2, "scitemid");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(String value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(String value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(String value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(String value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(String value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(String value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLike(String value) {
            addCriterion("count like", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotLike(String value) {
            addCriterion("count not like", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<String> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<String> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(String value1, String value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(String value1, String value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andSubtotalIsNull() {
            addCriterion("subtotal is null");
            return (Criteria) this;
        }

        public Criteria andSubtotalIsNotNull() {
            addCriterion("subtotal is not null");
            return (Criteria) this;
        }

        public Criteria andSubtotalEqualTo(String value) {
            addCriterion("subtotal =", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalNotEqualTo(String value) {
            addCriterion("subtotal <>", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalGreaterThan(String value) {
            addCriterion("subtotal >", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalGreaterThanOrEqualTo(String value) {
            addCriterion("subtotal >=", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalLessThan(String value) {
            addCriterion("subtotal <", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalLessThanOrEqualTo(String value) {
            addCriterion("subtotal <=", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalLike(String value) {
            addCriterion("subtotal like", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalNotLike(String value) {
            addCriterion("subtotal not like", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalIn(List<String> values) {
            addCriterion("subtotal in", values, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalNotIn(List<String> values) {
            addCriterion("subtotal not in", values, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalBetween(String value1, String value2) {
            addCriterion("subtotal between", value1, value2, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalNotBetween(String value1, String value2) {
            addCriterion("subtotal not between", value1, value2, "subtotal");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("pid like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("pid not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andScidIsNull() {
            addCriterion("scid is null");
            return (Criteria) this;
        }

        public Criteria andScidIsNotNull() {
            addCriterion("scid is not null");
            return (Criteria) this;
        }

        public Criteria andScidEqualTo(String value) {
            addCriterion("scid =", value, "scid");
            return (Criteria) this;
        }

        public Criteria andScidNotEqualTo(String value) {
            addCriterion("scid <>", value, "scid");
            return (Criteria) this;
        }

        public Criteria andScidGreaterThan(String value) {
            addCriterion("scid >", value, "scid");
            return (Criteria) this;
        }

        public Criteria andScidGreaterThanOrEqualTo(String value) {
            addCriterion("scid >=", value, "scid");
            return (Criteria) this;
        }

        public Criteria andScidLessThan(String value) {
            addCriterion("scid <", value, "scid");
            return (Criteria) this;
        }

        public Criteria andScidLessThanOrEqualTo(String value) {
            addCriterion("scid <=", value, "scid");
            return (Criteria) this;
        }

        public Criteria andScidLike(String value) {
            addCriterion("scid like", value, "scid");
            return (Criteria) this;
        }

        public Criteria andScidNotLike(String value) {
            addCriterion("scid not like", value, "scid");
            return (Criteria) this;
        }

        public Criteria andScidIn(List<String> values) {
            addCriterion("scid in", values, "scid");
            return (Criteria) this;
        }

        public Criteria andScidNotIn(List<String> values) {
            addCriterion("scid not in", values, "scid");
            return (Criteria) this;
        }

        public Criteria andScidBetween(String value1, String value2) {
            addCriterion("scid between", value1, value2, "scid");
            return (Criteria) this;
        }

        public Criteria andScidNotBetween(String value1, String value2) {
            addCriterion("scid not between", value1, value2, "scid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}