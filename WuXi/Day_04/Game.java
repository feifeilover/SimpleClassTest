import java.util.Scanner;

public class Game {
	
	
	public void start(){
		//玩家
		Person p=new Person();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("请选择对家角色。1.蝙蝠侠 2.绿巨人 3.黑寡妇");
		int i=scanner.nextInt();
		
		//对家
		Ai ai=new Ai(i);
		vs(p,ai);
	}
	
	
	public void vs(Person p,Ai ai){
		
		String[] quans={"","剪刀","石头","布"};
		
		int q1=p.chuQuan();
		int q2=ai.chuQuan();
		
		System.out.println("玩家出拳### "+quans[q1]);
		System.out.println(ai.getRole()+"出拳### "+quans[q2]);
		
		if(q1==q2){
			System.out.println("平局");
		}else if((q1==1&&q2==3)||(q1==2&&q2==1)||(q1==3&&q2==2)){
			System.out.println("you win");
		}else{
			System.out.println("you lose");
		}
		
	}
}
