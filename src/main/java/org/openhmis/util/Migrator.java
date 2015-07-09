package org.openhmis.util;
import java.net.URI;

import org.flywaydb.core.Flyway;

class Migrator {
  public static void main(String[] args) throws Exception {
    // Migrations require a session to work
    if(System.getenv("DATABASE_URL") != null) {
        Flyway flyway = new Flyway();
        URI envDbUri = new URI(System.getenv("DATABASE_URL"));
        String username = envDbUri.getUserInfo().split(":")[0];
        String password = envDbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:" + envDbUri.getScheme() + "://" + envDbUri.getHost() + ':' + envDbUri.getPort() + envDbUri.getPath();

        flyway.setDataSource(dbUrl, username, password);
        flyway.migrate();
    }
  }
}