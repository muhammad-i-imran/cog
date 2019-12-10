/*
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.apache.flink.datalog.planner.calcite;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.table.api.TableConfig;
import org.apache.flink.table.catalog.CatalogManager;
import org.apache.flink.table.catalog.FunctionCatalog;
import org.apache.flink.table.planner.calcite.FlinkContextImpl;

/**
 *
 */
public class FlinkDatalogContextImpl extends FlinkContextImpl implements FlinkDatalogContext {

	private ExecutionEnvironment executionEnvironment;

	public FlinkDatalogContextImpl(TableConfig tableConfig, FunctionCatalog functionCatalog, CatalogManager catalogManager, ExecutionEnvironment executionEnvironment) {
		super(tableConfig, functionCatalog, catalogManager);
		this.executionEnvironment = executionEnvironment;
	}

	@Override
	public ExecutionEnvironment getExecutionEnvironment() {
		return this.executionEnvironment;
	}
}
