package application.asset.model.entity;

public enum DBProperty {
	AssetAccesser("asset_administrater", "1853"),
	DBAdministrater("progres", "1853");
	private final String user;
	private final String password;
	private final String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
	private final String driverClassName = "org.postgresql.Driver";

	private DBProperty(String user, String password) {
		this.user = user;
		this.password = password;
	}

	public String getUser() {
		return this.user;
	}

	public String getPassword() {
		return this.password;
	}

	public String getURL() {
		return this.url;
	}

	public String getDriverClassName() {
		return this.driverClassName;
	}
}
