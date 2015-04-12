package jdkTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStream {

	public static void main(String[] args) {
		
		//-------------------------------------------------------------------------
		String[] strArray = {"a","b"};
		
		//コレクションからStreamインスタンスを生成(Collectionクラス)
		List<String> strs = Arrays.asList(strArray);
		Stream<String> st1 = strs.stream();
		
		//配列からStreamインスタンスを生成(Arraysクラス)
		Stream<String> st2 = Arrays.stream(strArray);
		
		//引数(配列)からStreamインスタンスを生成(Streamクラス)
		Stream<String> st3 = Stream.of(strArray);
		
		st1.forEach(e -> System.out.println("st1:" + e));
		st2.forEach(e -> System.out.println("st2:" + e));
		st3.forEach(e -> System.out.println("st3:" + e));
		//-------------------------------------------------------------------------
		//プリミティブ型は専用のStreamを返す，ラッパー型はStream型を返す
		int[] intArray = {1,2};
		Integer[] integerArray = {1,2};
		
		IntStream stInt = Arrays.stream(intArray);
		Stream<Integer> stInteger = Arrays.stream(integerArray);
		
		stInt.forEach(e -> System.out.println("stInt:" + e));
		stInteger.forEach(e -> System.out.println("stInteger" + e));
		
		Arrays.stream(intArray).forEach(e -> System.out.println("stInt Chain:" + e));
		//-------------------------------------------------------------------------
		//Streamオブジェクトの結合
		Stream<String> st4 = strs.stream();
		Stream<String> st5 = strs.stream();
		Stream<String> stConcat = Stream.concat(st4, st5);
		stConcat.forEach(ee -> System.out.println("stConcat:" + ee));
		//-------------------------------------------------------------------------
		//Collectionから並列処理用Streamを生成
		Stream<String> parallelSt1 = strs.parallelStream();
		//Streamから並列処理用Streamを生成
		Stream<String> parallelSt2 = strs.stream().parallel();
		System.out.println(parallelSt1.isParallel());
		System.out.println(parallelSt2.isParallel());
		
		Stream<String> seqSt = parallelSt1.sequential();
		System.out.println(seqSt.isParallel());
		//-------------------------------------------------------------------------
		//Stream中間処理メソッド
		int[] intArray2 = {1,1,2,3,3,4,4,5,6,7,8,9};
		IntStream stInt2 = Arrays.stream(intArray2);
		IntStream filterSt = stInt2.filter(e -> e%2 == 0);
		filterSt.forEach(e -> System.out.println("filter:" + e));
		IntStream stInt3 = Arrays.stream(intArray2);
		IntStream limitSt = stInt3.limit(2);
		limitSt.forEach(e -> System.out.println("limit:" + e));
		IntStream stInt4 = Arrays.stream(intArray2);
		IntStream distinctSt = stInt4.distinct();
		distinctSt.forEach(e -> System.out.println("distinct:" + e));
		
//		Function<Integer,Stream<Integer>> repeat = n -> Stream.generate(() -> n).limit(n);
//		Function<Integer,Stream<Integer>> repeat = (n) -> Stream.generate(() -> n).limit(n);
//		Function<Integer,Stream<Integer>> repeat = (Integer n) -> Stream.generate(() -> n).limit(n);
		Function<Integer,Stream<Integer>> repeat = (Integer n) -> Stream.generate(() -> n).limit(n);
		repeat.apply(3).forEach(System.out::print);
		
		IntStream.iterate(0,i -> i+1).limit(10).forEach(System.out::println);
	}

}
