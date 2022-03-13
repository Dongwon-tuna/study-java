package java_study_2022;

import java.util.Arrays;

//������ �����ִ� class---------------------------------------------------------------------------------------------------------------

class warmap{ 
	static int [][] map = new int [10][10];
	int row1, row2, col1, col2;

	public static void lookmap() {		//������ ���� ǥ��
		map[2][3] = 1;//���ֽ�
		map[2][0] = 1;//��ȭ��
		map[4][3] = 1;//����
		map[3][5] = 1;//�����ν�
		map[0][6] = 1;//����õ��
		map[0][8] = 1;//��õ��
		map[4][7] = 1;//������1
		map[4][8] = 1;//������2
		map[5][7] = 1;//������3
	
		for (int i = 0; i < map.length; i++) {
			int[] inArr = map[i];
			for (int j = 0; j < inArr.length; j++) {
				System.out.print(inArr[j] + " ");
			}
			System.out.println();
		}

	}
	
	public void distance(int row1, int col1, int row2,  int col2) {
		this.row1 = row1;
		this.col1 = col1;
		this.row2 = row2;
		this.col2 = col2;
		int dis = this.row1 - this.row2;
		int dis2 = this.col1 - this.col2;
		int dis_square = dis*dis + dis2*dis2;
		System.out.println(map[row1][col1] + " " + map[row2][col2] + " " + dis_square);
	}

	
	
}

//������ ������ Ư���� ������ �����ִ� class----------------------------------------------------------------------------------------------------------

class city_settings{
	
	int population; 	//����											
	String power;		//���ݷ�
	String possibility;	//���� �������ɼ�
	String mobility;	//�⵿��
	int line;			//1 == ������, 2 == ������ �����δ� &2�� 3 == �Ĺ� �����δ�
	int row;			//�������� ��
	int col;			//�������� ��

	
	city_settings(){
						//�����ε�
	}
	
	city_settings(int population, String power, String possibility, String mobility, int line,int row, int col){
		this.population = population;
		this.power = power;
		this.possibility = possibility;
		this.mobility = mobility;
		this.line = line;
		this.row = row;
		this.col = col;
		
	}
	

	
}
//���� �˰���
class war_ing{
	public static void area(){
		city_settings paju = new city_settings(200, "L", "H", "M", 1, 2, 3);			//LHM ����Ư��
		city_settings gangwha = new city_settings(100, "H", "L", "M",2, 2, 0);		//HLM ����Ư��
		city_settings goyang = new city_settings(150, "L", "H", "M",2, 4, 3);			//����
		city_settings euijeongbu = new city_settings(150, "L", "H", "M",2, 3, 5);		//����
		city_settings dongducheon = new city_settings(150, "L", "H", "M",2, 0, 6);	//����
		city_settings pochun = new city_settings(150, "L", "H", "M",2, 0, 8);			//����
		city_settings nam1 = new city_settings(100, "H", "L", "M",3, 4, 7);			//����
		city_settings nam2 = new city_settings(100, "M", "M", "H",3, 4, 8);			//�Ⱙ
		city_settings nam3 = new city_settings(150, "L", "H", "M",3, 5, 7);			//����			
	}
	
	

	
}

//---------------------------------------------------------------------------------------------------------------------------------------------

public class Korean_war_simulation {

	public static void main(String[] args) {
		warmap.lookmap();
		city_settings paju = new city_settings(200, "L", "H", "M", 1, 2, 3);			//LHM ����Ư��
		city_settings gangwha = new city_settings(100, "H", "L", "M",2, 2, 0);		//HLM ����Ư��
		city_settings goyang = new city_settings(150, "L", "H", "M",2, 4, 3);			//����
		city_settings euijeongbu = new city_settings(150, "L", "H", "M",2, 3, 5);		//����
		city_settings dongducheon = new city_settings(150, "L", "H", "M",2, 0, 6);	//����
		city_settings pochun = new city_settings(150, "L", "H", "M",2, 0, 8);			//����
		city_settings nam1 = new city_settings(100, "H", "L", "M",3, 4, 7);			//����
		city_settings nam2 = new city_settings(100, "M", "M", "H",3, 4, 8);			//�Ⱙ
		city_settings nam3 = new city_settings(150, "L", "H", "M",3, 5, 7);			//����
		
		
		
	
		warmap war1 = new warmap();
		war1.distance(paju.row, paju.col, nam1.row, nam1.col);
		
	
		

	}

}
