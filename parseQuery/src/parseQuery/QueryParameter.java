package parseQuery;

import java.util.List;

public class QueryParameter {

	List<String> fields;
	String filePath;
	Criteria criteria;
	String  expressions;
	
	String groupby;
	String having;
	String orderby;

	public String getExpressions() {
		return expressions;
	}

	public void setExpressions(String expressions) {
		this.expressions = expressions;
	}

	public String getGroupby() {
		return groupby;
	}

	public void setGroupby(String groupby) {
		this.groupby = groupby;
	}

	public String getHaving() {
		return having;
	}

	public void setHaving(String having) {
		this.having = having;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public void display() {
		System.out.println(filePath);
	}
}
