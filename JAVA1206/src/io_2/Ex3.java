package io_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 자바의 기본 데이터 입출력
		 * - DataInputStream, DataOutputStream 사용
		 *   => 메모리에 저장된 0, 1 상태를 그대로 읽거나 쓸 때 사용
		 *   => 자료형의 크기가 그대로 보존됨
		 * - 자바의 기본데이터입 8가지 + 문자열(String) 타입 처리 가능
		 *   => readXXX(), writeXXX() 메서드를 사용하며 XXX 은 기본 데이터타입의 이름 사용
		 *   ex) int형 데이터 출력시 : writeInt()
		 *       double형 데이터 입력시 : readDouble()
		 *   => 주의! String 타입은 XXX 부분에 String 대신 UTF 사용
		 *   ex) readString() 메서드(X) -> readUTF() 메서드(O)
		 *   
		 * - 주의사항
		 *   1) 반드시 두 객체 끼리만 데이터 입출력 가능
		 *   2) 입출력 시 각각의 순서에 따라 처리해야함
		 *   ex) int, char, String 순으로 출력시 int, char, String 순으로 입력해야 함
		 *   
		 * < 기본 문법 >
		 * 1. 기본 데이터 출력
		 *   DataOutputStream dos = new DataOutputStream(바이트 스트림 객체);
		 *   dos.writeXXX(데이터);
		 *   
		 * 2. 기본 데이터 입력
		 *   DataInputStream dis = new DataInputStream(바이트 스트림 객체);
		 *   dis.readXXX(데이터);
		 */
		
		// 자바 기본 데이터를 파일로 출력하기
		// 1. FileOutputStream 객체를 생성하여 출력할 파일 위치 및 파일명 지정
//		FileOutputStream fos = new FileOutputStream("C://temp/data5.txt");
		
		// 2. DataOutputStream 객체를 생성하여 FileOutputStream 객체를 전달
//		DataOutputStream dos = new DataOutputStream(fos);
		
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("C://temp/data5.txt"))) {
			// DataOutputStream 객체를 통해 출력되는 데이터는
			// C 드라이브 temp 폴더 내의 data5.txt 파일에 출력됨(기록됨)
			// => dos.writeXXX() 메서드를 호출하여 기본 데이터 출력
			dos.writeInt(100); // int형 정수 출력
			dos.writeDouble(3.14); // doube형 실수 출력
			dos.writeUTF("홍길동"); // 문자열 출력(주의! writeString() 메서드 아님!)
		} catch (FileNotFoundException e) {
			// FileOutputStream 에서 지정한 경로가 존재하지 않을 경우 예외 발생
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("--------------------------------------------------------");
		
		// 파일에 출력된 자바 기본데이터를 읽어와서 화면에 출력하기
		try(DataInputStream dis = new DataInputStream(new FileInputStream("C://temp/data5.txt"))){
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}










