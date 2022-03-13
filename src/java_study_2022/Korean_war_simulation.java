package java_study_2022;

import java.util.Arrays;

//지도를 보여주는 class---------------------------------------------------------------------------------------------------------------

class warmap{ 
	static int [][] map = new int [10][10];


	public static void lookmap() {		//지도에 도시 표시
		map[2][3] = 1;//파주시
		map[2][0] = 1;//강화군
		map[4][3] = 1;//고양시
		map[3][5] = 1;//의정부시
		map[0][6] = 1;//동두천시
		map[0][8] = 1;//포천시
		map[4][7] = 1;//남양주1
		map[4][8] = 1;//남양주2
		map[5][7] = 1;//남양주3
	
		for (int i = 0; i < map.length; i++) {
			int[] inArr = map[i];
			for (int j = 0; j < inArr.length; j++) {
				System.out.print(inArr[j] + " ");
			}
			System.out.println();
		}

	}

	
	
}

//도시의 병과의 특성과 병력을 보여주는 class----------------------------------------------------------------------------------------------------------

class city_settings{
	
	int population; 	//병력											
	String power;		//공격력
	String possibility;	//공격 성공가능성
	String mobility;	//기동성
	int line;			//1 == 최전방, 2 == 최전방 지원부대 &2선 3 == 후방 지원부대
	

	
	city_settings(){
						//오버로딩
	}
	
	city_settings(int population, String power, String possibility, String mobility, int line){
		this.population = population;
		this.power = power;
		this.possibility = possibility;
		this.mobility = mobility;
		this.line = line;
		
	}
	

	
}
//전쟁 알고리즘
class war_ing{
	

	
	
}

//---------------------------------------------------------------------------------------------------------------------------------------------

public class Korean_war_simulation {

	public static void main(String[] args) {
		warmap.lookmap();
		city_settings paju = new city_settings(200, "L", "H", "M", 1);			//LHM 보병특성
		city_settings gangwha = new city_settings(100, "H", "L", "M",2);		//HLM 포병특성
		city_settings goyang = new city_settings(150, "L", "H", "M",2);			//보병
		city_settings euijeongbu = new city_settings(150, "L", "H", "M",2);		//보병
		city_settings dongducheon = new city_settings(150, "L", "H", "M",2);	//보병
		city_settings pochun = new city_settings(150, "L", "H", "M",2);			//보병
		city_settings nam1 = new city_settings(100, "H", "L", "M",3);			//포병
		city_settings nam2 = new city_settings(100, "M", "M", "H",3);			//기갑
		city_settings nam3 = new city_settings(150, "L", "H", "M",3);			//보병
		
		System.out.println(nam3.population + " " + nam3.line + " " + nam3.mobility);
		
		/*
		map[2][3] = 1;//파주시
		map[2][0] = 1;//강화군
		map[4][3] = 1;//고양시
		map[3][5] = 1;//의정부시
		map[0][6] = 1;//동두천시
		map[0][8] = 1;//포천시
		map[4][7] = 1;//남양주1
		map[4][8] = 1;//남양주2
		map[5][7] = 1;//남양주3
		*/
		
		
	
		

	}

}
