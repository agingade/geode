/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.apache.geode.connectors.jdbc.internal;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class HikariJdbcDataSource implements JdbcDataSource {

  private final HikariDataSource delegate;

  public HikariJdbcDataSource(ConnectionConfiguration config) {
    HikariDataSource ds = new HikariDataSource();
    ds.setJdbcUrl(config.getUrl());
    ds.setUsername(config.getUser());
    ds.setPassword(config.getPassword());
    ds.setDataSourceProperties(config.getConnectionProperties());
    this.delegate = ds;
  }

  @Override
  public Connection getConnection() throws SQLException {
    return this.delegate.getConnection();
  }

  @Override
  public void close() {
    this.delegate.close();
  }

}
