
public class Ai {
	private String role;

	
	public Ai(int key){
		switch (key) {
		case 1:
			this.role="蝙蝠侠";
			break;
		case 2:
			this.role="绿巨人";
			break;
		case 3:
			this.role="黑寡妇";
			break;
		default:
			this.role="大侠";
			break;
		}
	}
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int chuQuan() {
		int quan = (int) (Math.random() * 3 + 1);
		return quan;
	}

}
