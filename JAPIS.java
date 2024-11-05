// Project #1, Just A good Planet Information System

import java.util.Scanner;

// main

public class midtermClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String planetData[][] = new String[10][5]; // 이름, 반지름, 자전 주기, 공전 주기, 태양으로부터의 거리 데이터를 저장하는 2차원 배열
        int planetCount[] = new int[1]; // 입력된 행성의 개수를 저장하는 1차원 배열


        String planetName[] = new String[planetCount[0]]; // 2차원 배열 planetData[][]을 별도의 배열로 저장 (String)

        for (int i = 0; i < planetCount[0]; i++) {
            planetName[i] = planetData[i][0];
        }

        double planetRadius[] = new double[planetCount[0]]; // 2차원 배열 planetData[][]을 별도의 배열로 저장 (double)

        for (int i = 0; i < planetCount[0]; i++) {
            planetRadius[i] = Double.parseDouble(planetData[i][1]);
        }
        
        double rotationPeriod[] = new double[planetCount[0]]; // 2차원 배열 planetData[][]을 별도의 배열로 저장 (double)

        for (int i = 0; i < planetCount[0]; i++) {
            rotationPeriod[i] = Double.parseDouble(planetData[i][2]);
        }

        double revolutionPeriod[] = new double[planetCount[0]]; // 2차원 배열 planetData[][]을 별도의 배열로 저장 (double)

        for (int i = 0; i < planetCount[0]; i++) {
            revolutionPeriod[i] = Double.parseDouble(planetData[i][3]);
        }

        double distancefromSun[] = new double[planetCount[0]]; // 2차원 배열 planetData[][]을 별도의 배열로 저장 (double)

        for (int i = 0; i < planetCount[0]; i++) {
            distancefromSun[i] = Double.parseDouble(planetData[i][4]);
        }
        
        inputPlanetData(scanner, planetData, planetCount); // main 하위 메서드인 public static void inputPlanetData(...)을 모듈화 함.

        System.out.println("JAPIS에게 묻고 싶은 정보는?"
                + "\n1: 태양과 가장 가까운 행성"
                + "\n2: 태양과 가장 먼 행성"
                + "\n3: 행성들의 태양과의 평균 거리"
                + "\n4: 반지름이 가장 큰 행성"
                + "\n5: 자전 주기가 가장 짧은 행성");

        int option = scanner.nextInt(); // 옵션 1부터 옵션 5까지 입력 받음
        switch (option) {
            case 1:
                closestPlanet(planetData, planetCount[0]);
                break;
                
            case 2:
            	fartestPlanet(planetData, planetCount[0]);
            	break;
            	
            case 3:
            	avgDistance(planetData, planetCount[0]);
            	break;
            	
            case 4:
            	largestRadius(planetData, planetCount[0]);
            	break;
            	
            case 5:
            	shortestRtPeriod(planetData, planetCount[0]);
            	break;
            	
            default:
                System.out.println("-1"); // 옵션 이외 정수 값 입력 시 -1 출력
                break;
        }

        scanner.close();
    }

    // end of line 
    
    
    // 행성의 데이터를 일렬로 받아 2차원 배열에 저장하는 inputPlanetData 메서드
    
    public static void inputPlanetData(Scanner scanner, String planetData[][], int planetCount[]) {
        int i = 0;
        System.out.println("행성 데이터를 다음 형식으로 입력하세요:\n" 
                        + "이름 반지름(km) 자전주기(일) 공전주기(일)\n"
                        + "태양으로부터 거리(km)\n"
                        + "입력을 종료하려면 'end'를 입력하세요:");

        while (i < 10) {
            String input = scanner.next();
            if (input.equals("end")) { // input에 end가 포함될 시 입력 중단
                break;
            }

            planetData[i][0] = input; // 행성 이름
            planetData[i][1] = scanner.next(); // 반지름
            planetData[i][2] = scanner.next(); // 자전 주기
            planetData[i][3] = scanner.next(); // 공전 주기
            planetData[i][4] = scanner.next(); // 태양으로부터의 거리

            scanner.nextLine();
            
            i++; // 인덱스를 증가시킴 (행성의 개수 증가)
        }
        planetCount[0] = i; // 최종 행성의 개수를 행성의 개수를 저장하는 1차원 배열의 요소로 저장
    }
    
    // end of line


    // 태양과 가장 가까운 행성의 이름을 출력하는 메서드
    
    public static void closestPlanet(String planetData[][], int planetCount) {
        int closestDistance = 0;

        for (int i = 0; i < planetCount; i++) {
            if (planetData[closestDistance][4].length() < planetData[i][4].length())
                continue;
            else
                closestDistance = i; // 만약 nearestDistance보다 작을 시, i를 nearestDistance에 대입
        }

        String print = planetData[closestDistance][0];

        System.out.print(print);
        
    }


	// end of line


	// 태양과 가장 먼 행성의 이름을 출력하는 메서드

	public static void fartestPlanet(String planetData[][], int planetCount) {
		int fartestDistance = 0;
		
		for (int i = 0; i < planetCount; i++) {
			if (planetData[fartestDistance][4].length() > planetData[i][4].length())
				continue;
			else
				fartestDistance = i; // 만약 fartestDistance보다 클 시, i를 fartestDistance에 대입		
		}
		
		String print = planetData[fartestDistance][0];
		
		System.out.print(print);
	}
	
	// end of line
	
	
	// 행성들의 태양과의 평균 거리를 출력하는 메서드
	
	public static void avgDistance(String planetData[][], int planetCount) {
		double sum = 0;
		
		for (int i = 0; i < planetCount; i++) {
			sum += Double.parseDouble(planetData[i][4]);
		}
		
		double avg = sum / planetCount;
		
		System.out.print(avg);
	}
	
	// end of line
	
	
	// 반지름이 가장 큰 행성의 이름을 출력하는 메서드
	
	public static void largestRadius(String planetData[][], int planetCount) {
		int largestRadius = 0;
		
		for (int i = 0; i < planetCount; i++) {
			if (planetData[largestRadius][1].length() > planetData[i][1].length())
				continue;
			else
				largestRadius = i; // 만약 largestRadius보다 클 시, i를 largestRadius에 대입
		}
		
		String print = planetData[largestRadius][0];
		
		System.out.print(print);
	}
	
	// end of line
	
	
	// 자전 주기가 가장 짧은 행성의 이름을 출력하는 메서드
	
	public static void shortestRtPeriod(String planetData[][], int planetCount) {
		int shortestRtPeriod = 0;
		
		for (int i = 0; i < planetCount; i++) {
			if (planetData[shortestRtPeriod][2].length() < planetData[i][2].length())
				continue;
			else
				shortestRtPeriod = i; // 만약 shortestRtPeriod보다 작을 시, i를 shortestPeriod에 대입
		}
		
		String print = planetData[shortestRtPeriod][0];
		
		System.out.print(print);
	}
	
	// end of line
	
	
}


// end of project #1