package org.apache.flink;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.datalog.BatchDatalogEnvironment;
import org.apache.flink.table.api.Table;


//anticipated program structure for BATCH data api.. subject to lots of changes.

public class TransitiveClosureTest {
	public static void main(String[] args) {
		ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
		BatchDatalogEnvironment datalogEnv = BatchDatalogEnvironment.create(env);
		DataSource<Tuple2<String, String>> dataSet = env.fromElements( new Tuple2<String, String>("a", "b"),new Tuple2<String, String>("b", "c"),new Tuple2<String, String>("c", "c"),new Tuple2<String, String>("c", "d"));
		datalogEnv.registerDataSet("graph", dataSet, "v1, v2");
		String inputProgram =
			"abc(X,Y) :- graph(X, Y).\n" +
				"abc(X,Y) :- abc(X,Z),graph(Z,Y).";

//		datalogEnv.evaluateDatalogRules(inputProgram);
		Table queryResult = datalogEnv.datalogQuery(inputProgram, "abc(X,Y)?"); //not sure whether to return DataSet(DataStream in case of streaming) or Table
		try {
			datalogEnv.toDataSet(queryResult,Tuple2.class).collect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
