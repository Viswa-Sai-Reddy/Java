package DateTime;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneDateTimeExample {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        System.out.println(zonedDateTime.getZone());
        System.out.println(zonedDateTime.getOffset());

//        ZoneId.getAvailableZoneIds().stream()
//                .forEach(System.out::println);

        System.out.println(ZonedDateTime.now(ZoneId.of("Indian/Maldives")));
        System.out.println("Zoned Date and Time using Clock: "+ZonedDateTime.now(Clock.system(ZoneId.of("Indian/Maldives"))));
    }
}
