package com.valtech.traing.valtech_junit5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;



public class ArithmeticTest {
	private Arithmetic arithmetic;
	private static int ZERO;

	
	@Nested
	public  class DivisionTest{
		private Arithmetic arithmetic;

		@Test
		public void testDivbyZero(){
			arithmetic=new ArithmeticImpl();
			assertThrows(ArithmeticException.class, ()->{arithmetic.div(2, ZERO);});
//			assertEquals(res, arithmetic.div(a, b));
		}
	}
	@Nested
	@DisplayName("This is for Testing Sub Method of the Arithmetic")
	public static class SubtractionTest{
		private Arithmetic arithmetic;
		@DisplayName(value="{index}) {0} {1} + {2} ={3}")
		@ParameterizedTest
		@CsvSource({
			"Subtracting 2 Positive No's,2,3,-1",
			"Subtracting 2 Negative No's,-2,-3,1",
			"Subtracting 1 positive and 1 Negative No's,3,-4,7"
			
		})
		@Test
		public void testSub(String name,int a,int b,int res){
			assertEquals(res, arithmetic.sub(a, b));
		}
	
	}
	
	
	public static Stream<Arguments> argumentsforAdd(){
		return Stream.of(Arguments.of(2,3,5),Arguments.of(1,3,4));
	}
	
	@DisplayName("{index}) testing for add with{0} and {1} should be equals {2}")
	@ParameterizedTest
	@MethodSource("argumentsforAdd")

	public void testAdd(int a,int b,int res) {
		assertEquals(res, arithmetic.add(a, b));
	}

	@ParameterizedTest
	@ValueSource(ints={2,3,4,-1,2})
	@DisplayName(value="{index}) Testing for add with {0} and 0")
	private void testaddzero(int a) {
		// TODO Auto-generated method stub
		assertEquals(10,arithmetic.add(a, ZERO));

		
	}
	@DisplayName(value="{index}) {0} {1} + {2} ={3}")
	@ParameterizedTest
	@CsvSource({
		"Adding 2 Positive No's,2,3,5",
		"Adding 2 Negative No's,-2,-3,-5",
		"Adding 1 positive and 1 Negative No's,3,-4,-1"
		
	})

	public void testAdd(String name,int a,int b,int res){
		assertEquals(res, arithmetic.add(a, b));
	}
	@Test
	private void test(){
		assertEquals(10, arithmetic.add(5, 5));
	}
	@BeforeAll
	public static void acecutemeFirst() {
		// TODO Auto-generated method stub
		System.out.println("Before All-Executed First");
		ZERO=0;
	}

	@AfterAll
	public static void acecutemelast() {
		// TODO Auto-generated method stub
		System.out.println("Afer All-Executed First");
		
	}
	@BeforeEach
	public void runbeftest() {
		 arithmetic=new ArithmeticImpl();
		System.out.println("Run before");
	}

	// public void afterTest() {

	// }
	@AfterEach
	public void afterTest() {
		System.out.println("After Each Method");
	}

	@Test
	public void testhi() {
		// TODO Auto-generated method stub
		System.out.println("hiiii");

	}

	@Test
	private void testHello() {
		// TODO Auto-generated method stub
		System.out.println("helloooo");
	}
}
