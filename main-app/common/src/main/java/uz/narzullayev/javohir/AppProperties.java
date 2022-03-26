package uz.narzullayev.javohir;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.properties", ignoreUnknownFields = false)
@Data
public class AppProperties {

    final FileStorage fileStorage = new FileStorage();
    final JmsProps jms = new JmsProps();
    final Email email = new Email();

    @Data
    public static class FileStorage {
        String uploadFolder;
    }

    @Data
    public static class JmsProps {
        String contentCheckerRequestQueue;
        String contentCheckerCallBackResponseQueue;
    }

    @Data
    public static class Email {
        String authorNotificationsFromEmail = "narzullayevj@gmail.com";
        String authorNotificationsFromName = "Narzullayev Javohir";
    }

}

