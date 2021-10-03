import java.math.BigDecimal;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public enum TicketType {

    REGULAR(1, "1. Regular ticket", new BigDecimal(0)),
    STUDENT(2, "2. Student", new BigDecimal(90)),
    CHILDREN(3, "3. Children under 7y", new BigDecimal(100)),
    DISABLED_PERSON(4, "4. Disabled person", new BigDecimal(100)),
    FAMILY_CARD(5, "5. 3+ family card holder", new BigDecimal(50));

    private final int code;
    private final String info;
    private final BigDecimal discountPercentage;

    TicketType(int code, String info, BigDecimal discountPercentage) {
        this.code = code;
        this.info = info;
        this.discountPercentage = discountPercentage;
    }

    public static int getValidTicketCode() {

        TicketType.printInfo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the ticket type (select from 1 to 5): ");
            int ticketCode = scanner.nextInt();
            if (ticketCode <= 5 && ticketCode > 0) {
                return ticketCode;
            } else {
                System.out.println("[!] Entered ticket type is not valid.");
            }
        }
    }

    public int getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public static TicketType getByCode(int code) {
        for (TicketType ticketType : values()) {
            if (Objects.equals(ticketType.getCode(), code)) {
                return ticketType;
            }
        }
        return null;
    }

    public static void printInfo() {
        Stream.of(TicketType.values()).forEach(ticketType -> System.out.println("\t" + ticketType.getInfo()));
    }
}
