package db;

import db.exceptions.DbException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DbProperties {
    public static Properties load() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);

            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }
}
