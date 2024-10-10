package Kiosk.common;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

  private String driverClass; // 데이터베이스 드라이버
  private String DB_URL; // 데이터베이스 URL
  private String USER; // 데이터베이스 사용자명
  private String PASS; // 데이터베이스 비밀번호

  /***jdbc.properties파일을 읽어서 데이타베이스 접속정보를 멤버필드에 저장***/
  public DatabaseConnection() throws Exception {
    Properties properties = new Properties();
    InputStream propertiesInput = DatabaseConnection.class.getResourceAsStream("jdbc.properties");

    if (propertiesInput == null) {
      throw new NullPointerException("jdbc.properties file not found");
    }

    try {
      properties.load(propertiesInput);
      this.driverClass = properties.getProperty("driver-class-name");
      this.DB_URL = properties.getProperty("url");
      this.USER = properties.getProperty("username");
      this.PASS = properties.getProperty("password");
    } finally {
      if (propertiesInput != null) {
        propertiesInput.close();
      }
    }
  }

  /***데이타베이스 설정정보를 이용해 Connection객체를 생성해서 반환하는 메쏘드***/
  public Connection getConnection() throws Exception {
    Class.forName(driverClass);
    return DriverManager.getConnection(DB_URL, USER, PASS);
  }

  /***Connection 객체를 close하는 메소드***/
  public void close(Connection con) throws Exception {
    if (con != null && !con.isClosed()) {
      con.close();
    }
  }
}
