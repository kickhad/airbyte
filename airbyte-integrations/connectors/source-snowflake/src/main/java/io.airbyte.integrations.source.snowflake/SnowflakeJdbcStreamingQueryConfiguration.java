/*
 * Copyright (c) 2021 Airbyte, Inc., all rights reserved.
 */

package io.airbyte.integrations.source.snowflake;

import io.airbyte.db.jdbc.JdbcStreamingQueryConfiguration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SnowflakeJdbcStreamingQueryConfiguration implements JdbcStreamingQueryConfiguration {

  @Override
  public void accept(final Connection connection, final PreparedStatement preparedStatement)
      throws SQLException {
    connection.setAutoCommit(false);
    preparedStatement.setFetchSize(1000);
  }
}
