package javaConcepts.miscellaneous;

public class DummyList {

	public DummyList(String n, int i, int m) {
		name = n;
		id = i;
		mobile = m;
	}

	private String	name;

	private int		id;

	private int		mobile;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the mobile
	 */
	public int getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

}
