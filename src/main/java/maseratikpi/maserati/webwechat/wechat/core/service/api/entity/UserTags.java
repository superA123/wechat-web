package maseratikpi.maserati.webwechat.wechat.core.service.api.entity;

/**
 * 用户标签
 * 
 * @author Clark
 * @version 2016-11-29
 */
public class UserTags extends BaseModel {
	private int id;
	private String name;
	private int count;

	public UserTags() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "UserTags [id=" + id + ", name=" + name + ", count=" + count + "]";
	}
}
