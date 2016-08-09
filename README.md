# testSpringMVC

maven Profiles are configured : dev and product, one of which must be choosed before running the server.

tomcat plugin:
          <plugin>
            <groupId>org.apache.tomcat.maven</groupId>
            <artifactId>tomcat7-maven-plugin</artifactId>
            <version>2.2</version>
            <configuration>
              <path>/</path>
              <port>8086</port>
              <uriEncoding>utf-8</uriEncoding>
            </configuration>
          </plugin>
          
    configure: add maven -->
                        working directory: web directory
                        command line: clean tomcat7:run
                        Profiles: dev