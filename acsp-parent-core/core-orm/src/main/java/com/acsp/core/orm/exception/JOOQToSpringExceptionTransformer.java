package com.acsp.core.orm.exception;

import org.jooq.ExecuteContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultExecuteListener;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.jdbc.support.SQLStateSQLExceptionTranslator;

/**
 * This class transforms SQLException into a Spring specific DataAccessException. The idea behind
 * this is borrowed from Adam Zell's Gist and was written by: Petri Kainulainen.
 * See this more details: https://gist.github.com/azell/5655888
 * 
 * @author
 */
public class JOOQToSpringExceptionTransformer extends DefaultExecuteListener {

  private static final long serialVersionUID = 3956046966382132958L;

  @Override
  public void exception(ExecuteContext ctx) {

    SQLDialect dialect = ctx.configuration().dialect();
    SQLExceptionTranslator translator = (dialect != null) 
                                      ? new SQLErrorCodeSQLExceptionTranslator(dialect.name())
                                      : new SQLStateSQLExceptionTranslator();

    if ( ctx.sqlException() != null ) {
      ctx.exception(translator.translate("jOOQ", ctx.sql(), ctx.sqlException()));
    }

  }
}
