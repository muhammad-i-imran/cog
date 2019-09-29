package org.apache.flink.datalog;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.table.api.TableConfig;
import org.apache.flink.table.api.TableEnvironment;
import org.apache.flink.table.catalog.Catalog;
import org.apache.flink.table.catalog.CatalogManager;
import org.apache.flink.table.catalog.exceptions.DatabaseNotExistException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface DatalogEnvironment extends TableEnvironment {

	void loadDatabase(String text);

	void datalogQuery(String query);

	void clearState();

}
